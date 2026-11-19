package view;

import es.usal.progiii.tools.Esdia;
import controller.FacturaController;
import java.util.ArrayList;
import model.Factura;

public class FacturaView {
    private FacturaController controller;

    public void setController(FacturaController controller) {
        this.controller = controller;
    }

    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE FACTURAS ---");
            System.out.println("1. Filtrar clientes con factura mayor a un importe");
            System.out.println("2. Mostrar listado total de facturas");
            System.out.println("3. Exportar facturas a HTML");
            System.out.println("4. Exportar facturas a CSV");
            System.out.println("5. Salir");
            opcion = Esdia.readInt("Elige una opción: ");

            switch (opcion) {
                case 1:
                    filtrarFacturas();
                    break;
                case 2:
                    listarTodas();
                    break;
                case 3:
                    System.out.println(controller.exportarHTML());
                    break;
                case 4:
                    System.out.println(controller.exportarCSV());
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    private void filtrarFacturas() {
        double minimo = Esdia.readDouble("Introduce el importe mínimo de factura: ");
        ArrayList<Factura> filtradas = controller.obtenerMayoresQue(minimo);
        if (filtradas.isEmpty()) {
            System.out.println("No hay facturas que superen ese importe.");
            return;
        }
        System.out.println("\nCLIENTES CON FACTURAS SUPERIORES A " + minimo + ":");
        for (Factura f : filtradas) {
            System.out.printf("- %s (NIF: %s) -> Total: %.2f\n",
                    f.getNombreCliente(), f.getNif(), f.calcularTotal());
        }
    }

    private void listarTodas() {
        ArrayList<Factura> todas = controller.obtenerTodas();
        if (todas.isEmpty()) {
            System.out.println("No hay facturas cargadas.");
            return;
        }
        System.out.println("\nLISTADO TOTAL DE FACTURAS:");
        for (Factura f : todas) {
            System.out.println(f.toString());
        }
    }
}