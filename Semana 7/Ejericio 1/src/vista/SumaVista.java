package vista;

import java.util.Scanner;
import controlador.SumaControlador;

public class SumaVista {
    private SumaControlador controlador;
    private Scanner scanner = new Scanner(System.in);

    public void setControlador(SumaControlador controlador) {
        this.controlador = controlador;
    }

    public void mostrarMenu() {
        String opcion;
        do {
            System.out.println("\n--- MENÚ SUMADOR (MVC) ---");
            System.out.println("1 .- Leer los números");
            System.out.println("2 .- Calcular la suma");
            System.out.println("3 .- Mostrar el resultado");
            System.out.println("q .- Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextLine().trim();

            switch (opcion) {
                case "1" -> leerNumeros();
                case "2" -> calcular();
                case "3" -> mostrarResultado();
                case "q", "Q" -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida.");
            }
        } while (!opcion.equalsIgnoreCase("q"));
    }

    private void leerNumeros() {
        System.out.print("Introduce el primer número entero: ");
        int n1 = Integer.parseInt(scanner.nextLine());
        System.out.print("Introduce el segundo número entero: ");
        int n2 = Integer.parseInt(scanner.nextLine());

        controlador.guardarNumeros(n1, n2);
        System.out.println("Números guardados correctamente.");
    }

    private void calcular() {
        controlador.ejecutarCalculo();
        System.out.println("Suma calculada con éxito.");
    }

    private void mostrarResultado() {
        int res = controlador.obtenerResultado();
        System.out.println("El resultado de la suma es: " + res);
    }
}