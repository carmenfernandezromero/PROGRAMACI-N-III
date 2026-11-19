import controller.ListaDeClaseController;
import model.ListaDeClaseModel;
import view.ListaDeClaseView;

public class App {
    public static void main(String[] args) {
        ListaDeClaseView view = new ListaDeClaseView();
        ListaDeClaseModel model = new ListaDeClaseModel();
        ListaDeClaseController controller = new ListaDeClaseController(view, model);
        view.setController(controller);

        controller.run();
    }
}