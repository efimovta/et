package efimovta.store.requester;

import efimovta.store.OperationCanceledByUserException;
import efimovta.store.Util;

import java.util.Date;

import static efimovta.store.Messages.ENTER_ANY_CLIENT_NAME;
import static efimovta.store.Messages.ENTER_CLIENT_BIRTHDAY;
import static efimovta.store.Messages.ENTER_CLIENT_FIO;

/**
 * Client params requester. Used for request client params.
 */
public class ClientParamsRequester extends Requester {

    private static ClientParamsRequester ourInstance =
            new ClientParamsRequester();

    private ClientParamsRequester() {

    }

    /**
     * @return Singleton {@link ClientParamsRequester}
     */
    public static ClientParamsRequester getInstance() {
        return ourInstance;
    }

    /**
     * Request birthday
     *
     * @return requested date
     * @throws OperationCanceledByUserException if user type
     *                                          {@link #EXIT_SYMBOL}
     */
    public Date requestBirthDay() throws OperationCanceledByUserException {
        Util.println(ENTER_CLIENT_BIRTHDAY);
        return requestDate();
    }

    /**
     * Request FIO
     *
     * @return requested FIO
     * @throws OperationCanceledByUserException if user type
     *                                          {@link #EXIT_SYMBOL}
     */
    public String[] requestFIO() throws OperationCanceledByUserException {
        Util.println(ENTER_CLIENT_FIO);
        String[] fio = null;
        while (fio == null || fio.length != 3) {
            String str = Util.readLine();
            if (str.equals(EXIT_SYMBOL)) {
                throw new OperationCanceledByUserException();
            }

            fio = str.trim().split("[ ]+");
            if (fio.length != 3) {
                Util.println(INPUT_ERROR_MSG);
            }
        }
        return fio;
    }

    /**
     * Request client name
     *
     * @return requested name
     * @throws OperationCanceledByUserException if user type
     *                                          {@link #EXIT_SYMBOL}
     */
    public String requestName() throws OperationCanceledByUserException {
        Util.println(ENTER_ANY_CLIENT_NAME);
        String name = null;
        while (name == null || name.length() <= 0) {
            name = Util.readLine();
            if (name.equals(EXIT_SYMBOL)) {
                throw new OperationCanceledByUserException();
            }
            if (name.length() <= 0) {
                Util.println(INPUT_ERROR_MSG);
            }
        }
        return name;
    }
}
