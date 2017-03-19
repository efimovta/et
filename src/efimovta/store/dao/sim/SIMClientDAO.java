package efimovta.store.dao.sim;

import efimovta.store.dao.ClientDAO;
import efimovta.store.dao.exeption.RecordNotFoundException;
import efimovta.store.dao.sim.helper.FindHelper;
import efimovta.store.entity.Client;

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
    public List<Client> findByFIO(String fio) throws RecordNotFoundException {
        return FindHelper.find(records, fio, FindHelper.CLIENT_BY_FIO);
    }
}
