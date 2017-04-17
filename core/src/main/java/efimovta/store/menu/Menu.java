package efimovta.store.menu;

import java.util.List;

import static efimovta.store.Messages.DEFAULT_MENU_NAME;

/**
 * The base class for the contents of the menu
 */
public abstract class Menu {
    private Menu nextMenu;
    private String menuName;

    /**
     * Specifies the default menu name.
     */
    public Menu() {
        this.menuName = DEFAULT_MENU_NAME;
    }

    /**
     * Specifies menu name.
     */
    public Menu(String menuName) {
        this.menuName = menuName;
    }

    /**
     * @return menu name
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * @return menu name
     */
    @Override
    public String toString() {
        return menuName;
    }

    /**
     * Set next menu. Default {@code null} - if this is next menu.
     *
     * @param nextMenu next menu
     */
    public final void setNextMenu(Menu nextMenu) {
        this.nextMenu = nextMenu;
    }

    /**
     * Returns null if this is next menu.
     * Otherwise returns another following menu and assigns
     * {@code null} to the "nextMenu".
     *
     * @return nextMenu menu
     */
    public final Menu next() {
        Menu items = this;
        if (nextMenu != null) {
            items = nextMenu;
            nextMenu = null;
        }
        return items;
    }

    /**
     * @return menu items
     */
    public abstract List<MenuItem> get();
}
