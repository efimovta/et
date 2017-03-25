package efimovta.store.controller;

import efimovta.store.dao.ClientDAO;
import efimovta.store.dao.entity.Client;
import efimovta.store.dao.exeption.DAOException;
import efimovta.store.dao.factory.DAOFactory;

/**
 * Created by jcd on 25.03.2017.
 */
public abstract class ClientController {
    public abstract void addNewClient(Client client) throws DAOException;
}
