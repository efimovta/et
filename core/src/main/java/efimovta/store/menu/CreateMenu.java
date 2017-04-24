package efimovta.store.menu;

import efimovta.store.OperationCanceledByUserException;
import efimovta.store.OperationCanceledException;
import efimovta.store.Util;
import efimovta.store.entity.Client;
import efimovta.store.entity.Device;
import efimovta.store.entity.Sale;
import efimovta.store.service.creator.ClientCreator;
import efimovta.store.service.creator.DeviceCreator;
import efimovta.store.service.creator.SaleCreator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import static efimovta.store.Messages.BACK_TO_MAIN_MENU;
import static efimovta.store.Messages.CLIENT_ADDING;
import static efimovta.store.Messages.CREATE_MENU_NAME;
import static efimovta.store.Messages.DEVICE_ADDING;
import static efimovta.store.Messages.SALE_ADDING;
import static efimovta.store.Messages.THE_CLIENT_WAS_SUCCESSFULLY_ADDED;
import static efimovta.store.Messages.THE_DEVICE_WAS_SUCCESSFULLY_ADDED;
import static efimovta.store.Messages.THE_SALE_WAS_SUCCESSFULLY_ADDED;

/**
 * Create menu.
 * Includes a menu items for creating entities
 */
public class CreateMenu extends Menu {
    private static final Logger log = Logger.getLogger(CreateMenu.class.getName());

    private static final Menu instance = new CreateMenu();
    private List<MenuItem> menuItems = new ArrayList<>();

    {
        menuItems.addAll(Arrays.asList(
                new MenuItem(CLIENT_ADDING) {
                    @Override
                    public void execute() throws
                            OperationCanceledByUserException,
                            OperationCanceledException {
                        Client client = ClientCreator
                                .getInstance().startCreationDialog();

                        Util.println(THE_CLIENT_WAS_SUCCESSFULLY_ADDED);
                        log.info(THE_CLIENT_WAS_SUCCESSFULLY_ADDED
                                + ": " + client);
                    }
                },
                new MenuItem(DEVICE_ADDING) {
                    @Override
                    public void execute() throws
                            OperationCanceledByUserException,
                            OperationCanceledException {
                        Device device = DeviceCreator
                                .getInstance().startCreationDialog();

                        Util.println(THE_DEVICE_WAS_SUCCESSFULLY_ADDED);
                        log.info(THE_DEVICE_WAS_SUCCESSFULLY_ADDED
                                + ": " + device);
                    }
                },
                new MenuItem(SALE_ADDING) {
                    @Override
                    public void execute()
                            throws OperationCanceledByUserException,
                            OperationCanceledException {
                        Sale sale = SaleCreator
                                .getInstance().startCreationDialog();
                        Util.println(THE_SALE_WAS_SUCCESSFULLY_ADDED);
                        log.info(THE_SALE_WAS_SUCCESSFULLY_ADDED
                                + ": " + sale);
                    }
                },
                new MenuItem(BACK_TO_MAIN_MENU) {
                    @Override
                    public void execute() {
                        setNextMenu(MainMenu.getInstance());
                    }
                }
        ));
    }

    private CreateMenu() {
        super(CREATE_MENU_NAME);
    }

    /**
     * @return Singleton {@link CreateMenu}
     */
    public static Menu getInstance() {
        return instance;
    }

    /**
     * @return {@link Collections.UnmodifiableList} of menu items
     */
    @Override
    public List<MenuItem> get() {
        return Collections.unmodifiableList(menuItems);
    }
}
