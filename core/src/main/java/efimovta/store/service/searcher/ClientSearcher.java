package efimovta.store.service.searcher;

import efimovta.store.OperationCanceledByUserException;
import efimovta.store.dao.ClientDAO;
import efimovta.store.dao.DAOFactory;
import efimovta.store.entity.Client;
import efimovta.store.requester.ClientParamsRequester;

import java.util.Arrays;
import java.util.List;

/**
 * Searching clients in interactive mode. Singleton.
 */
public class ClientSearcher implements Searcher<Client> {
    private static ClientSearcher ourInstance = new ClientSearcher();
    private static ClientDAO clientDAO = DAOFactory.get().getClientDAO();

    private static ClientParamsRequester cpr =
            ClientParamsRequester.getInstance();

    protected ClientSearcher() {

    }

    /**
     * @return Singleton {@link ClientSearcher}
     */
    public static ClientSearcher getInstance() {
        return ourInstance;
    }

    /**
     * @return all clients
     */
    public List<Client> findAll() {
        return clientDAO.getAll();
    }

    /**
     * Request FIO from the user and return clients with
     * corresponding FIO
     *
     * @return clients with corresponding FIO
     * @throws OperationCanceledByUserException if user cancel
     *                                          operation
     */
    public List<Client> findByFIO()
            throws OperationCanceledByUserException {
        String[] arrFIO = cpr.requestFIO();
        String fio = Arrays.toString(arrFIO)
                .replaceAll("\\[|\\]|,", "")
                .toLowerCase();
        return clientDAO.findByFIO(fio);
    }

    /**
     * Request name from the user  and return clients who have any name corresponding given
     *
     * @return clients who have any name corresponding given
     * @throws OperationCanceledByUserException if user cancel operation
     */
    public List<Client> findByAnyName()
            throws OperationCanceledByUserException {
        String name = cpr.requestName();
        return clientDAO.findByAnyName(name);
    }
}
