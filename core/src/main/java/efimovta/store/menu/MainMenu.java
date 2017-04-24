package efimovta.store.menu;

import efimovta.store.OperationException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static efimovta.store.Messages.CREATING;
import static efimovta.store.Messages.EXIT;
import static efimovta.store.Messages.MAIN_MENU;
import static efimovta.store.Messages.SEARCHING;
import static efimovta.store.Messages.VIEWING_SORTED;

/**
 * Main menu.
 */
public class MainMenu extends Menu {
    private static final Menu instance = new MainMenu();

    private List<MenuItem> menuItems = new ArrayList<>();

    {
        menuItems.addAll(Arrays.asList(
                new MenuItem(CREATING) {
                    @Override
                    public void execute() throws
                            OperationException {
                        setNextMenu(CreateMenu.getInstance());
                    }
                },
                new MenuItem(SEARCHING) {
                    @Override
                    public void execute() throws
                            OperationException {
                        setNextMenu(SearchMenu.getInstance());
                    }
                },
                new MenuItem(VIEWING_SORTED) {
                    @Override
                    public void execute() throws
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

    private MainMenu() {
        super(MAIN_MENU);
    }

    /**
     * @return Singleton {@link MainMenu}
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
