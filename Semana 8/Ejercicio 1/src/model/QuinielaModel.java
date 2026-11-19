package model;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class QuinielaModel {
    private ArrayList<Partido> partidos;
    private Path rutaFichero;

    public QuinielaModel() {
        this.partidos = new ArrayList<>();
        this.rutaFichero = Paths.get(System.getProperty("user.home"), "Desktop", "datos", "equipos.txt");
    }

    public String cargarPartidosIniciales() {
        File fichero = rutaFichero.toFile();
        if (!fichero.exists() || !fichero.isFile()) {
            return "Aviso: No se encontró el fichero equipos.txt en Desktop/datos.";
        }
        try {
            List<String> lineas = Files.readAllLines(rutaFichero, StandardCharsets.UTF_8);
            int cargados = 0;
            for (String linea : lineas) {
                Partido p = Partido.fromDelimitedString(linea, "-");
                if (p != null) {
                    partidos.add(p);
                    cargados++;
                }
            }
            return "Se han cargado " + cargados + " partidos desde equipos.txt.";
        } catch (IOException e) {
            return "Error al leer el fichero: " + e.getMessage();
        }
    }

    public void anadirPartido(Partido p) {
        partidos.add(p);
    }

    public boolean registrarResultado(int indice, int golesLocal, int golesVisitante) {
        if (indice < 0 || indice >= partidos.size()) {
            return false;
        }
        partidos.get(indice).setResultado(golesLocal, golesVisitante);
        return true;
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }
}