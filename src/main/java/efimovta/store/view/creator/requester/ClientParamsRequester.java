package efimovta.store.view.creator.requester;

import efimovta.store.view.exception.OperationCanceledByUserException;

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
        System.out.println("Введите дату рождения клиента(Например: 13.11.1995)");
        return requestDate();
    }

    public String[] requestFIO() throws  IOException, OperationCanceledByUserException {
        System.out.println("Введите ФИО(Например: Васильев Вася Васильевич)");
        String[] fio;
        while (true) {
            String str = getReader().readLine();
            if(str.equals(EXIT_SYMBOL))throw new OperationCanceledByUserException();

            fio = str.trim().split("[ ]+");
            if (fio.length == 3) break;
            else System.err.println(INPUT_ERROR_MSG);
        }
        return fio;
    }
}
