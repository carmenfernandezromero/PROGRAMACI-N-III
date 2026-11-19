package model;

import java.util.Random;

public class Alumno {
    private DatosPersonales datosPersonales;
    private Direccion direccion;

    public Alumno(DatosPersonales datosPersonales, Direccion direccion) {
        this.datosPersonales = datosPersonales;
        this.direccion = direccion;
    }

    public static Alumno generarAleatorio(Random rand) {
        return new Alumno(
                DatosPersonales.generarAleatorio(rand),
                Direccion.generarAleatoria(rand)
        );
    }

    public String asDelimitedString(String delimitador) {
        return datosPersonales.asDelimitedString(delimitador) + delimitador + direccion.asDelimitedString(delimitador);
    }

    public static String getCabeceraTabla() {
        return String.format("| %-12s | %-20s | %-4s | %-10s | %-22s | %-4s | %-4s | %-5s |",
                "NOMBRE", "APELLIDOS", "EDAD", "NIF", "CALLE", "NUM", "PISO", "LETRA");
    }

    public String asFilaTabla() {
        return String.format("| %-12s | %-20s | %4d | %-10s | %-22s | %4d | %4d | %-5s |",
                datosPersonales.getNombre(),
                datosPersonales.getApellidos(),
                datosPersonales.getEdad(),
                datosPersonales.getNif(),
                direccion.getCalle(),
                direccion.getNumero(),
                direccion.getPiso(),
                direccion.getLetra());
    }

    public DatosPersonales getDatosPersonales() { return datosPersonales; }
    public Direccion getDireccion() { return direccion; }
}