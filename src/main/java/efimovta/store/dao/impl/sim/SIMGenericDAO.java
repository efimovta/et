package efimovta.store.dao.impl.sim;

import efimovta.store.Serializator;
import efimovta.store.dao.DAOException;
import efimovta.store.dao.GenericDAO;
import efimovta.store.dao.RecordAlreadyExistsException;
import efimovta.store.dao.RecordNotFoundException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jcd on 19.03.2017.
 */

public abstract class SIMGenericDAO<T> implements GenericDAO<T> {
    protected ArrayList<T> records;

    public SIMGenericDAO(ArrayList<T> records) {
        this.records = records;
    }

    @Override
    public void add(T object) throws DAOException {
        if (records.contains(object)) throw new RecordAlreadyExistsException();
        records.add(object);
    }

    @Override
    public void update(T object) throws DAOException {
        throw new UnsupportedOperationException();
        //if (!records.contains(object)) throw new RecordNotFoundException();
    }

    @Override
    public void delete(T object) throws DAOException {
        throw new UnsupportedOperationException();
//        int index = records.indexOf(object);
//        if (index == -1) throw new RecordNotFoundException();
//        records.remove(index);
    }

    @Override
    public List<T> getAll() throws DAOException{
        if(records.size()==0)throw new RecordNotFoundException();
        try {
            return Serializator.clone(records);
        } catch (IOException e) {
            throw new DAOException("\"Serializator.clone(records);\" throw IOException");
        }
    }
}
