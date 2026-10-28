import java.io.Console;

public class App {
    public static void main(String[] args) {

        Console console = System.console();

        if (console == null) {
            System.err.println("No hay consola disponible. Ejecuta este programa directamente desde la terminal.");
            return;
        }

        String textoNacimiento = console.readLine("Introduce tu año de nacimiento: ");
        String textoActual = console.readLine("Introduce el año actual: ");

        int anioNacimiento = Integer.parseInt(textoNacimiento);
        int anioActual = Integer.parseInt(textoActual);

        int edad = anioActual - anioNacimiento;

        System.out.printf("Si naciste en %d y el año actual es %d, tienes %d años.%n", 
                          anioNacimiento, anioActual, edad);
    }
}
