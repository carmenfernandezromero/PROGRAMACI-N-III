import controller.FacturaController;
import model.FacturaModel;
import view.FacturaView;

public class App {
    public static void main(String[] args) {
        FacturaView view = new FacturaView();
        FacturaModel model = new FacturaModel();
        FacturaController controller = new FacturaController(view, model);
        view.setController(controller);

        controller.run();
    }
}