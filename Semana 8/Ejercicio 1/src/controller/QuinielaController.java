package controller;

import java.util.ArrayList;
import model.Partido;
import model.QuinielaModel;
import view.QuinielaView;

public class QuinielaController {
    private QuinielaView view;
    private QuinielaModel model;

    public QuinielaController(QuinielaView view, QuinielaModel model) {
        this.view = view;
        this.model = model;
    }

    public void run() {
        String mensajeCarga = model.cargarPartidosIniciales();
        view.mostrarMensaje(mensajeCarga);
        view.mostrarMenu();
    }

    public void anadirPartido(String local, String visitante) {
        model.anadirPartido(new Partido(local, visitante));
    }

    public boolean ponerResultado(int numPartido, int golesLocal, int golesVisitante) {
        return model.registrarResultado(numPartido - 1, golesLocal, golesVisitante);
    }

    public ArrayList<Partido> obtenerPartidos() {
        return model.getPartidos();
    }
}