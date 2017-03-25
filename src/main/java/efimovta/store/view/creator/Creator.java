package efimovta.store.view.creator;

import efimovta.store.view.exception.OperationCanceledByUserException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * Created by jcd on 13.03.2017.
 */
public abstract class Creator { //todo mb singleton


    public abstract void startCreationDialog() throws IOException, OperationCanceledByUserException;
}
