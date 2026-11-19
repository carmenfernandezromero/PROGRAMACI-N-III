package model;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FacturaModel {
    private ArrayList<Factura> facturas;
    private Path rutaOrigen;
    private Path rutaCSV;
    private Path rutaHTML;

    public FacturaModel() {
        this.facturas = new ArrayList<>();
        String home = System.getProperty("user.home");
        this.rutaOrigen = Paths.get(home, "Desktop", "facturas.tsv");
        this.rutaCSV = Paths.get(home, "Desktop", "facturas_exportadas.csv");
        this.rutaHTML = Paths.get(home, "Desktop", "facturas_exportadas.html");
    }

    public String cargarFacturas() {
        File f = rutaOrigen.toFile();
        if (!f.exists() || !f.isFile()) {
            return "No se encontró el archivo facturas.tsv.";
        }
        try {
            List<String> lineas = Files.readAllLines(rutaOrigen, StandardCharsets.UTF_8);
            facturas.clear();
            for (String linea : lineas) {
                Factura fac = Factura.fromDelimitedString(linea, "\t");
                if (fac != null) {
                    facturas.add(fac);
                }
            }
            return "Se han cargado " + facturas.size() + " facturas.";
        } catch (IOException e) {
            return "Error al leer facturas.tsv: " + e.getMessage();
        }
    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }

    public ArrayList<Factura> filtrarPorMinimo(double minimo) {
        ArrayList<Factura> filtradas = new ArrayList<>();
        for (Factura f : facturas) {
            if (f.calcularTotal() > minimo) {
                filtradas.add(f);
            }
        }
        return filtradas;
    }

    public String exportarCSV() {
        ArrayList<String> lineas = new ArrayList<>();
        lineas.add("Concepto,Descuento,Fecha,Importe,NIF,Cliente,Direccion,IVA,Total");
        for (Factura f : facturas) {
            lineas.add(f.asCSVString());
        }
        try {
            Files.write(rutaCSV, lineas, StandardCharsets.UTF_8);
            return "Facturas exportadas a CSV en: " + rutaCSV.toString();
        } catch (IOException e) {
            return "Error al exportar CSV: " + e.getMessage();
        }
    }

    public String exportarHTML() {
        String plantilla = "<!DOCTYPE html><html><head><meta charset='UTF-8'><title>Facturas</title></head><body>"
                + "<h1>Listado de Facturas</h1>"
                + "<table border='1'>"
                + "<tr><th>Concepto</th><th>Descuento</th><th>Fecha</th><th>Importe</th><th>NIF</th><th>Cliente</th><th>Dirección</th><th>IVA</th><th>Total</th></tr>"
                + "%%TABLA%%"
                + "</table></body></html>";

        StringBuilder filasHTML = new StringBuilder();
        for (Factura f : facturas) {
            filasHTML.append(f.asHTMLRow()).append("\n");
        }

        String htmlFinal = plantilla.replace("%%TABLA%%", filasHTML.toString());

        try {
            Files.write(rutaHTML, htmlFinal.getBytes(StandardCharsets.UTF_8));
            return "Facturas exportadas a HTML en: " + rutaHTML.toString();
        } catch (IOException e) {
            return "Error al exportar HTML: " + e.getMessage();
        }
    }
}