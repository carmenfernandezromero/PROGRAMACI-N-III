import controller.PersonaController;
import model.PersonaModel;
import view.PersonaView;

public class App {
    public static void main(String[] args) {
        PersonaView view = new PersonaView();
        PersonaModel model = new PersonaModel();
        PersonaController controller = new PersonaController(view, model);
        view.setController(controller);

        controller.run();
    }
}