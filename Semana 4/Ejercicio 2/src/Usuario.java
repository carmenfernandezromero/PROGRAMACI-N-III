public class Usuario {
    private String nombre;
    private double peso;
    private double altura;

   
    private Usuario(String nombre, double peso, double altura) {
        this.nombre = nombre;
        this.peso = peso;
        this.altura = altura;
    }

  
    public static Usuario crearDesdeArray(String[] datos) {
        if (datos == null || datos.length < 3) {
            throw new IllegalArgumentException("Se requieren al menos 3 argumentos: Nombre, Peso (kg) y Altura (m).");
        }

        String nombre = datos[0];
        double peso = Double.parseDouble(datos[1]);
        double altura = Double.parseDouble(datos[2]);

        return new Usuario(nombre, peso, altura);
    }

  
    public double calcularIMC() {
        return peso / (altura * altura);
    }

  
    public String getNombre() {
        return nombre;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }
}