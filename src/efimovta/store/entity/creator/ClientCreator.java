package efimovta.store.entity.creator;

import efimovta.store.dao.ClientDAO;
import efimovta.store.dao.exeption.DAOException;
import efimovta.store.dao.factory.DAOFactory;
import efimovta.store.entity.Client;
import efimovta.store.exception.ExceededAttemptsException;
import efimovta.store.storage.StorageInMemory;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;

/**
 * The class is responsible for creating a new client in interactive mode.
 * Use STORAGE_IN_MEMORY(SIM)
 * @see DAOFactory
 * @see StorageInMemory
 */
public class ClientCreator extends Creator {

    ClientDAO clientDAO = DAOFactory.getDAOFactory(DAOFactory.STORAGE_IN_MEMORY).getClientDAO();

    public ClientCreator(BufferedReader br) {
        super(br);
    }

    public ClientCreator(BufferedReader br, int numberOfAttempts) {
        super(br, numberOfAttempts);
    }

    /**
     * Creating a new client in interactive mode.
     * @throws IOException
     * @throws ExceededAttemptsException
     */
    public void createClient() throws IOException, ExceededAttemptsException {
        String[] fio = requestFIO();
        Date birthDay = requestBirthDay();

        Client client = new Client(fio[0], fio[1], fio[2], birthDay);

        try {
            clientDAO.record(client);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    public Date requestBirthDay() throws IOException, ExceededAttemptsException {
        System.out.println("Введите дату рождения клиента(Например: 13.11.1995)");
        return requestDate();
    }

    public String[] requestFIO() throws ExceededAttemptsException, IOException {
        System.out.println("Введите ФИО(Например: Васильев Вася Васильевич)");
        String[] fio = null;
        while (true) {
            fio = br.readLine().trim().split("[ ]+");
            if (fio.length == 3) break;
            else System.err.println(INPUT_ERROR_MSG);
        }
        return fio;
    }
}
