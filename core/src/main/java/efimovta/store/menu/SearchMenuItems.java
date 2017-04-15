package efimovta.store.menu;

import efimovta.store.Utility;
import efimovta.store.dao.DAOException;
import efimovta.store.entity.Client;
import efimovta.store.entity.Device;
import efimovta.store.entity.Sale;
import efimovta.store.entity.Viewer;
import efimovta.store.menu.exception.OperationCanceledByUserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static efimovta.store.Constants.*;

/**
 * Created by EFIMOVAT on 08.04.2017.
 */
public class SearchMenuItems extends MenuItems {
    static private final MenuItems instance = new SearchMenuItems();

    private List<MenuItem> menuItems = new ArrayList<>();

    {
        menuItems.addAll(Arrays.asList(
                new MenuItem(ALL_CLIENTS) {
                    @Override
                    public void execute() throws IOException {
                        try {
                            for (Client client : Searcher.findAllClients()) {
                                Utility.println(Viewer.toString(client));
                            }
                        } catch (DAOException e) {
                            Utility.printErr(e.getMessage());
                        }
                    }
                },
                new MenuItem(ALL_DEVICES) {
                    @Override
                    public void execute() throws IOException {
                        try {
                            for (Device device : Searcher.findAllDevices()) {
                                Utility.println(Viewer.toString(device));
                            }
                        } catch (DAOException e) {
                            Utility.printErr(e.getMessage());
                        }
                    }
                },
                new MenuItem(ALL_SALES) {
                    @Override
                    public void execute() throws IOException {
                        try {
                            for (Sale sale : Searcher.findAllSales()) {
                                Utility.println(Viewer.toString(sale));
                            }
                        } catch (DAOException e) {
                            Utility.printErr(e.getMessage());
                        }
                    }
                },
                new MenuItem(SEARCHING_CLIENTS_BY_FIO) {
                    @Override
                    public void execute() throws IOException, OperationCanceledByUserException {
                        try {
                            for (Client client : Searcher.findClientByFIO()) {
                                Utility.println(Viewer.toString(client));
                            }
                        } catch (DAOException e) {
                            Utility.printErr(e.getMessage());
                        }
                    }
                },
                new MenuItem(SEARCHING_DEVICES_BY_BRAND) {
                    @Override
                    public void execute() throws IOException, OperationCanceledByUserException {
                        try {
                            for (Device device : Searcher.findDeviceByBrand()) {
                                Utility.println(Viewer.toString(device));
                            }
                        } catch (DAOException e) {
                            Utility.printErr(e.getMessage());
                        }
                    }
                },
                new MenuItem(SEARCHING_DEVICES_BY_TYPE) {
                    @Override
                    public void execute() throws IOException, OperationCanceledByUserException {
                        try {
                            for (Device device : Searcher.findDeviceByType()) {
                                Utility.println(Viewer.toString(device));
                            }
                        } catch (DAOException e) {
                            Utility.printErr(e.getMessage());
                        }
                    }
                },
                new MenuItem(SEARCHING_DEVICES_BY_RELEASE_DATE) {
                    @Override
                    public void execute() throws IOException, OperationCanceledByUserException {
                        try {
                            for (Device device : Searcher.findDeviceByReleaseDate()) {
                                Utility.println(Viewer.toString(device));
                            }
                        } catch (DAOException e) {
                            Utility.printErr(e.getMessage());
                        }
                    }
                },
                new MenuItem(BACK_TO_MAIN_MENU) {
                    @Override
                    public void execute() throws IOException {
                        setNext(MainMenuItems.getInstance());
                    }
                }

        ));
    }

    public static MenuItems getInstance() {
        return instance;
    }

    private SearchMenuItems() {
        super(SEARCH_MENU_NAME);
    }

    @Override
    public List<MenuItem> get() {
        return Collections.unmodifiableList(menuItems);
    }

}
