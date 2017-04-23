package efimovta.store.requester;

import efimovta.store.OperationCanceledByUserException;
import efimovta.store.Util;

import java.io.IOException;
import java.util.Date;

import static efimovta.store.Messages.*;

/**
 * Created by jcd on 26.03.2017.
 */
public class ClientParamsRequester extends Requester {

    private static ClientParamsRequester ourInstance =
            new ClientParamsRequester();

    public static ClientParamsRequester getInstance() {
        return ourInstance;
    }

    private ClientParamsRequester() {

    }

    public Date requestBirthDay() throws IOException,
            OperationCanceledByUserException {
        Util.println(ENTER_CLIENT_BIRTHDAY);
        return requestDate();
    }

    public String[] requestFIO() throws IOException,
            OperationCanceledByUserException {
        Util.println(ENTER_CLIENT_FIO);
        String[] fio;
        while (true) {
            String str = Util.readLine();
            if (str.equals(EXIT_SYMBOL)) {
                throw new OperationCanceledByUserException();
            }

            fio = str.trim().split("[ ]+");
            if (fio.length == 3) break;
            else Util.printErr(INPUT_ERROR_MSG);
        }
        return fio;
    }

    public String requestName() throws IOException,
            OperationCanceledByUserException {
        Util.println(ENTER_ANY_CLIENT_NAME);
        String name;
        while (true) {
            name = Util.readLine();
            if (name.equals(EXIT_SYMBOL)) {
                throw new OperationCanceledByUserException();
            }
            if (name.length() > 0) break;
            else Util.printErr(INPUT_ERROR_MSG);
        }
        return name;
    }
}
