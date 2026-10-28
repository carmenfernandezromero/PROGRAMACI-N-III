import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce tu año de nacimiento: ");
        int anioNacimiento = scanner.nextInt();

        System.out.print("Introduce el año actual: ");
        int anioActual = scanner.nextInt();

        int edad = anioActual - anioNacimiento;

        System.out.printf("Si naciste en el año %d y el año actual es %d, tienes %d años.%n", 
                          anioNacimiento, anioActual, edad);

        scanner.close();
    }
}