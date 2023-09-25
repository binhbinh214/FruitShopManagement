
import controller.FruitShopManagement;
import model.FruitShopModel;
import view.Menu;

public class FruitShopApp {

    public static void main(String[] args) {
        FruitShopModel model = new FruitShopModel();
        Menu view = new Menu();
        FruitShopManagement controller = new FruitShopManagement(model, view);

        view.runMainMenu(controller);
    }
}
