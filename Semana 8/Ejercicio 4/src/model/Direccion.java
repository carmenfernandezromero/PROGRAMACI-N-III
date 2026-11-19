package model;

import java.util.Random;

public class Direccion {
    private String calle;
    private int numero;
    private int piso;
    private String letra;

    public Direccion(String calle, int numero, int piso, String letra) {
        this.calle = calle;
        this.numero = numero;
        this.piso = piso;
        this.letra = letra;
    }

    public static Direccion generarAleatoria(Random rand) {
        String[] calles = {"Calle Toro", "Calle Zamora", "Paseo de Carmelitas", "Avenida de Mirat", "Gran Vía", "Calle Libreros", "Plaza Mayor", "Avenida de Portugal"};
        String[] letras = {"A", "B", "C", "D", "Izq", "Dcha"};

        String calle = calles[rand.nextInt(calles.length)];
        int numero = 1 + rand.nextInt(120);
        int piso = 1 + rand.nextInt(8);
        String letra = letras[rand.nextInt(letras.length)];

        return new Direccion(calle, numero, piso, letra);
    }

    public String asDelimitedString(String delimitador) {
        return calle + delimitador + numero + delimitador + piso + delimitador + letra;
    }

    public String getCalle() { return calle; }
    public int getNumero() { return numero; }
    public int getPiso() { return piso; }
    public String getLetra() { return letra; }
}
