package efimovta.store.menu;

import efimovta.store.Util;
import efimovta.store.entity.Client;
import efimovta.store.entity.ClientComparator;
import efimovta.store.entity.Device;
import efimovta.store.entity.DeviceComparator;
import efimovta.store.entity.Sale;
import efimovta.store.entity.SaleComparator;
import efimovta.store.entity.Viewer;
import efimovta.store.service.searcher.ClientSearcher;
import efimovta.store.service.searcher.DeviceSearcher;
import efimovta.store.service.searcher.SaleSearcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static efimovta.store.Messages.BACK_TO_MAIN_MENU;
import static efimovta.store.Messages.SORTEDVIEW_MENU_NAME;
import static efimovta.store.Messages.VIEWING_CLIENTS_SORTED_BY_BIRTHDAY;
import static efimovta.store.Messages.VIEWING_CLIENTS_SORTED_BY_NAME;
import static efimovta.store.Messages.VIEWING_DEVICES_SORTED_BY_BRAND;
import static efimovta.store.Messages.VIEWING_DEVICES_SORTED_BY_CLIENT_ID;
import static efimovta.store.Messages.VIEWING_DEVICES_SORTED_BY_MODEL;
import static efimovta.store.Messages.VIEWING_DEVICES_SORTED_BY_RELEASE_DATE;
import static efimovta.store.Messages.VIEWING_DEVICES_SORTED_BY_TYPE;
import static efimovta.store.Messages.VIEWING_SALES_SORTED_BY_SALE_DATE;

/**
 * Sorted view menu.
 * Includes a menu items for sorted viewing entities.
 */
public class SortedViewMenu extends Menu {
    private static final Menu instance = new SortedViewMenu();

    private List<MenuItem> menuItems = new ArrayList<>();

    {
        menuItems.addAll(Arrays.asList(
                new MenuItem(VIEWING_CLIENTS_SORTED_BY_NAME) {
                    @Override
                    public void execute() {
                        List<Client> ar;
                        ar = ClientSearcher.getInstance().findAll();
                        Collections.sort(ar, ClientComparator.BY_FIO);
                        for (Client client : ar) {
                            Util.println(Viewer.toString(client));
                        }
                    }
                },
                new MenuItem(VIEWING_CLIENTS_SORTED_BY_BIRTHDAY) {
                    @Override
                    public void execute() {
                        List<Client> ar;
                        ar = ClientSearcher.getInstance().findAll();
                        Collections.sort(ar, ClientComparator.BY_BIRTHDAY);
                        for (Client client : ar) {
                            Util.println(Viewer.toString(client));
                        }
                    }
                },
                new MenuItem(VIEWING_DEVICES_SORTED_BY_RELEASE_DATE) {
                    @Override
                    public void execute() {
                        List<Device> ar;
                        ar = DeviceSearcher.getInstance().findAll();
                        Collections.sort(ar, DeviceComparator.BY_RELEASE_DATE);
                        for (Device device : ar) {
                            Util.println(Viewer.toString(device));
                        }
                    }
                },
                new MenuItem(VIEWING_DEVICES_SORTED_BY_BRAND) {
                    @Override
                    public void execute() {
                        List<Device> ar;
                        ar = DeviceSearcher.getInstance().findAll();
                        Collections.sort(ar, DeviceComparator.BY_BRAND);
                        for (Device device : ar) {
                            Util.println(Viewer.toString(device));
                        }
                    }
                },
                new MenuItem(VIEWING_DEVICES_SORTED_BY_TYPE) {
                    @Override
                    public void execute() {
                        List<Device> ar;
                        ar = DeviceSearcher.getInstance().findAll();
                        Collections.sort(ar, DeviceComparator.BY_TYPE);
                        for (Device device : ar) {
                            Util.println(Viewer.toString(device));
                        }
                    }
                },
                new MenuItem(VIEWING_DEVICES_SORTED_BY_MODEL) {
                    @Override
                    public void execute() {
                        List<Device> ar;
                        ar = DeviceSearcher.getInstance().findAll();
                        Collections.sort(ar, DeviceComparator.BY_MODEL);
                        for (Device device : ar) {
                            Util.println(Viewer.toString(device));
                        }
                    }
                },
                new MenuItem(VIEWING_SALES_SORTED_BY_SALE_DATE) {
                    @Override
                    public void execute() {
                        List<Sale> ar;
                        ar = SaleSearcher.getInstance().findAll();
                        Collections.sort(ar, SaleComparator.BY_SALE_DATE);
                        for (Sale sale : ar) {
                            Util.println(Viewer.toString(sale));
                        }
                    }
                },
                new MenuItem(VIEWING_DEVICES_SORTED_BY_CLIENT_ID) {
                    @Override
                    public void execute() {
                        List<Sale> ar;
                        ar = SaleSearcher.getInstance().findAll();
                        Collections.sort(ar, SaleComparator.BY_CLIENT_ID);
                        for (Sale sale : ar) {
                            Util.println(Viewer.toString(sale));
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

    private SortedViewMenu() {
        super(SORTEDVIEW_MENU_NAME);
    }

    /**
     * @return Singleton {@link SortedViewMenu}
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
