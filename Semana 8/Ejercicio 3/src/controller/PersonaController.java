package controller;

import java.util.ArrayList;
import model.Persona;
import model.PersonaModel;
import view.PersonaView;

public class PersonaController {
    private PersonaView view;
    private PersonaModel model;

    public PersonaController(PersonaView view, PersonaModel model) {
        this.view = view;
        this.model = model;
    }

    public void run() {
        String mensajeInicial = model.importarDesdeFichero("datos.txt");
        view.mostrarMensaje(mensajeInicial);
        view.mostrarMenu();
    }

    public String importarFichero(String nombreFichero) {
        return model.importarDesdeFichero(nombreFichero);
    }

    public ArrayList<Persona> obtenerPersonas() {
        return model.getPersonas();
    }
}