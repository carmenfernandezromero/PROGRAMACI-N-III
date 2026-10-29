package modelo;

import java.util.ArrayList;

public class Refugio {
    private ArrayList<Animal> animales;
    private double precioAlimentoPorKg;

    public Refugio() {
        this.animales = new ArrayList<>();
        this.precioAlimentoPorKg = 0.0;
    }

    public double getPrecioAlimentoPorKg() {
        return precioAlimentoPorKg;
    }

    public void setPrecioAlimentoPorKg(double precioAlimentoPorKg) {
        this.precioAlimentoPorKg = precioAlimentoPorKg;
    }

    public ArrayList<Animal> getAnimales() {
        return animales;
    }


    public boolean anadirAnimal(Animal animal) {
        return animales.add(animal);
    }


    public Animal buscarAnimalPorNombre(String nombre) {
        for (Animal a : animales) {
            if (a.getNombre().equalsIgnoreCase(nombre)) { // Presupone que Animal tiene getNombre()
                return a;
            }
        }
        return null;
    }


    public boolean eliminarAnimalPorNombre(String nombre) {
        return animales.removeIf(a -> a.getNombre().equalsIgnoreCase(nombre));
    }
}