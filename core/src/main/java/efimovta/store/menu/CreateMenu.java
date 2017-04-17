package efimovta.store.menu;

import efimovta.store.OperationCanceledByUserException;
import efimovta.store.OperationCanceledException;
import efimovta.store.Util;
import efimovta.store.entity.Client;
import efimovta.store.entity.Device;
import efimovta.store.entity.Sale;
import efimovta.store.service.Creator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static efimovta.store.Messages.*;

/**
 * Create menu.
 * Includes a menu items for creating entities
 */
public class CreateMenu extends Menu {
    static private final Menu instance = new CreateMenu();
    private List<MenuItem> menuItems = new ArrayList<>();

    {
        menuItems.addAll(Arrays.asList(
                new MenuItem(CLIENT_ADDING) {
                    @Override
                    public void execute() throws IOException,
                            OperationCanceledByUserException,
                            OperationCanceledException {
                        Client client = Creator.startClientCreationDialog();
                        Util.println(THE_CLIENT_WAS_SUCCESSFULLY_ADDED);
                        Util.log.info(THE_CLIENT_WAS_SUCCESSFULLY_ADDED
                                + ": " + client);
                    }
                },
                new MenuItem(DEVICE_ADDING) {
                    @Override
                    public void execute() throws IOException,
                            OperationCanceledByUserException,
                            OperationCanceledException {
                        Device device = Creator.startDeviceCreationDialog();
                        Util.println(THE_DEVICE_WAS_SUCCESSFULLY_ADDED);
                        Util.log.info(THE_DEVICE_WAS_SUCCESSFULLY_ADDED
                                + ": " + device);
                    }
                },
                new MenuItem(SALE_ADDING) {
                    @Override
                    public void execute() throws IOException,
                            OperationCanceledByUserException,
                            OperationCanceledException {
                        Sale sale = Creator.startSaleCreationDialog();
                        Util.println(THE_SALE_WAS_SUCCESSFULLY_ADDED);
                        Util.log.info(THE_SALE_WAS_SUCCESSFULLY_ADDED
                                + ": " + sale);
                    }
                },
                new MenuItem(BACK_TO_MAIN_MENU) {
                    @Override
                    public void execute() throws IOException {
                        setNextMenu(MainMenu.getInstance());
                    }
                }
        ));
    }

    /**
     * @return Singleton {@link CreateMenu}
     */
    public static Menu getInstance() {
        return instance;
    }

    private CreateMenu() {
        super(CREATE_MENU_NAME);
    }

    /**
     * @return {@link Collections.UnmodifiableList} of menu items
     */
    @Override
    public List<MenuItem> get() {
        return Collections.unmodifiableList(menuItems);
    }
}
