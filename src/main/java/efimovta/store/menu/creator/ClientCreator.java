package efimovta.store.menu.creator;

import efimovta.store.dao.ClientDAO;
import efimovta.store.dao.entity.Client;
import efimovta.store.dao.exeption.DAOException;
import efimovta.store.dao.factory.DAOFactory;
import efimovta.store.menu.exception.OperationCanceledByUserException;
import efimovta.store.menu.requester.ClientParamsRequester;

import java.io.IOException;
import java.util.Date;

/**
 * The class is responsible for creating a new client in interactive mode.
 */
public class ClientCreator extends Creator {//todo mb singleton
    /**
     * Creating a new client in interactive mode.
     * @throws IOException
     * @throws OperationCanceledByUserException
     */
    public void startCreationDialog() throws IOException, OperationCanceledByUserException {
        ClientDAO clientDAO = DAOFactory.get().getClientDAO();
        ClientParamsRequester cpr = ClientParamsRequester.getInstance();
        
        String[] fio = cpr.requestFIO();
        Date birthDay = cpr.requestBirthDay();

        Client client = Client.getBuilder()
                .setSecondName(fio[0])
                .setName(fio[1])
                .setMiddleName(fio[2])
                .setBirthDay(birthDay)
                .build();

        //todo validator?
        try {
            clientDAO.add(client);
        } catch (DAOException e) {
            System.out.println(e.getMessage());
        }
    }

}
