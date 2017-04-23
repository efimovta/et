package efimovta.store.dao.impl.sim;

import efimovta.store.FindHelper;
import efimovta.store.Util;
import efimovta.store.dao.ClientDAO;
import efimovta.store.dao.NotAllFieldsAreFilledException;
import efimovta.store.dao.RecordAlreadyExistsException;
import efimovta.store.entity.Client;

import java.util.ArrayList;
import java.util.List;

/**
 * Class provide DAO for {@link Client}
 */
class SIMClientDAO extends SIMGenericDAO<Client> implements ClientDAO {

    /**
     * Adding a client if all fields are not null and client not
     * already exists
     *
     * @param client for adding
     * @throws RecordAlreadyExistsException   if client
     *                                        already exists
     * @throws NotAllFieldsAreFilledException if any field is null
     */
    @Override
    public void add(Client client) throws RecordAlreadyExistsException,
            NotAllFieldsAreFilledException {
        checkBeforeAdd(client);
        StorageInMemory.getClients().add(client.getClone());
    }

    /**
     * Client search by id
     *
     * @param id id of client
     * @return founded client or null otherwise
     */
    @Override
    public Client findById(long id) {
        Client client = null;
        List<Client> list = FindHelper.find(StorageInMemory.getClients(), id,
                FindHelper.CLIENT_BY_ID);
        if (!list.isEmpty()) {
            client = list.get(0).getClone();
        }
        return client;
    }

    /**
     * Client search by FIO
     *
     * @param fio FIO of client
     * @return founded clients or empty list otherwise
     */
    @Override
    public List<Client> findByFIO(String fio) {
        List<Client> clients = FindHelper.find(StorageInMemory.getClients(),
                fio, FindHelper.CLIENT_BY_FIO);
        if (!clients.isEmpty()) {
            clients = Util.deepCopy(clients);
        }
        return clients;
    }

    /**
     * Client search by any name
     *
     * @param name any name of client
     * @return founded clients or empty list otherwise
     */
    @Override
    public List<Client> findByAnyName(String name) {
        List<Client> clients = FindHelper.find(StorageInMemory.getClients(),
                name, FindHelper.CLIENT_BY_ANY_NAME);
        if (!clients.isEmpty()) {
            clients = Util.deepCopy(clients);
        }
        return clients;
    }

    /**
     * Client search by first name
     *
     * @param firstName first name of client
     * @return founded clients or empty list otherwise
     */
    @Override
    public List<Client> findByFirstName(String firstName) {
        List<Client> clients = FindHelper.find(StorageInMemory.getClients(),
                firstName, FindHelper.CLIENT_BY_FIRST_NAME);
        if (!clients.isEmpty()) {
            clients = Util.deepCopy(clients);
        }
        return clients;
    }

    /**
     * Client search by second name
     *
     * @param secondName second name of client
     * @return founded clients or empty list otherwise
     */
    @Override
    public List<Client> findBySecondName(String secondName) {
        List<Client> clients = FindHelper.find(StorageInMemory.getClients(),
                secondName, FindHelper.CLIENT_BY_SECOND_NAME);
        if (!clients.isEmpty()) {
            clients = Util.deepCopy(clients);
        }
        return clients;
    }

    /**
     * Client search by middle name
     *
     * @param middleName middle name of client
     * @return founded clients or empty list otherwise
     */
    @Override
    public List<Client> findByMiddleName(String middleName) {
        List<Client> clients = FindHelper.find(StorageInMemory.getClients(),
                middleName, FindHelper.CLIENT_BY_MIDDLE_NAME);
        if (!clients.isEmpty()) {
            clients = Util.deepCopy(clients);
        }
        return clients;
    }

    /**
     * Get all clients
     *
     * @return all clients or empty list if not exists
     */
    @Override
    public List<Client> getAll() {
        List<Client> clients;
        if (StorageInMemory.getClients().isEmpty()) {
            clients = new ArrayList<>(0);
        } else {
            clients = Util.deepCopy(StorageInMemory.getClients());
        }
        return clients;
    }

    /**
     * Check the Client fields
     *
     * @param c for check
     * @throws NotAllFieldsAreFilledException if any field is null
     */
    @Override
    protected void checkNullFields(Client c)
            throws NotAllFieldsAreFilledException {
        if (c.getMiddleName() == null) {
            throw new NotAllFieldsAreFilledException(
                    "client.getMiddleName() return null");
        }
        if (c.getFirstName() == null) {
            throw new NotAllFieldsAreFilledException(
                    "client.getFirstName() return null");
        }
        if (c.getSecondName() == null) {
            throw new NotAllFieldsAreFilledException(
                    "client.getSecondName() return null");
        }
        if (c.getBirthday() == null) {
            throw new NotAllFieldsAreFilledException(
                    "client.getBirthday() return null");
        }
    }

    /**
     * Checks. Does the Client record exist
     *
     * @param c for check
     * @throws RecordAlreadyExistsException if record
     *                                      already exists
     */
    @Override
    protected void checkAlreadyExists(Client c)
            throws RecordAlreadyExistsException {
        int i = StorageInMemory.getClients().indexOf(c);
        if (i != -1) {
            long id = StorageInMemory.getClients().get(i).getId();
            throw new RecordAlreadyExistsException(
                    "This client exists with id: " + id);
        }
    }
}
