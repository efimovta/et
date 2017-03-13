package efimovta.store.exception;

/**
 * Created by EFIMOVAT on 12.03.2017.
 */
public class OperationException extends Exception {
    public OperationException(String s) {
        super("Операция отменена: "+s);
    }
    public OperationException() {
        super("Операция отменена");
    }
}
