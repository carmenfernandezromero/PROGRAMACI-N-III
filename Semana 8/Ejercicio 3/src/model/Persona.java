package model;

import java.util.Locale;

public class Persona {
    private String nombre;
    private String telefono;
    private float peso;

    public Persona(String nombre, String telefono, float peso) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.peso = peso;
    }

    public static Persona fromDelimitedString(String linea, String delimitador) {
        String[] trozos = linea.split(delimitador);
        if (trozos.length != 3) {
            return null;
        }
        try {
            String nombre = trozos[0].trim();
            String telefono = trozos[1].trim();
            float peso = Float.parseFloat(trozos[2].trim().replace(",", "."));
            return new Persona(nombre, telefono, peso);
        } catch (Exception e) {
            return null;
        }
    }

    public static String getCabeceraTabla() {
        return String.format("| %-25s | %-15s | %-10s |", "NOMBRE", "TELÉFONO", "PESO (kg)");
    }

    public String asFilaTabla() {
        return String.format(Locale.ENGLISH, "| %-25s | %-15s | %10.2f |", nombre, telefono, peso);
    }

    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public float getPeso() { return peso; }
}