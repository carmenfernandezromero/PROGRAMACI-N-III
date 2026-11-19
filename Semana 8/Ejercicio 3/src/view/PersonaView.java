package view;

import controller.PersonaController;
import es.usal.progiii.tools.Esdia;
import java.util.ArrayList;
import model.Persona;

public class PersonaView {
    private PersonaController controller;

    public void setController(PersonaController controller) {
        this.controller = controller;
    }

    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }

    public void mostrarMenu() {
        int opcion;
        boolean salir = false;
        do {
            System.out.println("\n--- GESTIÓN DE PERSONAS ---");
            System.out.println("1. Importar desde fichero TSV del Escritorio");
            System.out.println("2. Mostrar tabla de personas");
            System.out.println("3. Salir");
            opcion = Esdia.readInt("Elige una opción: ");

            switch (opcion) {
                case 1:
                    importarTSV();
                    break;
                case 2:
                    mostrarTabla();
                    break;
                case 3:
                    String confirmacion = Esdia.readString("¿Estás seguro de que quieres salir? (s/n): ");
                    if (confirmacion.equalsIgnoreCase("s")) {
                        salir = true;
                        System.out.println("Saliendo...");
                    }
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (!salir);
    }

    private void importarTSV() {
        String nombreFichero = Esdia.readString("Introduce el nombre del fichero TSV (ej. datos.txt): ");
        String resultado = controller.importarFichero(nombreFichero);
        System.out.println(resultado);
    }

    private void mostrarTabla() {
        ArrayList<Persona> lista = controller.obtenerPersonas();
        if (lista.isEmpty()) {
            System.out.println("No hay personas cargadas en el sistema.");
            return;
        }
        System.out.println("\n------------------------------------------------------------");
        System.out.println(Persona.getCabeceraTabla());
        System.out.println("------------------------------------------------------------");
        for (Persona p : lista) {
            System.out.println(p.asFilaTabla());
        }
        System.out.println("------------------------------------------------------------");
    }
}