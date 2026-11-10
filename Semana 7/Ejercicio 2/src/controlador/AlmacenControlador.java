package controlador;

import modelo.AlmacenModelo;

public class AlmacenControlador {
    private AlmacenModelo modelo;

    public AlmacenControlador(AlmacenModelo modelo) {
        this.modelo = modelo;
    }

    public void registrarVentas(int[][] ventas) {
        modelo.setVentas(ventas);
    }

    public void registrarPrecios(double[] precios) {
        modelo.setPrecios(precios);
    }

    public boolean sePuedenCalcularIngresos() {
        return modelo.isVentasLeidas() && modelo.isPreciosLeidos();
    }

    public void ejecutarCalculo() {
        modelo.calcularIngresos();
    }

    public boolean sePuedenMostrarResultados() {
        return modelo.isCalculoRealizado();
    }

    public double[] obtenerIngresosPorAlmacen() {
        return modelo.getIngresosPorAlmacen();
    }

    public double obtenerIngresosTotales() {
        return modelo.getIngresosTotales();
    }
}