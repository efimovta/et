package efimovta.store.dao.exeption;

/**
 * Created by jcd on 18.03.2017.
 */
public class RecordNotFoundException extends DAOException {
    public RecordNotFoundException() {
        super("Запись не найдена");
    }

    public RecordNotFoundException(String message) {
        super(message);
    }
}
