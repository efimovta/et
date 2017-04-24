package efimovta.store.service.creator;

import efimovta.store.OperationCanceledByUserException;
import efimovta.store.OperationCanceledException;

/**
 * Contains method to start creating entities in interactive mode
 */
public interface Creator<T> {

    /**
     * Creating a new entity in interactive mode.
     *
     * @return created entity instance
     * @throws OperationCanceledByUserException if user cancel operation
     * @throws OperationCanceledException       if operation problem exists
     */
    T startCreationDialog()
            throws OperationCanceledByUserException, OperationCanceledException;

}
