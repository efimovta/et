package efimovta.store.menu.creator;

import efimovta.store.menu.exception.OperationCanceledByUserException;

import java.io.IOException;

/**
 * Created by jcd on 13.03.2017.
 */
public abstract class Creator { //todo mb singleton


    public abstract void startCreationDialog() throws IOException, OperationCanceledByUserException;
}
