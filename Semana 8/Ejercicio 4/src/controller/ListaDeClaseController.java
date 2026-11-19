package controller;

import java.util.ArrayList;
import model.Alumno;
import model.ListaDeClaseModel;
import view.ListaDeClaseView;

public class ListaDeClaseController {
    private ListaDeClaseView view;
    private ListaDeClaseModel model;

    public ListaDeClaseController(ListaDeClaseView view, ListaDeClaseModel model) {
        this.view = view;
        this.model = model;
    }

    public void run() {
        view.mostrarMenu();
    }

    public void regenerarLista(int cantidad) {
        model.generarListaAleatoria(cantidad);
    }

    public ArrayList<Alumno> obtenerAlumnos() {
        return model.getAlumnos();
    }

    public String exportarDatosPersonales() {
        return model.exportarDatosPersonalesCSV();
    }

    public String exportarDirecciones() {
        return model.exportarDireccionesCSV();
    }

    public String exportarTodoTSV() {
        return model.exportarListaCompletaTSV();
    }
}