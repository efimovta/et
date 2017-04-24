package efimovta.store;

/**
 * If operation canceled
 */
public class OperationCanceledException extends OperationException {
    public OperationCanceledException(Throwable cause) {
        super(cause);
    }

    public OperationCanceledException(String msg, Throwable cause) {
        super(cause);
    }

    public OperationCanceledException() {
        super();
    }
}
