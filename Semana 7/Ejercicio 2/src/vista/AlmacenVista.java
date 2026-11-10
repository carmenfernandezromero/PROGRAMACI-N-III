package vista;

import java.util.Scanner;
import controlador.AlmacenControlador;

public class AlmacenVista {
    private AlmacenControlador controlador;
    private Scanner scanner = new Scanner(System.in);

    public void setControlador(AlmacenControlador controlador) {
        this.controlador = controlador;
    }

    public void mostrarMenu() {
        String opcion;
        do {
            System.out.println("\n========================================");
            System.out.println("   GESTIÓN DE VENTAS Y ALMACENES (MVC)   ");
            System.out.println("========================================");
            System.out.println("1 .- Leer tabla de ventas");
            System.out.println("2 .- Leer tabla de precios");
            System.out.println("3 .- Calcular ingresos totales");
            System.out.println("4 .- Mostrar resultados");
            System.out.println("q .- Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextLine().trim();

            switch (opcion) {
                case "1" -> leerVentas();
                case "2" -> leerPrecios();
                case "3" -> calcular();
                case "4" -> mostrarResultados();
                case "q", "Q" -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida.");
            }
        } while (!opcion.equalsIgnoreCase("q"));
    }

    private void leerVentas() {
        int[][] ventas = new int[5][2];
        System.out.println("\n--- LECTURA DE VENTAS POR ALMACÉN ---");
        for (int i = 0; i < 5; i++) {
            System.out.println("Almacén " + (i + 1) + ":");
            ventas[i][0] = leerEnteroPositivo("  Unidades del Producto 1: ");
            ventas[i][1] = leerEnteroPositivo("  Unidades del Producto 2: ");
        }
        controlador.registrarVentas(ventas);
        System.out.println("Tabla de ventas registrada correctamente");
    }

    private void leerPrecios() {
        double[] precios = new double[2];
        System.out.println("\n--- LECTURA DE PRECIOS DE PRODUCTOS ---");
        precios[0] = leerDoublePositivo("Precio de una unidad del Producto 1 (€): ");
        precios[1] = leerDoublePositivo("Precio de una unidad del Producto 2 (€): ");
        controlador.registrarPrecios(precios);
        System.out.println("¡Tabla de precios registrada correctamente!");
    }

    private void calcular() {
        if (!controlador.sePuedenCalcularIngresos()) {
            System.out.println("ERROR: Debes leer tanto las ventas (opción 1) como los precios (opción 2) antes de calcular.");
            return;
        }
        controlador.ejecutarCalculo();
        System.out.println("¡Ingresos totales calculados con éxito!");
    }

    private void mostrarResultados() {
        if (!controlador.sePuedenMostrarResultados()) {
            System.out.println("ERROR: Debes realizar el cálculo de ingresos (opción 3) antes de mostrar los resultados.");
            return;
        }

        double[] ingresosAlmacen = controlador.obtenerIngresosPorAlmacen();
        double total = controlador.obtenerIngresosTotales();

        System.out.println("\n--- RESULTADOS DE VENTAS E INGRESOS ---");
        for (int i = 0; i < 5; i++) {
            System.out.printf("Almacén %d: %.2f €%n", (i + 1), ingresosAlmacen[i]);
        }
        System.out.println("----------------------------------------");
        System.out.printf("INGRESOS TOTALES DE LA COMPAÑÍA: %.2f €%n", total);
    }

    private int leerEnteroPositivo(String mensaje) {
        int val;
        do {
            System.out.print(mensaje);
            try {
                val = Integer.parseInt(scanner.nextLine().trim());
                if (val < 0) System.out.println("Debe introducir una cantidad mayor o igual a 0.");
            } catch (NumberFormatException e) {
                val = -1;
                System.out.println("Error: Ingrese un número entero válido.");
            }
        } while (val < 0);
        return val;
    }

    private double leerDoublePositivo(String mensaje) {
        double val;
        do {
            System.out.print(mensaje);
            try {
                val = Double.parseDouble(scanner.nextLine().trim().replace(',', '.'));
                if (val <= 0) System.out.println("El precio debe ser un número positivo mayor que 0.");
            } catch (NumberFormatException e) {
                val = -1;
                System.out.println("Error: Ingrese un número válido.");
            }
        } while (val <= 0);
        return val;
    }
}