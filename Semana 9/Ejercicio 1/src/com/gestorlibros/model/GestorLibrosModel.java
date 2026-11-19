package com.gestorlibros.model;

import java.nio.file.Path;
import java.nio.file.Files;
import java.util.ArrayList;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import es.usal.progiii.tools.Rutas;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GestorLibrosModel {

    ArrayList<Libro> libros;

    Path pathToXML = Rutas.pathToFileOnDesktop("libros.xml");
    Path pathToJSON = Rutas.pathToFileOnDesktop("libros.json");
    Path pathToCSV = Rutas.pathToFileOnDesktop("libros.csv");
    Path pathToBinary = Rutas.pathToFileOnDesktop("libros.bin");

    public GestorLibrosModel() {
        libros = new ArrayList<Libro>();
    }

    public void addLibro(Libro l) {
        libros.add(l);
    }

    public void removeLibro(Libro l) {
        libros.remove(l);
    }

    public void updateLibro(Libro l) {
        int index = libros.indexOf(l);
        if (index != -1) {
             libros.set(index, l);
            }
    }

    public ArrayList<Libro> getLibros() {
        return new ArrayList<Libro>(this.libros);
    }

    public int exportBooksToCSV() {
        ArrayList<String> lines = new ArrayList<>();
        for (Libro l : libros) {
            lines.add(l.asDelimitedString(","));
        }
        try {
            Files.write(pathToCSV, lines, StandardCharsets.UTF_8);
            return libros.size();
        } catch (IOException e) { 
            return -1;
        }
    }

    public int importBooksFromCSV() {
        throw new UnsupportedOperationException("Unimplemented method 'importBooksFromCSV'");
    }

    public int exportBooksToJSON() {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(libros);
            Files.write(pathToJSON, json.getBytes(StandardCharsets.UTF_8));
            return libros.size();
        } catch (IOException e) {
            return -1;
        }
    }

    public int importBooksFromJSON() {
        throw new UnsupportedOperationException("Unimplemented method 'importBooksFromJSON'");
    }

    public int importBooksFromXML() {
        throw new UnsupportedOperationException("Unimplemented method 'importBooksFromXML'");
    }

    public int exportBooksToXML() {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            String xml = xmlMapper.writeValueAsString(libros);
            Files.write(pathToXML, xml.getBytes(StandardCharsets.UTF_8));
            return libros.size();
        } catch (Exception e) {
            return -1;
        }
    }

    public int saveStateOfTheApp() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pathToBinary.toFile()))) {
            oos.writeObject(libros);
            return libros.size();
        } catch (IOException e) {
            return -1;
        }
    }

    public int loadStateOfTheApp() {
        if (!Files.exists(pathToBinary)) {
            return -2;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pathToBinary.toFile()))) {
            libros = (ArrayList<Libro>) ois.readObject();
            return libros.size();
        } catch (Exception e) {
            return -1;
        }
    }
}