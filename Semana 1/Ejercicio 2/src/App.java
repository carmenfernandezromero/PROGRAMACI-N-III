import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el primer número entero: ");
        int num1 = sc.nextInt();

        System.out.print("Introduce el segundo número entero: ");
        int num2 = sc.nextInt();

        int suma = num1 + num2;

        System.out.printf("La suma de %d y %d es: %d\n", num1, num2, suma);

        sc.close();
    }
}