package com.gestorlibros.controller;

import java.util.ArrayList;

import com.gestorlibros.model.GestorLibrosModel;
import com.gestorlibros.model.Libro;
import com.gestorlibros.view.View;

public class Controller {

    GestorLibrosModel m;
    View v;

    public Controller(GestorLibrosModel m, View v) {
        this.m = m;
        this.v = v;
        v.setC(this);
    }

    public void initApp() {
        int cargados = m.loadStateOfTheApp();
        if (cargados == -2) {
            v.showInfoMessage("No se ha encontrado el fichero libros.bin en el escritorio. Se inicia una colección vacía.");
        } else if (cargados == -1) {
            v.showErrorMessage("Error al cargar el fichero binario libros.bin.");
        } else {
        v.showInfoMessage("Se han cargado " + cargados + " libros desde libros.bin.");

        }
 
        v.startMenu();

        int guardados = m.saveStateOfTheApp();
        if (guardados == -1) {
            v.showErrorMessage("Error al guardar el estado en libros.bin.");
        } else {
            v.showInfoMessage("Se han guardado " + guardados + " libros en libros.bin.");
        }
    }

    public ArrayList<Libro> getLibros() {
        return m.getLibros();
    }

    public void addLibro(Libro l) {
        m.addLibro(l);
    }

    public void removeLibro(Libro libro) {
        m.removeLibro(libro);
    }

    public void updateLibro(Libro libroAModificar) {
        m.updateLibro(libroAModificar);
    }

    public int exportBooksToCSV() {
        return m.exportBooksToCSV();
    }

    public int exportBooksToJSON() {
        return m.exportBooksToJSON();
    }

    public int importBooksFromJSON() {
        return m.importBooksFromJSON();
    }

    public int importBooksFromCSV() {
        return m.importBooksFromCSV();
    }

    public int importBooksFromXML() {
        return m.importBooksFromXML();
    }

    public int exportBooksToXML() {
        return m.exportBooksToXML();
    }
}