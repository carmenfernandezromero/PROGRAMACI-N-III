import controller.QuinielaController;
import model.QuinielaModel;
import view.QuinielaView;

public class App {
    public static void main(String[] args) {
        QuinielaView view = new QuinielaView();
        QuinielaModel model = new QuinielaModel();
        QuinielaController controller = new QuinielaController(view, model);
        view.setController(controller);

        controller.run();
    }
}
