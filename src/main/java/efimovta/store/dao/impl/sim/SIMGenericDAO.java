package efimovta.store.dao.impl.sim;

import efimovta.store.dao.GenericDAO;
import efimovta.store.dao.exeption.DAOException;
import efimovta.store.dao.exeption.RecordAlreadyExistsException;
import efimovta.store.dao.exeption.RecordNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jcd on 19.03.2017.
 */

public class SIMGenericDAO<T> implements GenericDAO<T> {
    protected ArrayList<T> records;

    public SIMGenericDAO(ArrayList<T> records) {
        this.records = records;
    }

    @Override
    public T add(T object) throws RecordAlreadyExistsException, RecordNotFoundException {
        boolean added = records.add(object);
        if (!added) throw new RecordAlreadyExistsException();
        return object;
    }

    @Override
    public T findById(long id) throws DAOException {
        throw  new UnsupportedOperationException();
    }

    @Override
    public void update(T object) throws RecordNotFoundException {
        if (!records.contains(object)) throw new RecordNotFoundException();
    }

    @Override
    public void delete(T object) throws RecordNotFoundException {
        int index = records.indexOf(object);
        if (index == -1) throw new RecordNotFoundException();
        records.remove(index);
    }

    @Override
    public List<T> getAll() {
        return new ArrayList<T>(records);
    }

}
