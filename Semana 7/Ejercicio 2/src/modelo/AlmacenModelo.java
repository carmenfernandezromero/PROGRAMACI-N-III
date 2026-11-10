package modelo;

public class AlmacenModelo {
    private int[][] ventas = new int[5][2];
    private double[] precios = new double[2];
    private double[] ingresosPorAlmacen = new double[5];
    private double ingresosTotales = 0.0;

    private boolean ventasLeidas = false;
    private boolean preciosLeidos = false;
    private boolean calculoRealizado = false;

    public void setVentas(int[][] ventas) {
        this.ventas = ventas;
        this.ventasLeidas = true;
        this.calculoRealizado = false; 
    }

    public void setPrecios(double[] precios) {
        this.precios = precios;
        this.preciosLeidos = true;
        this.calculoRealizado = false; 
    }

    public boolean isVentasLeidas() { return ventasLeidas; }
    public boolean isPreciosLeidos() { return preciosLeidos; }
    public boolean isCalculoRealizado() { return calculoRealizado; }

    public void calcularIngresos() {
        ingresosTotales = 0.0;
        for (int i = 0; i < 5; i++) {
            ingresosPorAlmacen[i] = (ventas[i][0] * precios[0]) + (ventas[i][1] * precios[1]);
            ingresosTotales += ingresosPorAlmacen[i];
        }
        this.calculoRealizado = true;
    }

    public double[] getIngresosPorAlmacen() { return ingresosPorAlmacen; }
    public double getIngresosTotales() { return ingresosTotales; }
    public int[][] getVentas() { return ventas; }
    public double[] getPrecios() { return precios; }
}