package efimovta.store.view.creator;

import efimovta.store.controller.ClientController;
import efimovta.store.controller.ClientControllerFactory;
import efimovta.store.dao.entity.Client;
import efimovta.store.dao.exeption.DAOException;
import efimovta.store.view.creator.requester.ClientParamsRequester;
import efimovta.store.view.exception.OperationCanceledByUserException;

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
        ClientController clientController = (new ClientControllerFactory()).get();
        ClientParamsRequester cpr = ClientParamsRequester.getInstance();
        
        String[] fio = cpr.requestFIO();
        Date birthDay = cpr.requestBirthDay();

        Client client = Client.getBuilder()
                .setSecondName(fio[0])
                .setName(fio[1])
                .setMiddleName(fio[2])
                .setBirthDay(birthDay)
                .build();

        try {
            clientController.addNewClient(client);
        } catch (DAOException e) {
            System.out.println(e.getMessage());
        }
    }

}
