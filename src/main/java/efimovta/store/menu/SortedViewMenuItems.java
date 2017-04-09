package efimovta.store.menu;

import efimovta.store.Utility;
import efimovta.store.dao.DAOException;
import efimovta.store.entity.Client;
import efimovta.store.entity.ClientComparator;
import efimovta.store.entity.Viewer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static efimovta.store.Constants.*;

/**
 * Created by EFIMOVAT on 08.04.2017.
 */
public class SortedViewMenuItems extends MenuItems {
    static private final MenuItems instance = new SortedViewMenuItems();

    private List<MenuItem> menuItems = new ArrayList<>();

    {
        menuItems.addAll(Arrays.asList(
                            new MenuItem(VIEWING_CLIENTS_SORTED_BY_NAME) {
                                @Override
                                public void execute() throws IOException {
                                    List<Client> ar = null;
                                    try {
                                        ar = Searcher.findAllClients();
                                    } catch (DAOException e) {
                                        Utility.printErr(e.getMessage());
                                    }
                                    Collections.sort(ar, ClientComparator.BY_FIO);
                                    for (Client client : ar) {
                                        Utility.println(Viewer.toString(client));
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

    private SortedViewMenuItems() {
        super(SORTEDVIEW_MENU_NAME);
    }

    @Override
    public List<MenuItem> get() {
        return Collections.unmodifiableList(menuItems);
    }

}
