package efimovta.store.dao.exeption;

/**
 * Created by EFIMOVAT on 26.03.2017.
 */
public class ClientRecordNotFoundException extends RecordNotFoundException {
    public ClientRecordNotFoundException(String s) {
        super(s);
    }

    public ClientRecordNotFoundException() {
        super("Запись о клиенте не найдена");
    }
}
