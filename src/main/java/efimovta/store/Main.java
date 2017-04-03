package efimovta.store;

import efimovta.store.menu.MainMenu;

import java.io.IOException;

/**
 * Created by jcd on 19.03.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        StorageFiller.fillStorage();

        MainMenu.startDialog();

    }
}
