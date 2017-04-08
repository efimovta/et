package efimovta.store.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static efimovta.store.Constants.*;

/**
 * Created by EFIMOVAT on 08.04.2017.
 */
public class MainMenuItems extends MenuItems {
    List<MenuItem> menuItems = new ArrayList<>();
    {
        menuItems.addAll(Arrays.asList(
                new WithoutExecuteMenuItem(ADDING) {
                    @Override
                    public MenuItem next() {
                        return null;
                    }
                },
                new WithoutExecuteMenuItem(SEARCHING) {
                },
                new WithoutExecuteMenuItem(VIEWING_SORTED) {
                },
                new MenuItem(EXIT) {
                    @Override
                    public void execute() {
                        System.exit(0);
                    }
                }
        ));
    }

    public MainMenuItems() {
        super(COMPANY_NAME);
    }

    @Override
    public List<MenuItem> get() {
        return Collections.unmodifiableList(menuItems);
    }
}
