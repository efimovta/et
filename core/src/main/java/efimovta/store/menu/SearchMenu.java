package efimovta.store.menu;

import efimovta.store.OperationCanceledByUserException;
import efimovta.store.Util;
import efimovta.store.entity.Client;
import efimovta.store.entity.Device;
import efimovta.store.entity.Sale;
import efimovta.store.entity.Viewer;
import efimovta.store.service.Searcher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static efimovta.store.Messages.*;

/**
 * Search menu.
 * Includes a menu items for searching entities.
 */
public class SearchMenu extends Menu {
    static private final Menu instance = new SearchMenu();

    private List<MenuItem> menuItems = new ArrayList<>();

    {
        menuItems.addAll(Arrays.asList(
                new MenuItem(ALL_CLIENTS) {
                    @Override
                    public void execute() throws IOException {
                        for (Client client : Searcher.findAllClients()) {
                            Util.println(Viewer.toString(client));
                        }
                    }
                },
                new MenuItem(ALL_DEVICES) {
                    @Override
                    public void execute() throws IOException {
                        for (Device device : Searcher.findAllDevices()) {
                            Util.println(Viewer.toString(device));
                        }
                    }
                },
                new MenuItem(ALL_SALES) {
                    @Override
                    public void execute() throws IOException {
                        for (Sale sale : Searcher.findAllSales()) {
                            Util.println(Viewer.toStructuredString(sale));
                        }
                    }
                },
                new MenuItem(SEARCHING_CLIENTS_BY_FIO) {
                    @Override
                    public void execute() throws IOException,
                            OperationCanceledByUserException {
                        for (Client client : Searcher.findClientByFIO()) {
                            Util.println(Viewer.toString(client));
                        }
                    }
                },
                new MenuItem(SEARCHING_CLIENTS_BY_ANY_NAME) {
                    @Override
                    public void execute() throws IOException,
                            OperationCanceledByUserException {
                        for (Client client : Searcher.findClientByAnyName()) {
                            Util.println(Viewer.toString(client));
                        }
                    }
                },
                new MenuItem(SEARCHING_DEVICES_BY_BRAND) {
                    @Override
                    public void execute() throws IOException,
                            OperationCanceledByUserException {
                        for (Device device : Searcher.findDeviceByBrand()) {
                            Util.println(Viewer.toString(device));
                        }
                    }
                },
                new MenuItem(SEARCHING_DEVICES_BY_TYPE) {
                    @Override
                    public void execute() throws IOException,
                            OperationCanceledByUserException {
                        for (Device device : Searcher.findDeviceByType()) {
                            Util.println(Viewer.toString(device));
                        }
                    }
                },
                new MenuItem(SEARCHING_DEVICES_BY_RELEASE_DATE) {
                    @Override
                    public void execute() throws IOException,
                            OperationCanceledByUserException {
                        for (Device device : Searcher.findDeviceByReleaseDate()) {
                            Util.println(Viewer.toString(device));
                        }
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
     * @return Singleton {@link SearchMenu}
     */
    public static Menu getInstance() {
        return instance;
    }

    private SearchMenu() {
        super(SEARCH_MENU_NAME);
    }

    /**
     * @return {@link Collections.UnmodifiableList} of menu items
     */
    @Override
    public List<MenuItem> get() {
        return Collections.unmodifiableList(menuItems);
    }

}
