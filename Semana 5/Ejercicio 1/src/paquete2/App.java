package paquete2;


import paquete1.Clase1; 
// import paquete1.Clase2; // ERROR porque Clase2 NO se puede importar porque no tiene el modificador

public class App {
    public static void main(String[] args) {

        Clase1 c1 = new Clase1();

        System.out.println(c1.atrbPublico);   // funciona (es public)
        // System.out.println(c1.atrbDefault);   // ERROR (no está en paquete1)
        // System.out.println(c1.atrbProtegido); // ERROR (no está en paquete1 ni hereda)
        // System.out.println(c1.atrbPrivado);   // ERROR (es private)

        c1.metodoPublico();   // funciona (es public)
        // c1.metodoDefault();   // ERROR (no está en paquete1)
        // c1.metodoProtegido(); // ERROR (no está en paquete1 ni hereda)
        // c1.metodoPrivado();   // ERROR (es private)
    }
}