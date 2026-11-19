package model;

import java.util.Locale;

public class Factura {
    private String concepto;
    private double descuento;
    private String fecha;
    private double importe;
    private String nif;
    private String nombreCliente;
    private String direccion;
    private double iva;

    public Factura(String concepto, double descuento, String fecha, double importe,
                   String nif, String nombreCliente, String direccion, double iva) {
        this.concepto = concepto;
        this.descuento = descuento;
        this.fecha = fecha;
        this.importe = importe;
        this.nif = nif;
        this.nombreCliente = nombreCliente;
        this.direccion = direccion;
        this.iva = iva;
    }

    public static Factura fromDelimitedString(String linea, String delimitador) {
        String[] trozos = linea.split(delimitador);
        if (trozos.length != 8) {
            return null;
        }
        try {
            String concepto = trozos[0].trim();
            double descuento = Double.parseDouble(trozos[1].trim().replace(",", "."));
            String fecha = trozos[2].trim();
            double importe = Double.parseDouble(trozos[3].trim().replace(",", "."));
            String nif = trozos[4].trim();
            String nombreCliente = trozos[5].trim();
            String direccion = trozos[6].trim();
            double iva = Double.parseDouble(trozos[7].trim().replace(",", "."));

            return new Factura(concepto, descuento, fecha, importe, nif, nombreCliente, direccion, iva);
        } catch (Exception e) {
            return null;
        }
    }

    public double calcularTotal() {
        return importe * (1 - descuento) * (1 + iva);
    }

    public String asCSVString() {
        return String.format(Locale.ENGLISH, "%s,%.2f,%s,%.2f,%s,%s,%s,%.2f,%.2f",
                concepto, descuento, fecha, importe, nif, nombreCliente, direccion, iva, calcularTotal());
    }

    public String asHTMLRow() {
        return String.format(Locale.ENGLISH,
                "<tr><td>%s</td><td>%.2f</td><td>%s</td><td>%.2f</td><td>%s</td><td>%s</td><td>%s</td><td>%.2f</td><td>%.2f</td></tr>",
                concepto, descuento, fecha, importe, nif, nombreCliente, direccion, iva, calcularTotal());
    }

    public String getConcepto() { return concepto; }
    public String getFecha() { return fecha; }
    public String getNif() { return nif; }
    public String getNombreCliente() { return nombreCliente; }
    public String getDireccion() { return direccion; }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "%-15s | %-10s | %-20s | Base: %8.2f | Dto: %.2f | IVA: %.2f | TOTAL: %8.2f",
                nif, fecha, nombreCliente, importe, descuento, iva, calcularTotal());
    }
}