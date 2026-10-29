import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {

    private static HashMap<String, Libro> biblioteca = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEnteroEnRango("Seleccione una opción (1-5): ", 1, 5);

            switch (opcion) {
                case 1 -> crearLibro();      
                case 2 -> listarLibros();     
                case 3 -> modificarLibro();   
                case 4 -> eliminarLibro();    
                case 5 -> System.out.println("¡Hasta luego! Gracias por usar la biblioteca.");
            }
            System.out.println();
        } while (opcion != 5);
    }

    private static void mostrarMenu() {
        System.out.println("========================================");
        System.out.println("   GESTIÓN DE BIBLIOTECA (HashMap)      ");
        System.out.println("========================================");
        System.out.println("1) Añadir libro (Create)");
        System.out.println("2) Listar / Consultar libros (Read)");
        System.out.println("3) Modificar libro (Update)");
        System.out.println("4) Eliminar libro (Delete)");
        System.out.println("5) Salir");
        System.out.println("========================================");
    }

    private static void crearLibro() {
        System.out.println("\n--- AÑADIR NUEVO LIBRO ---");
        System.out.print("Introduce el ISBN: ");
        String isbn = scanner.nextLine().trim();

        if (biblioteca.containsKey(isbn)) {
            System.out.println("Error: Ya existe un libro registrado con el ISBN: " + isbn);
            return;
        }

        System.out.print("Título: ");
        String titulo = scanner.nextLine().trim();

        System.out.print("Autor: ");
        String autor = scanner.nextLine().trim();

        int anio = leerEntero("Año de publicación: ");

        biblioteca.put(isbn, new Libro(isbn, titulo, autor, anio));
        System.out.println("¡Libro registrado correctamente!");
    }

    private static void listarLibros() {
        if (biblioteca.isEmpty()) {
            System.out.println("La biblioteca no tiene ningún libro registrado.");
            return;
        }

        System.out.println("\n--- CATÁLOGO DE LA BIBLIOTECA ---");

        for (Libro libro : biblioteca.values()) {
            System.out.println(libro);
        }
    }

    private static void modificarLibro() {
        if (biblioteca.isEmpty()) {
            System.out.println("La biblioteca está vacía.");
            return;
        }

        System.out.print("Introduce el ISBN del libro a modificar: ");
        String isbn = scanner.nextLine().trim();

        Libro libro = biblioteca.get(isbn);

        if (libro == null) {
            System.out.println("No se encontró ningún libro con el ISBN proporcionado.");
            return;
        }

        System.out.println("Modificando: " + libro.getTitulo());
        System.out.print("Nuevo título: ");
        libro.setTitulo(scanner.nextLine().trim());

        System.out.print("Nuevo autor: ");
        libro.setAutor(scanner.nextLine().trim());

        int nuevoAnio = leerEntero("Nuevo año de publicación: ");
        libro.setAnioPublicacion(nuevoAnio);

        System.out.println("¡Datos del libro actualizados con éxito!");
    }

    private static void eliminarLibro() {
        if (biblioteca.isEmpty()) {
            System.out.println("La biblioteca está vacía.");
            return;
        }

        System.out.print("Introduce el ISBN del libro a eliminar: ");
        String isbn = scanner.nextLine().trim();

        Libro borrado = biblioteca.remove(isbn);

        if (borrado != null) {
            System.out.println("El libro '" + borrado.getTitulo() + "' ha sido eliminado del catálogo.");
        } else {
            System.out.println("No se encontró ningún libro con ese ISBN.");
        }
    }

    private static int leerEnteroEnRango(String mensaje, int min, int max) {
        int valor;
        do {
            valor = leerEntero(mensaje);
            if (valor < min || valor > max) {
                System.out.println("Por favor, selecciona una opción entre " + min + " y " + max + ".");
            }
        } while (valor < min || valor > max);
        return valor;
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe introducir un número entero válido.");
            }
        }
    }
}