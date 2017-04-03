package efimovta.store.dao.impl.sim;

import efimovta.store.FindHelper;
import efimovta.store.dao.ClientDAO;
import efimovta.store.dao.DAOException;
import efimovta.store.dao.NotAllFieldsAreFilledException;
import efimovta.store.entity.Client;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jcd on 18.03.2017.
 */
public class SIMClientDAO extends SIMGenericDAO<Client> implements ClientDAO {

    public SIMClientDAO(List<Client> records) {
        super(records);
    }

    @Override
    protected void checkNullFields() throws NotAllFieldsAreFilledException {

    }

    @Override
    public void add(Client client) throws DAOException {
        check(client);
        records.add(new Client(client));
    }

    @Override
    public Client findById(long id) throws DAOException {
        Client c = FindHelper.find(records, id, FindHelper.CLIENT_BY_ID)
                .get(0);
        return serialize(c);
    }

    @Override
    public List<Client> findByFIO(String fio) throws DAOException {
        List<Client> list =  FindHelper.find(records, fio,
                FindHelper.CLIENT_BY_FIO);
        return (List<Client>) serialize((Serializable)list);
    }
}
