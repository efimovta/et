package efimovta.store.dao.exeption;

/**
 * Created by jcd on 18.03.2017.
 */
public class DAOException extends Exception {
    public DAOException() {
    }

    public DAOException(String message) {
        super("Ошибка хранилища: " + message);
    }
}
