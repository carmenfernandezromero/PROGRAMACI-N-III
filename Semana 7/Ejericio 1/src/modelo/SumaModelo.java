package modelo;

public class SumaModelo {
    private int numero1;
    private int numero2;
    private int resultado;

    public void setNumeros(int n1, int n2) {
        this.numero1 = n1;
        this.numero2 = n2;
    }

    public void calcularSuma() {
        this.resultado = this.numero1 + this.numero2;
    }

    public int getResultado() {
        return resultado;
    }
}