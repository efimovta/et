package efimovta.store.menu.requester;

import efimovta.store.dao.ClientDAO;
import efimovta.store.dao.entity.Client;
import efimovta.store.dao.exeption.DAOException;
import efimovta.store.dao.factory.DAOFactory;
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
        System.out.println("Введите id клиента(Например, 777):");
        while (true) {
            int id = requestIntNumber(0, Integer.MAX_VALUE);

            try {
                client = clientDAO.findById(id);
                break;
            } catch (DAOException e) {
                System.err.println(e.getMessage());
                System.err.println(INPUT_ERROR_MSG);
            }
        }
        return client;
    }


}
