package view;

import controller.ListaDeClaseController;
import es.usal.progiii.tools.Esdia;
import java.util.ArrayList;
import model.Alumno;

public class ListaDeClaseView {
    private ListaDeClaseController controller;

    public void setController(ListaDeClaseController controller) {
        this.controller = controller;
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- LISTA DE CLASE ---");
            System.out.println("1. Volver a crear la lista de clase (aleatoria)");
            System.out.println("2. Mostrar tabla de alumnos");
            System.out.println("3. Exportar datos personales (CSV)");
            System.out.println("4. Exportar direcciones (CSV)");
            System.out.println("5. Exportar lista completa (TSV)");
            System.out.println("6. Salir");
            opcion = Esdia.readInt("Elige una opción: ");

            switch (opcion) {
                case 1:
                    regenerar();
                    break;
                case 2:
                    mostrarTabla();
                    break;
                case 3:
                    System.out.println(controller.exportarDatosPersonales());
                    break;
                case 4:
                    System.out.println(controller.exportarDirecciones());
                    break;
                case 5:
                    System.out.println(controller.exportarTodoTSV());
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }

    private void regenerar() {
        int n = Esdia.readInt("¿Cuántos alumnos quieres generar?: ", 1, 200);
        controller.regenerarLista(n);
        System.out.println("Se ha generado una nueva lista con " + n + " alumnos.");
    }

    private void mostrarTabla() {
        ArrayList<Alumno> lista = controller.obtenerAlumnos();
        if (lista.isEmpty()) {
            System.out.println("La lista de clase está vacía.");
            return;
        }
        System.out.println("\n---------------------------------------------------------------------------------------------------------");
        System.out.println(Alumno.getCabeceraTabla());
        System.out.println("---------------------------------------------------------------------------------------------------------");
        for (Alumno a : lista) {
            System.out.println(a.asFilaTabla());
        }
        System.out.println("---------------------------------------------------------------------------------------------------------");
    }
}