package model;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PersonaModel {
    private ArrayList<Persona> personas;
    private String rutaDesktop;

    public PersonaModel() {
        this.personas = new ArrayList<>();
        this.rutaDesktop = Paths.get(System.getProperty("user.home"), "Desktop", "datos").toString();
    }

    public String importarDesdeFichero(String nombreFichero) {
        Path ruta = Paths.get(rutaDesktop, nombreFichero);
        File f = ruta.toFile();
        if (!f.exists() || !f.isFile()) {
            return "No se encontró el fichero '" + nombreFichero + "' en el Escritorio.";
        }
        try {
            List<String> lineas = Files.readAllLines(ruta, StandardCharsets.UTF_8);
            int cargadas = 0;
            for (String linea : lineas) {
                Persona p = Persona.fromDelimitedString(linea, "\t");
                if (p != null) {
                    personas.add(p);
                    cargadas++;
                }
            }
            return "Se han cargado " + cargadas + " personas desde " + nombreFichero + ".";
        } catch (IOException e) {
            return "Error al leer el fichero " + nombreFichero + ": " + e.getMessage();
        }
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }
}