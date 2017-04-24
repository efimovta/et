package efimovta.store.service.creator;

import efimovta.store.OperationCanceledByUserException;
import efimovta.store.OperationCanceledException;
import efimovta.store.dao.ClientDAO;
import efimovta.store.dao.DAOException;
import efimovta.store.dao.DAOFactory;
import efimovta.store.entity.Client;
import efimovta.store.requester.ClientParamsRequester;

import java.util.Date;

/**
 * Contains static methods to start creating client instances in
 * interactive mode. Singleton.
 */
public class ClientCreator implements Creator<Client> {

    private static ClientCreator ourInstance = new ClientCreator();

    private ClientCreator() {

    }

    /**
     * @return Singleton {@link ClientCreator}
     */
    public static ClientCreator getInstance() {
        return ourInstance;
    }

    /**
     * Creating a new client in interactive mode.
     *
     * @return created client instance
     */
    public Client startCreationDialog()
            throws OperationCanceledByUserException, OperationCanceledException {
        ClientDAO clientDAO = DAOFactory.get().getClientDAO();
        ClientParamsRequester cpr = ClientParamsRequester.getInstance();

        String[] fio = cpr.requestFIO();
        Date birthDay = cpr.requestBirthDay();

        Client client = new Client();
        client.setSecondName(fio[0]);
        client.setFirstName(fio[1]);
        client.setMiddleName(fio[2]);
        client.setBirthday(birthDay);

        try {
            clientDAO.add(client);
        } catch (DAOException e) {
            throw new OperationCanceledException(
                    "Client was not added: " + client.toString(), e);
        }
        return client;
    }

}
