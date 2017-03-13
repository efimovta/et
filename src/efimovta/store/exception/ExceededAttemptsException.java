package efimovta.store.exception;

/**
 * Created by EFIMOVAT on 12.03.2017.
 */
public class ExceededAttemptsException extends OperationException {
    public ExceededAttemptsException() {
        super("Превышено колличество попыток.");
    }
}
