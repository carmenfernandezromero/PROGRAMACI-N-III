package controller;

import java.util.ArrayList;
import model.Factura;
import model.FacturaModel;
import view.FacturaView;

public class FacturaController {
    private FacturaView view;
    private FacturaModel model;

    public FacturaController(FacturaView view, FacturaModel model) {
        this.view = view;
        this.model = model;
    }

    public void run() {
        String msg = model.cargarFacturas();
        view.mostrarMensaje(msg);
        view.mostrarMenu();
    }

    public ArrayList<Factura> obtenerTodas() {
        return model.getFacturas();
    }

    public ArrayList<Factura> obtenerMayoresQue(double minimo) {
        return model.filtrarPorMinimo(minimo);
    }

    public String exportarCSV() {
        return model.exportarCSV();
    }

    public String exportarHTML() {
        return model.exportarHTML();
    }
}