import modelo.AlmacenModelo;
import vista.AlmacenVista;
import controlador.AlmacenControlador;

public class Main {
    public static void main(String[] args) {
        AlmacenModelo modelo = new AlmacenModelo();
        AlmacenVista vista = new AlmacenVista();

        AlmacenControlador controlador = new AlmacenControlador(modelo);
        vista.setControlador(controlador);

        vista.mostrarMenu();
    }
}