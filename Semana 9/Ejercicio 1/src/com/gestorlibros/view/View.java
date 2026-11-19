package com.gestorlibros.view;

import java.util.ArrayList;

import es.usal.progiii.tools.Esdia;
import com.gestorlibros.controller.Controller;
import com.gestorlibros.model.Libro;

public class View {

    Controller c;

    public void startMenu() {
        boolean exit = false;

        while (!exit) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Mostrar el listado de libros en formato tabla.");
            System.out.println("2. Añadir nuevo libro al modelo.");
            System.out.println("3. Eliminar libro de una lista de libros disponibles.");
            System.out.println("4. Modificar libro de una lista de libros disponibles.");
            System.out.println("5. Exportar libros en formato delimitado por comas CSV.");
            System.out.println("6. Exportar libros en formato JSON.");
            System.out.println("7. Exportar libros en formato XML.");
            System.out.println("8. Importar libros de un fichero JSON.");
            System.out.println("9. Importar libros de un fichero XML.");
            System.out.println("10. Importar libros de un fichero en formato delimitado por comas CSV.");
            System.out.println("11. Salir del programa.");

            int option = Esdia.readInt("Ingrese una opción: ", 1, 11);

            switch (option) {
                case 1:
                    mostrarLibrosModelo(false);
                    break;
                case 2:
                    anadirLibroAlModelo();
                    break;
                case 3:
                    borrarLibroDelModelo();
                    break;
                case 4:
                    editarLibroDelModelo();
                    break;
                case 5:
                    exportarBooksCSV();
                    break;
                case 6:
                    exportarBooksJSON();
                    break;
                case 7:
                    exportBooksToXML();
                    break;
                case 8:
                    importarBooksJSON();
                    break;
                case 9:
                    importarBooksXML();
                    break;
                case 10:
                    importBooksFromCSV();
                    break;
                case 11:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }

    private void importBooksFromCSV() {
        throw new UnsupportedOperationException("Unimplemented method 'importBooksFromCSV'");
    }

    private void importarBooksXML() {
        throw new UnsupportedOperationException("Unimplemented method 'importarBooksXML'");
    }

    private void importarBooksJSON() {
        throw new UnsupportedOperationException("Unimplemented method 'importarBooksJSON'");
    }

    private void exportBooksToXML() {
        int res = c.exportBooksToXML();
        if (res == -1) {
            showErrorMessage("Error al exportar los libros a XML.");
        } else {
            showInfoMessage("Se han exportado " + res + " libros a libros.xml en el escritorio.");
        }
    }

    private void exportarBooksJSON() {
        int res = c.exportBooksToJSON();
        if (res == -1) {
            showErrorMessage("Error al exportar los libros a JSON.");
        } else {
            showInfoMessage("Se han exportado " + res + " libros a libros.json en el escritorio.");
        }
    }

    private void exportarBooksCSV() {
        int res = c.exportBooksToCSV();
        if (res == -1) {  
            showErrorMessage("Error al exportar los libros a CSV.");
        } else {   
            showInfoMessage("Se han exportado " + res + " libros a libros.csv en el escritorio.");
        }
    }

    private void editarLibroDelModelo() {
        ArrayList<Libro> books = c.getLibros();
        if (books.isEmpty()) {
            System.out.println("No hay libros disponibles para modificar.");
            return;
        }
        mostrarLibrosModelo(true);
        int index = Esdia.readInt("Seleccione el índice del libro a modificar (0 para cancelar): ", 0, books.size());
        if (index == 0) {
            System.out.println("Operación cancelada.");
            return;
        }

        Libro libroOriginal = books.get(index - 1);
        System.out.println("Modificando libro con ISBN: " + libroOriginal.getISBN());

        String titulo = Esdia.readString_ne("Introduzca el nuevo título del libro: ");
        String autor = Esdia.readString_ne("Introduzca el nuevo autor del libro: ");
        String editorial = Esdia.readString_ne("Introduzca la nueva editorial del libro: ");
        int anyoPublicacion = Esdia.readInt("Introduzca el nuevo año de publicación: ");
        int numPaginas = Esdia.readInt("Introduzca el nuevo número de páginas: ");
        float precio = Esdia.readFloat("Introduzca el nuevo precio: ");

        Libro libroModificado = new Libro(libroOriginal.getISBN(), titulo, autor, editorial, anyoPublicacion, numPaginas, precio);
        c.updateLibro(libroModificado);
        System.out.println("Libro modificado correctamente.");
    }

    private void borrarLibroDelModelo() {
        ArrayList<Libro> books = c.getLibros();
        if (books.isEmpty()) {
            System.out.println("No hay libros disponibles para eliminar.");
            return;
        }
        mostrarLibrosModelo(true);
        int index = Esdia.readInt("Seleccione el índice del libro a eliminar (0 para cancelar): ", 0, books.size());
        if (index == 0) {
            System.out.println("Operación cancelada.");
            return;
        }

        Libro libroAEliminar = books.get(index - 1);
        c.removeLibro(libroAEliminar);
        System.out.println("Libro eliminado correctamente.");
    }

    private void anadirLibroAlModelo() {
        String titulo = Esdia.readString_ne("Introduzca el título del libro: ");
        String autor = Esdia.readString_ne("Introduzca el autor del libro: ");
        String isbn = Esdia.readString_ne("Introduzca el ISBN del libro: ");
        String editorial = Esdia.readString_ne("Introduzca la editorial del libro: ");
        int anyoPublicacion = Esdia.readInt("Introduzca el año de publicación del libro: ");
        int numPaginas = Esdia.readInt("Introduzca el número de páginas del libro: ");
        float precio = Esdia.readFloat("Introduzca el precio del libro: ");

        Libro l = new Libro(isbn, titulo, autor, editorial, anyoPublicacion, numPaginas, precio);

        if (c.getLibros().contains(l)) {
            System.out.println("El libro ya existía en el modelo.");
        } else {
            c.addLibro(l);
            System.out.println("Libro añadido correctamente.");
        }
    }

    private void mostrarLibrosModelo(boolean showIndex) {
        ArrayList<Libro> books = c.getLibros();
        if (books.size() == 0) {
            System.out.println("No hay libros disponibles.");
        } else {
            if (showIndex) {
                System.out.println(String.format("| %6s ", "Indice") + Libro.tableHeader());
            } else {
                System.out.println(Libro.tableHeader());
            }
            for (Libro l : books) {
                if (showIndex) {
                    System.out.println(String.format("| %6d.", books.indexOf(l) + 1) + l.asTableRow());
                } else {
                    System.out.println(l.asTableRow());
                }
            }
        }
    }

    public void setC(Controller c) {
        this.c = c;
    }

    public void showInfoMessage(String string) {
        System.out.println(string);
    }

    public void showErrorMessage(String string) {
        System.err.println(string);
    }
}