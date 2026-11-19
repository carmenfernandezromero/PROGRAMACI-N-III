package model;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

public class ListaDeClaseModel {
    private ArrayList<Alumno> alumnos;
    private Random rand;
    private Path rutaDesktop;

    public ListaDeClaseModel() {
        this.alumnos = new ArrayList<>();
        this.rand = new Random();
        this.rutaDesktop = Paths.get(System.getProperty("user.home"), "Desktop");
        generarListaAleatoria(10);
    }

    public void generarListaAleatoria(int cantidad) {
        alumnos.clear();
        for (int i = 0; i < cantidad; i++) {
            alumnos.add(Alumno.generarAleatorio(rand));
        }
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public String exportarDatosPersonalesCSV() {
        Path ruta = rutaDesktop.resolve("datos_personales.csv");
        ArrayList<String> lineas = new ArrayList<>();
        lineas.add("Nombre,Apellidos,Edad,NIF");
        for (Alumno a : alumnos) {
            lineas.add(a.getDatosPersonales().asDelimitedString(","));
        }
        try {
            Files.write(ruta, lineas, StandardCharsets.UTF_8);
            return "Exportado correctamente en: " + ruta.toString();
        } catch (IOException e) {
            return "Error al exportar CSV: " + e.getMessage();
        }
    }

    public String exportarDireccionesCSV() {
        Path ruta = rutaDesktop.resolve("direcciones.csv");
        ArrayList<String> lineas = new ArrayList<>();
        lineas.add("Calle,Numero,Piso,Letra");
        for (Alumno a : alumnos) {
            lineas.add(a.getDireccion().asDelimitedString(","));
        }
        try {
            Files.write(ruta, lineas, StandardCharsets.UTF_8);
            return "Exportado correctamente en: " + ruta.toString();
        } catch (IOException e) {
            return "Error al exportar CSV: " + e.getMessage();
        }
    }

    public String exportarListaCompletaTSV() {
        Path ruta = rutaDesktop.resolve("lista_clase.tsv");
        ArrayList<String> lineas = new ArrayList<>();
        for (Alumno a : alumnos) {
            lineas.add(a.asDelimitedString("\t"));
        }
        try {
            Files.write(ruta, lineas, StandardCharsets.UTF_8);
            return "Lista completa exportada en: " + ruta.toString();
        } catch (IOException e) {
            return "Error al exportar TSV: " + e.getMessage();
        }
    }
}