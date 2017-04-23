package efimovta.store.menu;

import efimovta.store.OperationCanceledByUserException;
import efimovta.store.OperationException;
import efimovta.store.Util;

import java.io.IOException;
import java.util.logging.Level;

import static efimovta.store.Messages.*;

/**
 * Menu manager.
 * Here there is control over the transition from / to a Menu.
 *
 * @see Menu
 */
public class MenuManager {
    private static Menu current = MainMenu.getInstance();
    private static boolean exit = false;

    private MenuManager() {
    }

    /**
     * Displays a menu and prompts for user selection.
     *
     * @param menu menu to dialog
     * @throws IOException if any problem with console input
     */
    private static void activateMenu(Menu menu) throws IOException {
        Util.println(menu.toString());
        int i = 1;
        for (MenuItem mi : menu.get()) {
            Util.println(i + ". " + mi);
            i++;
        }

        Util.println(SELECT_ACTION);
        String strOtv = Util.readLine();
        try {
            int otv = Integer.parseInt(strOtv) - 1;
            menu.get().get(otv).execute();
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            Util.println(INVALID_INPUT);
        } catch (OperationCanceledByUserException e) {
            Util.println(THE_OPERATION_WAS_SUCCESSFULLY_CANCELED);
        } catch (OperationException e) {
            Util.println(e.getMessage());
            Util.log.log(Level.SEVERE, MENU_ITEM_EXECUTE_THOW_EXCEPTION, e);
        }
    }

    /**
     * In the infinite loop, it calls the following menu
     * The exit is by {@link #setExit()}
     *
     * @throws IOException if any problem with console input
     * @see #activateMenu(Menu menu)
     */
    public static void startDialog() throws IOException {
        while (!exit) {
            activateMenu(current);
            current = current.next();
        }
    }

    /**
     * Use for exit from app. This method set boolean param
     * to true for exit from cycle.
     *
     * @see #startDialog()
     */
    static void setExit() {
        exit = true;
    }
}
