package efimovta.store.dao.exeption;

/**
 * Created by jcd on 18.03.2017.
 */
public class RecordAlreadyExistsException extends DAOException {
    public RecordAlreadyExistsException() {
    }

    public RecordAlreadyExistsException(String message) {
        super("Запись о клиенте уже существует");
    }
}
