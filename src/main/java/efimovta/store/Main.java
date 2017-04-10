package efimovta.store;

import efimovta.store.menu.Menu;

import java.io.IOException;

/**
 * Created by jcd on 19.03.2017.
 */
public class Main {
    public static void main(String[] args)  {
        StorageFiller.fillStorage();

        //MainMenu.startDialog();
        try {
            Menu.startDialog();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }
}
