package efimovta.store;

/**
 * Signals that an problems with Backup
 */
public class BackupException extends Exception {

    public BackupException() {
        super();
    }

    public BackupException(String message, Throwable cause) {
        super(message, cause);
    }
}
