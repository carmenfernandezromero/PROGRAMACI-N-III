import es.usal.progiii.tools.Esdia;

public class App {
    public static void main(String[] args) {
        int n = 0;

        do {

            n = Esdia.readInt("Introduce la cantidad de números N (mayor que 0): ");

            if (n <= 0) {
               
                System.err.println("Error: El valor N debe ser estrictamente mayor que cero. Inténtalo de nuevo.");
            }
        } while (n <= 0);

        double suma = 0.0;
        for (int i = 1; i <= n; i++) {
            double numero = Esdia.readDouble("Introduce el número de coma flotante " + i + " de " + n + ": ");
            suma += numero;
        }

        double media = suma / n;
        System.out.printf("%nLa media aritmética de los %d números introducidos es: %.2f%n", n, media);
    }
}
