package efimovta.store.menu;

import efimovta.store.ExitException;
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

    /**
     * In the infinite loop, it calls the following menu
     *
     * @throws IOException if any problem with console input
     * @see #activateMenu
     */
    public static void startDialog() throws IOException, ExitException {
        while (true) {
            activateMenu(current);
            current = current.next();
        }
    }

    /**
     * Displays a menu and prompts for user selection.
     *
     * @param menu menu to dialog
     * @throws IOException if any problem with console input
     */
    private static void activateMenu(Menu menu) throws IOException,
            ExitException {
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
            Util.printErr(INVALID_INPUT);
        } catch (OperationCanceledByUserException e) {
            Util.println(THE_OPERATION_WAS_SUCCESSFULLY_CANCELED);
        } catch (ExitException e) {
            throw e;
        } catch (OperationException e) {
            Util.printErr(e.getMessage());
            Util.log.log(Level.SEVERE, MENU_ITEM_EXECUTE_THOW_EXCEPTION, e);
        }
    }


}
