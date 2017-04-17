package efimovta.store;

/**
 * If problem with operation occurs
 */
public class OperationException extends Exception {

    public OperationException(Throwable cause) {
        super(cause);
    }

    public OperationException() {
    }

    public OperationException(String message, Throwable cause) {
        super(message, cause);
    }
}
