public class App {

    public static void main(String[] args) {

        Person p1 = new Person(); 

        System.out.println("Nombre: " + p1.getNombre());
        System.out.println("Altura: " + p1.getAltura() + " m");
        System.out.println("Peso: " + p1.getPeso() + " kg");

        System.out.println("IMC: " + p1.calcularIMC());
    }
}