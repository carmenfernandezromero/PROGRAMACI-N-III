public class App {
    public static void main(String[] args) {
       
        if (args.length != 2) {
            System.err.println("Error: Debes introducir exactamente 2 argumentos numéricos.");
            System.err.println("Uso: java App <numero1> <numero2>");
            return;
        }

        
        try {
            double numero1 = Double.parseDouble(args[0]);
            double numero2 = Double.parseDouble(args[1]);

            double suma = numero1 + numero2;

            System.out.println("La suma de " + numero1 + " y " + numero2 + " es: " + suma);
        } catch (NumberFormatException e) {
            System.err.println("Error: Uno o ambos argumentos no son números válidos.");
        }
    }
}