package efimovta.store.entity.creator;

import efimovta.store.entity.Client;
import efimovta.store.exception.ExceededAttemptsException;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;

/**
 * Created by jcd on 13.03.2017.
 */
public class ClientCreator extends Requester {

    public ClientCreator(BufferedReader br) {
        super(br);
    }

    public ClientCreator(BufferedReader br, int numberOfAttempts) {
        super(br, numberOfAttempts);
    }

    public Client createClient() throws IOException, ExceededAttemptsException {
        String[] fio = requestFIO();
        Date birthDay = requestBirthDay();

        return new Client(fio[0], fio[1], fio[2], birthDay);
    }

    public Date requestBirthDay() throws IOException, ExceededAttemptsException {
        System.out.println("Введите дату рождения клиента(Например: 13.11.1995)");
        return requestDate();
    }

    public String[] requestFIO() throws ExceededAttemptsException, IOException {
        System.out.println("Введите ФИО(Например: Васильев Вася Васильевич)");
        String[] fio = null;
        for (int i = 1; i <= NUMBER_OF_ATTEMPTS; i++) {
            fio = br.readLine().trim().split("[ ]+");
            if (fio.length == 3) break;
            else if (i < NUMBER_OF_ATTEMPTS)
                System.err.println(ERR_IN_MSG + (NUMBER_OF_ATTEMPTS - i));
            else throw new ExceededAttemptsException();
        }
        return fio;
    }
}
