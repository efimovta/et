package efimovta.store.menu;

import efimovta.store.menu.exception.OperationException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static efimovta.store.Constants.*;

/**
 * Created by EFIMOVAT on 08.04.2017.
 */
public class MainMenuItems extends MenuItems {
    static private final MenuItems instance = new MainMenuItems();

    private List<MenuItem> menuItems = new ArrayList<>();

    {
        menuItems.addAll(Arrays.asList(
                new MenuItem(CREATING) {
                    @Override
                    public void execute() throws IOException, OperationException {
                        setNext(CreateMenuItems.getInstance());
                    }
                },
                new MenuItem(SEARCHING) {
                    @Override
                    public void execute() throws IOException, OperationException {
                        setNext(SearchMenuItems.getInstance());
                    }
                },
                new MenuItem(VIEWING_SORTED) {
                    @Override
                    public void execute() throws IOException, OperationException {
                        setNext(SortedViewMenuItems.getInstance());
                    }
                },
                new MenuItem(EXIT) {
                    @Override
                    public void execute() {
                        System.exit(0);
                    }
                }
        ));
    }

    public static MenuItems getInstance() {
        return instance;
    }

    private MainMenuItems() {
        super(COMPANY_NAME);
    }


    @Override
    public List<MenuItem> get() {
        return Collections.unmodifiableList(menuItems);
    }

}
