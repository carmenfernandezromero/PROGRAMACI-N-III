import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String[] textoArray = new String[5];

        System.out.println("=== ORDENADOR DE PALABRAS ===");

        for (int i = 0; i < textoArray.length; i++) {
            System.out.print("Introduce la palabra " + (i + 1) + " de 5: ");
            textoArray[i] = scanner.nextLine();
        }

        Arrays.sort(textoArray);

        System.out.println("\n--- Palabras ordenadas alfabéticamente ---");
        for (String palabra : textoArray) {
            System.out.println("- " + palabra);
        }

        scanner.close();
    }
}