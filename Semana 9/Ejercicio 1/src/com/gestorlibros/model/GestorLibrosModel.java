package com.gestorlibros.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import es.usal.progiii.tools.Rutas;

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
        if (!Files.exists(pathToCSV)) {
            return -2;
        }
        try {
            List<String> lines = Files.readAllLines(pathToCSV, StandardCharsets.UTF_8);
            int added = 0;
            for (String line : lines) {
                Libro l = Libro.fromDelimitedString(line, ",");
                if (l != null && !libros.contains(l)) {
                    libros.add(l);
                    added++;
                }
            }
            return added;
        } catch (IOException e) {
            return -1;
        }
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
        if (!Files.exists(pathToJSON)) {
            return -2;
        }
        try {
            Gson gson = new Gson();
            String json = new String(Files.readAllBytes(pathToJSON), StandardCharsets.UTF_8);
            Type listType = new TypeToken<ArrayList<Libro>>() {}.getType();
            ArrayList<Libro> importedBooks = gson.fromJson(json, listType);
            if (importedBooks == null) {
                return 0;
            }
            int added = 0;
            for (Libro l : importedBooks) {
                if (l != null && !libros.contains(l)) {
                    libros.add(l);
                    added++;
                }
            }
            return added;
        } catch (Exception e) {
            return -1;
        }
    }

    public int importBooksFromXML() {
        if (!Files.exists(pathToXML)) {
            return -2;
        }
        try {
            XmlMapper xmlMapper = new XmlMapper();
            String xml = new String(Files.readAllBytes(pathToXML), StandardCharsets.UTF_8);
            List<Libro> importedBooks = xmlMapper.readValue(xml,
                    xmlMapper.getTypeFactory().constructCollectionType(List.class, Libro.class));
            if (importedBooks == null) {
                return 0;
            }
            int added = 0;
            for (Libro l : importedBooks) {
                if (l != null && !libros.contains(l)) {
                    libros.add(l);
                    added++;
                }
            }
            return added;
        } catch (Exception e) {
            return -1;
        }
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

    @SuppressWarnings("unchecked")
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