package efimovta.store.dao;

/**
 * If record not found in storage
 */
public class RecordNotFoundException extends DAOException {
    public RecordNotFoundException(String message) {
        super(message);
    }
}
