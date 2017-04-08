package efimovta.store.menu;

import java.util.List;

/**
 * Created by EFIMOVAT on 08.04.2017.
 */
public abstract class MenuItems {
    private static final String DEFAULT_DESCRIPTION = "### Menu ###";
    private String description;

    public MenuItems() {
        this.description = DEFAULT_DESCRIPTION;
    }

    public MenuItems(String description) {
        this.description = description;
    }

    public String getDescription(){
        return DEFAULT_DESCRIPTION;
    };

    @Override public String toString() {
        return getDescription();
    }

    public abstract List<MenuItem> get();

    public abstract MenuItem next();
}
