package efimovta.store.dao.impl.sim;

import efimovta.store.dao.GenericDAO;
import efimovta.store.dao.NotAllFieldsAreFilledException;
import efimovta.store.dao.RecordAlreadyExistsException;

/**
 * Class defines general behavior for DAO
 */
abstract class SIMGenericDAO<T> implements GenericDAO<T> {

    /**
     * Unsupported operation
     */
    @Override
    public void update(T object) {
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported operation
     */
    @Override
    public void delete(T object) {
        throw new UnsupportedOperationException();
    }

    /**
     * Checks the fields of the object and
     * the existence its existence in the storage
     *
     * @param object for check
     * @throws RecordAlreadyExistsException   if record
     *                                        already exists
     * @throws NotAllFieldsAreFilledException if any field is null
     */
    void checkBeforeAdd(T object)
            throws RecordAlreadyExistsException,
            NotAllFieldsAreFilledException {
        checkNullFields(object);
        checkAlreadyExists(object);
    }

    /**
     * Check the object fields
     *
     * @param object for check
     * @throws NotAllFieldsAreFilledException if any field is null
     */
    abstract void checkNullFields(T object)
            throws NotAllFieldsAreFilledException;

    /**
     * Checks, Does the record exist
     *
     * @param object for check
     * @throws RecordAlreadyExistsException if record
     *                                      already exists
     */
    abstract void checkAlreadyExists(T object)
            throws RecordAlreadyExistsException;

}
