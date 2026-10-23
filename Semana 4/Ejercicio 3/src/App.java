import fruteria.Producto;
import com.coti.tools.Esdia;

public class App {

    public static void main(String[] args) {

        System.out.println("=== GESTIÓN DE FRUTERÍA ===");

        
        int numeroProductos = Esdia.readInt("Introduzca el número de productos diferentes que vende la frutería: ");

        
        Producto[] productos = new Producto[numeroProductos];

        
        for (int i = 0; i < numeroProductos; i++) {
            String nombreProducto = Esdia.readString("Introduzca el nombre del producto: ");
            double precioSinIVA = Esdia.readDouble("Introduzca el precio por kg sin IVA del producto: ");
            productos[i] = new Producto(nombreProducto, precioSinIVA);
        }

       
        int numeroCliente = 1;
        boolean continuar = true;

        while (continuar) {

           
            for (int i = 0; i < productos.length; i++) {
                double cantidad = Esdia.readDouble("Introduzca la cantidad de " + productos[i].getNombre() + " en kg: ");
                productos[i].setCantidad(cantidad);
            }

           
            mostrarTicket(numeroCliente, productos);

            numeroCliente++;
            continuar = Esdia.siOno("¿Desea continuar? (s/n): ");
        }
    }

    private static void mostrarTicket(int numeroCliente, Producto[] productos) {

        String lineaSeparacion = "+" + "-".repeat(120) + "+";
        String lineaCliente = "| Cliente %-100s | %7s |";

        
        System.out.println(lineaSeparacion);
        System.out.println(String.format(lineaCliente, "", numeroCliente));
        System.out.println(lineaSeparacion);

       
        for (Producto producto : productos) {
            System.out.println(String.format("| %-20.20s | %-10.2f %10.10s | %35.35s %10.2f | %20.2f € |", 
            producto.getNombre(), 
            producto.getCantidad(), "kg",
            "precio Kg con IVA", producto.getPrecioConIVA(),
            producto.getPrecioTotal()));
        }

        
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecioTotalConIVA();
        }
        System.out.println(lineaSeparacion);
        System.out.println(String.format("| %-93s | %20.2f € |", "Total con IVA", total));
        System.out.println(lineaSeparacion);
    }
}