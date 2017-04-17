package efimovta.store.menu;

import efimovta.store.OperationException;

import java.io.IOException;

/**
 * Is a menu item.
 */
public abstract class MenuItem {
    private String description;

    public MenuItem(String description) {
        this.description = description;
    }

    /**
     * @return description of menu item
     */
    @Override
    public String toString() {
        return description;
    }

    /**
     * MenuManager item action
     */
    public abstract void execute() throws IOException, OperationException;

}
