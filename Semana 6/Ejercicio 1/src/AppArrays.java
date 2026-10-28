import java.util.Scanner;

public class AppArrays {
    private static final int CAPACIDAD_MAXIMA = 100;
    private static Coche[] stock = new Coche[CAPACIDAD_MAXIMA];
    private static int numCoches = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE STOCK (Arrays) ---");
            System.out.println("1. Crear Coche (Create)");
            System.out.println("2. Listar Coches (Read)");
            System.out.println("3. Modificar Coche (Update)");
            System.out.println("4. Eliminar Coche (Delete)");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> crearCoche();
                case 2 -> listarCoches();
                case 3 -> modificarCoche();
                case 4 -> eliminarCoche();
                case 5 -> System.out.println("¡Saliendo!");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    private static void crearCoche() {
        if (numCoches >= CAPACIDAD_MAXIMA) {
            System.out.println("Error: El concesionario está lleno (límite alcanzado).");
            return;
        }

        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Precio: ");
        double precio = Double.parseDouble(scanner.nextLine());

        stock[numCoches] = new Coche(matricula, marca, modelo, precio);
        numCoches++;
        System.out.println("Coche añadido correctamente.");
    }

    private static void listarCoches() {
        if (numCoches == 0) {
            System.out.println("El stock está vacío.");
            return;
        }
        System.out.println("\n--- LISTADO DE COCHES ---");
        for (int i = 0; i < numCoches; i++) {
            System.out.println(stock[i]);
        }
    }

    private static void modificarCoche() {
        System.out.print("Introduce la matrícula del coche a modificar: ");
        String matricula = scanner.nextLine();

        for (int i = 0; i < numCoches; i++) {
            if (stock[i].getMatricula().equalsIgnoreCase(matricula)) {
                System.out.print("Nueva marca: ");
                stock[i].setMarca(scanner.nextLine());
                System.out.print("Nuevo modelo: ");
                stock[i].setModelo(scanner.nextLine());
                System.out.print("Nuevo precio: ");
                stock[i].setPrecio(Double.parseDouble(scanner.nextLine()));
                System.out.println("Coche modificado.");
                return;
            }
        }
        System.out.println("Coche no encontrado.");
    }

    private static void eliminarCoche() {
        System.out.print("Introduce la matrícula del coche a eliminar: ");
        String matricula = scanner.nextLine();

        for (int i = 0; i < numCoches; i++) {
            if (stock[i].getMatricula().equalsIgnoreCase(matricula)) {
                // Desplazamos los elementos a la izquierda para no dejar huecos nulos
                for (int j = i; j < numCoches - 1; j++) {
                    stock[j] = stock[j + 1];
                }
                stock[numCoches - 1] = null; // Limpiamos la última posición
                numCoches--;
                System.out.println("Coche eliminado del stock.");
                return;
            }
        }
        System.out.println("Coche no encontrado.");
    }
}