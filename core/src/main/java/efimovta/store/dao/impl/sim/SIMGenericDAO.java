package efimovta.store.dao.impl.sim;

import efimovta.store.Serializator;
import efimovta.store.dao.*;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 * Created by jcd on 19.03.2017.
 */

public abstract class SIMGenericDAO<T> implements GenericDAO<T> {
    protected List<T> records;

    public SIMGenericDAO(List<T> records) {
        this.records = records;
    }

    public void check(T object) throws
            RecordAlreadyExistsException, NotAllFieldsAreFilledException {
        //checkAlreadyExists(object);//todo return
        //checkNullFields(object);
    }

    protected abstract void checkNullFields(T object) throws
            NotAllFieldsAreFilledException;

    public void checkAlreadyExists(T object) throws
            RecordAlreadyExistsException {
        if (records.contains(object)) {
            throw new RecordAlreadyExistsException();
        }
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
    public List<T> getAll() throws DAOException {
        if (records.size() == 0) throw new RecordNotFoundException();
        return (List<T>) serialize((Serializable) records);
    }

    /**
     * Clones an object using serialization
     *
     * @param serializable - object to clone
     * @param <W>          - type of cloning object
     * @return clone of object
     * @throws DAOException - problem with Serialization
     */
    protected <W extends Serializable> W serialize(W serializable) throws
            DAOException {
        try {
            return Serializator.serialize(serializable);
        } catch (IOException e) {
            throw new DAOException(
                    "\"Serializator.serialize(serializable);\"" +
                    " throw IOException");
        }
    }
}
