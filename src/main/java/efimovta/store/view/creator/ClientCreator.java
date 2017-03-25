package efimovta.store.view.creator;

import efimovta.store.dao.ClientDAO;
import efimovta.store.dao.exeption.DAOException;
import efimovta.store.dao.factory.DAOFactory;
import efimovta.store.dao.entity.Client;
import efimovta.store.view.exception.OperationCanceledByUserException;
import efimovta.store.storage.StorageInMemory;

import java.io.IOException;
import java.util.Date;

/**
 * The class is responsible for creating a new client in interactive mode.
 */
public class ClientCreator extends Creator {//todo mb singleton

    ClientDAO clientDAO = DAOFactory.getDAOFactory(DAOFactory.STORAGE_IN_MEMORY).getClientDAO();

    /**
     * Creating a new client in interactive mode.
     * @throws IOException
     * @throws OperationCanceledByUserException
     */
    public void createClient() throws IOException, OperationCanceledByUserException {
        String[] fio = requestFIO();
        Date birthDay = requestBirthDay();

        Client client = new Client(fio[0], fio[1], fio[2], birthDay);

        try {
            clientDAO.record(client);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    public Date requestBirthDay() throws IOException, OperationCanceledByUserException {
        System.out.println("Введите дату рождения клиента(Например: 13.11.1995)");
        return requestDate();
    }

    public String[] requestFIO() throws  IOException, OperationCanceledByUserException {
        System.out.println("Введите ФИО(Например: Васильев Вася Васильевич)");
        String[] fio = null;
        while (true) {
            String str = br.readLine();
            if(str.equals(EXIT_SYMBOL))throw new OperationCanceledByUserException();

            fio = str.trim().split("[ ]+");
            if (fio.length == 3) break;
            else System.err.println(INPUT_ERROR_MSG);
        }
        return fio;
    }
}
