package efimovta.store.dao;

/**
 * If any problem with DAO occurs
 */
public class DAOException extends Exception {

    DAOException() {
        super();
    }

    DAOException(String message) {
        super(message);
    }
}
