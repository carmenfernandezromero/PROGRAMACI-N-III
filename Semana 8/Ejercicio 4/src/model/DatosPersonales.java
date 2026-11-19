package model;

import java.util.Random;

public class DatosPersonales {
    private String nombre;
    private String apellidos;
    private int edad;
    private String nif;

    public DatosPersonales(String nombre, String apellidos, int edad, String nif) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.nif = nif;
    }

    public static DatosPersonales generarAleatorio(Random rand) {
        String[] nombres = {"Alejandro", "Lucía", "Carlos", "Sofía", "Pablo", "Elena", "Javier", "Marta", "David", "Paula"};
        String[] listaApellidos = {"García", "Rodríguez", "González", "Fernández", "López", "Martínez", "Sánchez", "Pérez", "Gómez", "Martín"};
        String letrasNif = "TRWAGMYFPDXBNJZSQVHLCKE";

        String nombre = nombres[rand.nextInt(nombres.length)];
        String ap1 = listaApellidos[rand.nextInt(listaApellidos.length)];
        String ap2 = listaApellidos[rand.nextInt(listaApellidos.length)];
        int edad = 18 + rand.nextInt(13);

        int numDni = 10000000 + rand.nextInt(90000000);
        char letra = letrasNif.charAt(numDni % 23);
        String nif = String.format("%08d%c", numDni, letra);

        return new DatosPersonales(nombre, ap1 + " " + ap2, edad, nif);
    }

    public String asDelimitedString(String delimitador) {
        return nombre + delimitador + apellidos + delimitador + edad + delimitador + nif;
    }

    public String getNombre() { return nombre; }
    public String getApellidos() { return apellidos; }
    public int getEdad() { return edad; }
    public String getNif() { return nif; }
}