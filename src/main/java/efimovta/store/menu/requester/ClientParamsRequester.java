package efimovta.store.menu.requester;

import efimovta.store.Utility;
import efimovta.store.menu.exception.OperationCanceledByUserException;

import java.io.IOException;
import java.util.Date;

/**
 * Created by jcd on 26.03.2017.
 */
public class ClientParamsRequester extends Requester {

    private static ClientParamsRequester ourInstance = new ClientParamsRequester();

    public static ClientParamsRequester getInstance() {
        return ourInstance;
    }

    protected ClientParamsRequester() {

    }

    public Date requestBirthDay() throws IOException, OperationCanceledByUserException {
        Utility.println("Введите дату рождения клиента(Например: 13.11.1995)");
        return requestDate();
    }

    public String[] requestFIO() throws IOException, OperationCanceledByUserException {
        Utility.println("Введите ФИО(Например: Васильев Вася Васильевич)");
        String[] fio;
        while (true) {
            String str = Utility.readLine();
            if (str.equals(EXIT_SYMBOL)) throw new OperationCanceledByUserException();

            fio = str.trim().split("[ ]+");
            if (fio.length == 3) break;
            else Utility.printErr(INPUT_ERROR_MSG);
        }
        return fio;
    }
}
