package efimovta.store.requester;

import efimovta.store.OperationCanceledByUserException;
import efimovta.store.Util;
import efimovta.store.dao.ClientDAO;
import efimovta.store.dao.DAOFactory;
import efimovta.store.entity.Client;

import java.io.IOException;

import static efimovta.store.Messages.CLIENT_NOT_FOUND;
import static efimovta.store.Messages.ENTER_SALE_CLIENT_ID;

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


    public Client requestClient() throws IOException,
            OperationCanceledByUserException {
        Client client = null;
        Util.println(ENTER_SALE_CLIENT_ID);
        while (true) {
            int id = requestIntNumber(0, Integer.MAX_VALUE);
            client = clientDAO.findById(id);
            if (client != null) break;
            else Util.println(CLIENT_NOT_FOUND + '\n' + INPUT_ERROR_MSG);
        }
        return client;
    }


}
