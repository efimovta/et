package efimovta.store.dao;

/**
 * If any problem with DAO occurs
 */
public class DAOException extends Exception {

    public DAOException() {

    }

    public DAOException(String message) {
        super(message);
    }
}
