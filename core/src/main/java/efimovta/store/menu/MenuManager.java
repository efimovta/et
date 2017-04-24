package efimovta.store.menu;

import efimovta.store.OperationCanceledByUserException;
import efimovta.store.OperationException;
import efimovta.store.Util;

import java.util.logging.Level;
import java.util.logging.Logger;

import static efimovta.store.Messages.INVALID_INPUT;
import static efimovta.store.Messages.MENU_ITEM_EXECUTE_THOW_EXCEPTION;
import static efimovta.store.Messages.SELECT_ACTION;
import static efimovta.store.Messages.THE_OPERATION_WAS_SUCCESSFULLY_CANCELED;

/**
 * Menu manager.
 * Here there is control over the transition from / to a Menu.
 *
 * @see Menu
 */
public class MenuManager {
    private static final Logger log = Logger.getLogger(MenuManager.class.getName());

    private static Menu current = MainMenu.getInstance();
    private static boolean exit = false;

    private MenuManager() {
    }

    /**
     * Displays a menu and prompts for user selection.
     *
     * @param menu menu to dialog
     */
    private static void activateMenu(Menu menu) {
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
            log.log(Level.INFO, INVALID_INPUT, e);
        } catch (OperationCanceledByUserException e) {
            Util.println(THE_OPERATION_WAS_SUCCESSFULLY_CANCELED);
            log.log(Level.INFO, THE_OPERATION_WAS_SUCCESSFULLY_CANCELED, e);
        } catch (OperationException e) {
            Util.println(e.getMessage());
            log.log(Level.SEVERE, MENU_ITEM_EXECUTE_THOW_EXCEPTION, e);
        }
    }

    /**
     * In the infinite loop, it calls the following menu
     * The exit is by {@link #setExit()}
     *
     * @see #activateMenu(Menu menu)
     */
    public static void startDialog() {
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
