package efimovta.store.menu;

import efimovta.store.OperationException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static efimovta.store.Messages.*;

/**
 * Main menu.
 */
public class MainMenu extends Menu {
    static private final Menu instance = new MainMenu();

    private List<MenuItem> menuItems = new ArrayList<>();

    {
        menuItems.addAll(Arrays.asList(
                new MenuItem(CREATING) {
                    @Override
                    public void execute() throws IOException,
                            OperationException {
                        setNextMenu(CreateMenu.getInstance());
                    }
                },
                new MenuItem(SEARCHING) {
                    @Override
                    public void execute() throws IOException,
                            OperationException {
                        setNextMenu(SearchMenu.getInstance());
                    }
                },
                new MenuItem(VIEWING_SORTED) {
                    @Override
                    public void execute() throws IOException,
                            OperationException {
                        setNextMenu(SortedViewMenu.getInstance());
                    }
                },
                new MenuItem(EXIT) {
                    @Override
                    public void execute() {
                        MenuManager.setExit();
                    }
                }
        ));
    }

    /**
     * @return Singleton {@link MainMenu}
     */
    public static Menu getInstance() {
        return instance;
    }

    private MainMenu() {
        super(MAIN_MENU);
    }

    /**
     * @return {@link Collections.UnmodifiableList} of menu items
     */
    @Override
    public List<MenuItem> get() {
        return Collections.unmodifiableList(menuItems);
    }

}
