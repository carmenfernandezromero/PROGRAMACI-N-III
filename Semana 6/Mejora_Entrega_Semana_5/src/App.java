import java.util.Scanner;
import modelo.Animal;
import modelo.Cuidador;
import modelo.Refugio;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static Refugio refugio = new Refugio(); // Inicializamos el refugio con ArrayList

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEnteroEnRango("Seleccione una opción (1-6) : ", 1, 6);

            switch (opcion) {
                case 1 -> anadirNuevoAnimal();         // CREATE
                case 2 -> mostrarInformacion();       // READ
                case 3 -> modificarAnimal();           // UPDATE
                case 4 -> eliminarAnimal();            // DELETE
                case 5 -> configurarPrecioAlimento();  // Configuración de negocio
                case 6 -> System.out.println("Saliendo del programa... ¡Hasta pronto!");
            }
            System.out.println();
        } while (opcion != 6);
    }

    private static void mostrarMenu() {
        System.out.println("----------------------------------------");
        System.out.println("| GESTIÓN DEL REFUGIO (CRUD Colecciones)");
        System.out.println("----------------------------------------");
        System.out.println("| 1) Añadir nuevo animal (Create)");
        System.out.println("| 2) Mostrar animales / Consultar (Read)");
        System.out.println("| 3) Modificar datos de un animal (Update)");
        System.out.println("| 4) Eliminar un animal (Delete)");
        System.out.println("| 5) Configurar precio del alimento por kg");
        System.out.println("| 6) Salir");
        System.out.println("----------------------------------------");
    }


    private static void anadirNuevoAnimal() {
        System.out.println("\n--- DATOS DEL ANIMAL ---");
        System.out.print("Nombre del animal: ");
        String nombreAnimal = scanner.nextLine().trim();

        System.out.print("Especie: ");
        String especie = scanner.nextLine().trim();

        double peso = leerDoublePositivo("Peso en kg (mayor que 0): ");
        double consumo = leerDoublePositivo("Consumo diario en kg (mayor que 0): ");

        System.out.println("\n--- DATOS DEL CUIDADOR ---");
        System.out.print("Nombre del cuidador: ");
        String nombreCuidador = scanner.nextLine().trim();

        System.out.print("Apellidos del cuidador: ");
        String apellidosCuidador = scanner.nextLine().trim();

        boolean formacion = leerBooleano("¿Tiene formación en cuidado animal? (si/no): ");

        Cuidador cuidador = new Cuidador(nombreCuidador, apellidosCuidador, formacion);
        Animal animal = new Animal(nombreAnimal, especie, peso, consumo, cuidador);

        refugio.anadirAnimal(animal);
        System.out.println("¡Animal registrado con éxito!");
    }


    private static void mostrarInformacion() {
        if (refugio.getAnimales().isEmpty()) {
            System.out.println("No hay animales registrados en el refugio.");
            return;
        }

        System.out.println("\n--- LISTA DE ANIMALES REGISTRADOS ---");
        for (Animal a : refugio.getAnimales()) {
            System.out.println(a);
        }
    }


    private static void modificarAnimal() {
        if (refugio.getAnimales().isEmpty()) {
            System.out.println("El refugio está vacío.");
            return;
        }

        System.out.print("Introduce el nombre del animal a modificar: ");
        String nombre = scanner.nextLine().trim();

        Animal animal = refugio.buscarAnimalPorNombre(nombre);
        if (animal == null) {
            System.out.println("No se encontró ningún animal con el nombre: " + nombre);
            return;
        }

        System.out.println("Modificando datos de: " + animal.getNombre());
        double nuevoPeso = leerDoublePositivo("Nuevo peso en kg: ");
        double nuevoConsumo = leerDoublePositivo("Nuevo consumo diario en kg: ");

        animal.setPeso(nuevoPeso);
        animal.setConsumoDiario(nuevoConsumo);

        System.out.println("Datos del animal actualizados con éxito.");
    }


    private static void eliminarAnimal() {
        if (refugio.getAnimales().isEmpty()) {
            System.out.println("El refugio está vacío.");
            return;
        }

        System.out.print("Introduce el nombre del animal a eliminar: ");
        String nombre = scanner.nextLine().trim();

        boolean eliminado = refugio.eliminarAnimalPorNombre(nombre);
        if (eliminado) {
            System.out.println("Animal eliminado correctamente.");
        } else {
            System.out.println("No se encontró ningún animal con el nombre: " + nombre);
        }
    }

    private static void configurarPrecioAlimento() {
        double nuevoPrecio = leerDoublePositivo("Introduzca el nuevo precio del alimento (€/kg): ");
        refugio.setPrecioAlimentoPorKg(nuevoPrecio);
        System.out.printf("Precio actualizado a %.2f €/kg.%n", nuevoPrecio);
    }


    private static int leerEnteroEnRango(String mensaje, int min, int max) {
        int valor;
        do {
            System.out.print(mensaje);
            while (!scanner.hasNextInt()) {
                System.out.print("Error: Ingrese un número entero válido: ");
                scanner.next();
            }
            valor = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
        } while (valor < min || valor > max);
        return valor;
    }

    private static double leerDoublePositivo(String mensaje) {
        double valor;
        do {
            System.out.print(mensaje);
            String entrada = scanner.nextLine().trim().replace(',', '.');
            try {
                valor = Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                valor = -1;
            }
            if (valor <= 0) {
                System.out.println("Error: Debe introducir un número positivo.");
            }
        } while (valor <= 0);
        return valor;
    }

    private static boolean leerBooleano(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String resp = scanner.nextLine().trim().toLowerCase();
            if (resp.equals("si") || resp.equals("s")) return true;
            if (resp.equals("no") || resp.equals("n")) return false;
            System.out.println("Responda 'si' o 'no'.");
        }
    }
}