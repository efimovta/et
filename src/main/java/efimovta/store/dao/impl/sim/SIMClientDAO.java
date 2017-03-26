package efimovta.store.dao.impl.sim;

import efimovta.store.dao.ClientDAO;
import efimovta.store.dao.exeption.RecordNotFoundException;
import efimovta.store.entity.Client;
import efimovta.store.util.FindHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jcd on 18.03.2017.
 */
public class SIMClientDAO extends SIMGenericDAO<Client> implements ClientDAO {

    public SIMClientDAO(ArrayList<Client> records) {
        super(records);
    }

    @Override
    public Client findById(long id) throws RecordNotFoundException {
        return FindHelper.find(records, id, FindHelper.CLIENT_BY_ID).get(0);
    }

    @Override
    public List<Client> findByFIO(String fio) throws RecordNotFoundException {
        return FindHelper.find(records, fio, FindHelper.CLIENT_BY_FIO);
    }
}
