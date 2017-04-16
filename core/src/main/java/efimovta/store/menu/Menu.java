package efimovta.store.menu;

import efimovta.store.Utility;

import java.io.IOException;

import static efimovta.store.Constants.INVALID_INPUT;
import static efimovta.store.Constants.SELECT_ACTION;

/**
 * Created by EFIMOVAT on 08.04.2017.
 */
public class Menu {
    private static MenuItems current = MainMenuItems.getInstance();

    public static void startDialog() throws IOException {
        while (true) {
            activateMenu(current);
            current = current.next();
        }
    }

    private static void activateMenu(MenuItems menuItems) throws IOException {
        Utility.println(menuItems.toString());
        int i = 1;
        for (MenuItem mi : menuItems.get()) {
            Utility.println(i + ". " + mi);
            i++;
        }

        Utility.println(SELECT_ACTION);
        String strOtv = Utility.readLine();
        try {
            int otv = Integer.parseInt(strOtv) - 1;
            menuItems.get().get(otv).execute();
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            Utility.printErr(INVALID_INPUT);
        } catch (OperationException e) {
            Utility.printErr(e.getMessage());
        }
    }



}
