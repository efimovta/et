package efimovta.store.dao.impl.sim;

import efimovta.store.dao.DAOException;
import efimovta.store.dao.GenericDAO;
import efimovta.store.dao.NotAllFieldsAreFilledException;
import efimovta.store.dao.RecordAlreadyExistsException;

/**
 * Class defines general behavior for DAO
 */
public abstract class SIMGenericDAO<T> implements GenericDAO<T> {

    /**
     * Unsupported operation
     */
    @Override
    public void update(T object) throws DAOException {
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported operation
     */
    @Override
    public void delete(T object) throws DAOException {
        throw new UnsupportedOperationException();
    }

    protected void checkBeforeAdd(T object)
            throws RecordAlreadyExistsException,
            NotAllFieldsAreFilledException {
        checkNullFields(object);
        checkAlreadyExists(object);
    }

    protected abstract void checkNullFields(T object)
            throws NotAllFieldsAreFilledException;

    protected abstract void checkAlreadyExists(T object)
            throws RecordAlreadyExistsException;

}
