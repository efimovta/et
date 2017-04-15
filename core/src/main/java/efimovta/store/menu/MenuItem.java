package efimovta.store.menu;

import efimovta.store.menu.exception.OperationException;

import java.io.IOException;

/**
 * Created by EFIMOVAT on 08.04.2017.
 */
public abstract class MenuItem {
    private String description;

    protected MenuItem(String description) {
        this.description = description;
    }

    @Override public String toString() {
        return description;
    }

    public abstract void execute() throws IOException, OperationException;

}
