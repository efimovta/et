package efimovta.store.dao;

/**
 * If not all fields are filled in record
 */
public class NotAllFieldsAreFilledException extends DAOException {
    public NotAllFieldsAreFilledException() {

    }

    public NotAllFieldsAreFilledException(String message) {
        super(message);
    }
}
