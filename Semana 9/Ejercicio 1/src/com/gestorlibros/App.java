package com.gestorlibros;

import com.gestorlibros.controller.Controller;
import com.gestorlibros.model.GestorLibrosModel;
import com.gestorlibros.view.View;

public class App {
    public static void main(String[] args) throws Exception {
        GestorLibrosModel m = new GestorLibrosModel();
        View v = new View();
        Controller c = new Controller(m, v);

        c.initApp();
    }
}