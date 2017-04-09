package efimovta.store.menu.requester;

import efimovta.store.Utility;
import efimovta.store.dao.ClientDAO;
import efimovta.store.dao.DAOException;
import efimovta.store.dao.DAOFactory;
import efimovta.store.entity.Client;
import efimovta.store.menu.exception.OperationCanceledByUserException;

import java.io.IOException;

/**
 * Created by jcd on 26.03.2017.
 */
public class SaleParamsRequester extends Requester {
    ClientDAO clientDAO = DAOFactory.get().getClientDAO();
    private static SaleParamsRequester ourInstance = new SaleParamsRequester();

    public static SaleParamsRequester getInstance() {
        return ourInstance;
    }

    private SaleParamsRequester() {
    }


    public Client requestClient() throws IOException, OperationCanceledByUserException {
        Client client = null;
        Utility.println("Введите id клиента(Например, 777):");
        while (true) {
            int id = requestIntNumber(0, Integer.MAX_VALUE);

            try {
                client = clientDAO.findById(id);
                break;
            } catch (DAOException e) {
                Utility.printErr(e.getMessage());
            }
        }
        return client;
    }


}
