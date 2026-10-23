public class Person {

   private String nombre = "Nombre por defecto";   
   private double altura = 1.70;                   
   private double peso = 60.0;             

    public Person() {
        nombre = "Sin nombre";
        altura = 0.0;
        peso = 0.0;
    }

    public String getNombre() {
        return nombre;
    }

    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double calcularIMC() {
        if (altura <= 0 || peso <= 0) {
            return -1;
        }

        return peso / (altura * altura);
    }
}

