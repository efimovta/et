package efimovta.store.menu;

import efimovta.store.menu.exception.OperationException;

import java.io.IOException;

/**
 * Created by EFIMOVAT on 09.04.2017.
 */
public abstract class WithoutExecuteMenuItem extends MenuItem {
    protected WithoutExecuteMenuItem(String description) {
        super(description);
    }

    @Override
    public void execute() throws IOException, OperationException {
        throw new UnsupportedOperationException();
    }
}
