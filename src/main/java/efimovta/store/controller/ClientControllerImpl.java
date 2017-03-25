package efimovta.store.controller;

import efimovta.store.dao.ClientDAO;
import efimovta.store.dao.entity.Client;
import efimovta.store.dao.exeption.DAOException;
import efimovta.store.dao.factory.DAOFactory;

/**
 * Created by jcd on 25.03.2017.
 */
public class ClientControllerImpl extends ClientController {

    ClientDAO clientDAO = DAOFactory.get().getClientDAO();


    @Override
    public void addNewClient(Client client) throws DAOException {
        //todo validator?
        clientDAO.add(client);
    }
}
