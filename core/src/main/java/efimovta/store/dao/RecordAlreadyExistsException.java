package efimovta.store.dao;

/**
 * If record already exists in storage
 */
public class RecordAlreadyExistsException extends DAOException {
    public RecordAlreadyExistsException() {

    }

    public RecordAlreadyExistsException(String message) {
        super(message);
    }
}
