package efimovta.store.menu;

import efimovta.store.OperationCanceledByUserException;
import efimovta.store.Util;
import efimovta.store.entity.Client;
import efimovta.store.entity.Device;
import efimovta.store.entity.Sale;
import efimovta.store.entity.Viewer;
import efimovta.store.service.searcher.ClientSearcher;
import efimovta.store.service.searcher.DeviceSearcher;
import efimovta.store.service.searcher.SaleSearcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static efimovta.store.Messages.ALL_CLIENTS;
import static efimovta.store.Messages.ALL_DEVICES;
import static efimovta.store.Messages.ALL_SALES;
import static efimovta.store.Messages.BACK_TO_MAIN_MENU;
import static efimovta.store.Messages.SEARCHING_CLIENTS_BY_ANY_NAME;
import static efimovta.store.Messages.SEARCHING_CLIENTS_BY_FIO;
import static efimovta.store.Messages.SEARCHING_DEVICES_BY_BRAND;
import static efimovta.store.Messages.SEARCHING_DEVICES_BY_RELEASE_DATE;
import static efimovta.store.Messages.SEARCHING_DEVICES_BY_TYPE;
import static efimovta.store.Messages.SEARCH_MENU_NAME;

/**
 * Search menu.
 * Includes a menu items for searching entities.
 */
public class SearchMenu extends Menu {
    private static final Menu instance = new SearchMenu();

    private List<MenuItem> menuItems = new ArrayList<>();

    {
        menuItems.addAll(Arrays.asList(
                new MenuItem(ALL_CLIENTS) {
                    @Override
                    public void execute() {
                        for (Client client : ClientSearcher.getInstance().findAll()) {
                            Util.println(Viewer.toString(client));
                        }
                    }
                },
                new MenuItem(ALL_DEVICES) {
                    @Override
                    public void execute() {
                        for (Device device : DeviceSearcher.getInstance().findAll()) {
                            Util.println(Viewer.toString(device));
                        }
                    }
                },
                new MenuItem(ALL_SALES) {
                    @Override
                    public void execute() {
                        for (Sale sale : SaleSearcher.getInstance().findAll()) {
                            Util.println(Viewer.toStructuredString(sale));
                        }
                    }
                },
                new MenuItem(SEARCHING_CLIENTS_BY_FIO) {
                    @Override
                    public void execute() throws
                            OperationCanceledByUserException {
                        for (Client client : ClientSearcher.getInstance().findByFIO()) {
                            Util.println(Viewer.toString(client));
                        }
                    }
                },
                new MenuItem(SEARCHING_CLIENTS_BY_ANY_NAME) {
                    @Override
                    public void execute() throws
                            OperationCanceledByUserException {
                        for (Client client : ClientSearcher.getInstance().findByAnyName()) {
                            Util.println(Viewer.toString(client));
                        }
                    }
                },
                new MenuItem(SEARCHING_DEVICES_BY_BRAND) {
                    @Override
                    public void execute() throws
                            OperationCanceledByUserException {
                        for (Device device : DeviceSearcher.getInstance().findDeviceByBrand()) {
                            Util.println(Viewer.toString(device));
                        }
                    }
                },
                new MenuItem(SEARCHING_DEVICES_BY_TYPE) {
                    @Override
                    public void execute() throws
                            OperationCanceledByUserException {
                        for (Device device : DeviceSearcher.getInstance().findByType()) {
                            Util.println(Viewer.toString(device));
                        }
                    }
                },
                new MenuItem(SEARCHING_DEVICES_BY_RELEASE_DATE) {
                    @Override
                    public void execute() throws
                            OperationCanceledByUserException {
                        for (Device device : DeviceSearcher.getInstance().findByReleaseDate()) {
                            Util.println(Viewer.toString(device));
                        }
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

    private SearchMenu() {
        super(SEARCH_MENU_NAME);
    }

    /**
     * @return Singleton {@link SearchMenu}
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
