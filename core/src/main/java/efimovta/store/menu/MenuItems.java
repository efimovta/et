package efimovta.store.menu;

import java.util.List;

import static efimovta.store.Constants.DEFAULT_DESCRIPTION;

/**
 * Created by EFIMOVAT on 08.04.2017.
 */
public abstract class MenuItems {
    private MenuItems next;
    private String description;

    public MenuItems() {
        this.description = DEFAULT_DESCRIPTION;
    }

    public MenuItems(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return getDescription();
    }

    public abstract List<MenuItem> get();

    public final void setNext(MenuItems next) {
        this.next = next;
    }

    public final MenuItems next() {
        MenuItems items = this;
        if (next != null) {
            items = next;
            next = null;
        }
        return items;
    }
}
