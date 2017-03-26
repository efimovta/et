package efimovta.store.dao.exeption;

/**
 * Created by jcd on 18.03.2017.
 */
public class RecordNotFoundException extends DAOException {
    public RecordNotFoundException() {
    }

    public RecordNotFoundException(String message) {
        super("Запись не найдена");
    }
}
