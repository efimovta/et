package efimovta.store.service.searcher;

import java.util.List;

/**
 * Searching entities in interactive mode.
 */
public interface Searcher<T> {

    /**
     * @return all entities
     */
    List<T> findAll();
}
