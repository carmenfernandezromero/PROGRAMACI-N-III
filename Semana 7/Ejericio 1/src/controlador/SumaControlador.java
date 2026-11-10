package controlador;

import modelo.SumaModelo;

public class SumaControlador {
    private SumaModelo modelo;

    public SumaControlador(SumaModelo modelo) {
        this.modelo = modelo;
    }

    public void guardarNumeros(int n1, int n2) {
        modelo.setNumeros(n1, n2);
    }

    public void ejecutarCalculo() {
        modelo.calcularSuma();
    }

    public int obtenerResultado() {
        return modelo.getResultado();
    }
}
