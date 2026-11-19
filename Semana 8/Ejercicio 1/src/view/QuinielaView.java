package view;

import es.usal.progiii.tools.Esdia;
import controller.QuinielaController;
import java.util.ArrayList;
import model.Partido;

public class QuinielaView {
    private QuinielaController controller;

    public void setController(QuinielaController controller) {
        this.controller = controller;
    }

    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- QUINIELA DE LA JORNADA ---");
            System.out.println("1. Añadir partido manualmente");
            System.out.println("2. Introducir resultado de un partido");
            System.out.println("3. Mostrar quiniela");
            System.out.println("4. Salir");
            opcion = Esdia.readInt("Elige una opción: ");

            switch (opcion) {
                case 1:
                    pedirNuevoPartido();
                    break;
                case 2:
                    pedirResultado();
                    break;
                case 3:
                    mostrarQuiniela();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }

    private void pedirNuevoPartido() {
        String local = Esdia.readString("Equipo local: ");
        String visitante = Esdia.readString("Equipo visitante: ");
        controller.anadirPartido(local, visitante);
        System.out.println("Partido añadido.");
    }

    private void pedirResultado() {
        mostrarQuiniela();
        ArrayList<Partido> lista = controller.obtenerPartidos();
        if (lista.isEmpty()) return;

        int num = Esdia.readInt("Número de partido (1-" + lista.size() + "): ");
        int gLocal = Esdia.readInt("Goles local: ", 0, 50);
        int gVisitante = Esdia.readInt("Goles visitante: ", 0, 50);

        if (controller.ponerResultado(num, gLocal, gVisitante)) {
            System.out.println("Resultado guardado.");
        } else {
            System.out.println("Número de partido incorrecto.");
        }
    }

    private void mostrarQuiniela() {
        ArrayList<Partido> lista = controller.obtenerPartidos();
        if (lista.isEmpty()) {
            System.out.println("No hay partidos registrados.");
            return;
        }
        System.out.println("\nLISTADO DE PARTIDOS:");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + ". " + lista.get(i).toString());
        }
    }
}
