package modelo;
public class Animal {
    private String nombre;
    private String especie;
    private double pesoKg;
    private double consumoDiarioKg;
    private Cuidador cuidador;

    public Animal(String nombre, String especie, double pesoKg, double consumoDiarioKg, Cuidador cuidador) {
        this.nombre = nombre;
        this.especie = especie;
        this.pesoKg = pesoKg;
        this.consumoDiarioKg = consumoDiarioKg;
        this.cuidador = cuidador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public double getConsumoDiarioKg() {
        return consumoDiarioKg;
    }

    public Cuidador getCuidador() {
        return cuidador;
    }

    public double calcularCosteDiario(double precioPorKg) {
        return this.consumoDiarioKg * precioPorKg;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setConsumoDiario(double consumoDiario) {
        this.consumoDiario = consumoDiario;
    }
}
