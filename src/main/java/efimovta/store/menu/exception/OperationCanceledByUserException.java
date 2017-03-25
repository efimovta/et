package efimovta.store.menu.exception;

/**
 * Created by EFIMOVAT on 12.03.2017.
 */
public class OperationCanceledByUserException extends OperationException {
    public OperationCanceledByUserException() {
        super("Операция отменена пользователем.");
    }
}
