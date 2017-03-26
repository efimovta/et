package efimovta.store.dao.exeption;

/**
 * Created by jcd on 18.03.2017.
 */
public class RecordAlreadyExistsException extends DAOException {
    public RecordAlreadyExistsException() {
        super("Запись уже существует");
    }

    public RecordAlreadyExistsException(String message) {
        super(message);
    }
}
