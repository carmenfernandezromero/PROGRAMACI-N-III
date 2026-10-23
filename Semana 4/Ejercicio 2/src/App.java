public class App {
    public static void main(String[] args) {
        try {
            
            Usuario usuario = Usuario.crearDesdeArray(args);

            double imc = usuario.calcularIMC();

            
            System.out.println("-------------------------------------------------------");
            System.out.printf("| %-12s | %-8s | %-10s | %-8s |\n", "NOMBRE", "PESO(kg)", "ALTURA(m)", "IMC");
            System.out.println("-------------------------------------------------------");
            System.out.printf("| %-12s | %-8.2f | %-10.2f | %-8.2f |\n", 
                                usuario.getNombre(), 
                                usuario.getPeso(), 
                                usuario.getAltura(), 
                                imc);
            System.out.println("-------------------------------------------------------");

        } catch (NumberFormatException e) {
            System.err.println("Error: El peso y la altura deben ser valores numéricos válidos (ej. 75.5 1.75).");
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
            System.err.println("Uso: java App <Nombre> <Peso_kg> <Altura_m>");
        }
    }
}
