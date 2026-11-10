import modelo.SumaModelo;
import modelo.SumaModelo;
import vista.SumaVista;
import controlador.SumaControlador;

public class Main {
    public static void main(String[] args) {
        SumaModelo modelo = new SumaModelo();
        SumaVista vista = new SumaVista();

        SumaControlador controlador = new SumaControlador(modelo);

        vista.setControlador(controlador);

        vista.mostrarMenu();
    }
}