package efimovta.store.dao;

/**
 * Created by jcd on 18.03.2017.
 */
public class DAOException extends Exception {//todo delete russian

    public DAOException() {
        super("Ошибка хранилища");
    }

    public DAOException(String message) {
        super("Ошибка хранилища: " + message);
    }
}
