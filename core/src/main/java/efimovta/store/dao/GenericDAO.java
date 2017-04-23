package efimovta.store.dao;

import java.util.List;


/**
 * Unified interface for managing the persistent state
 * of {@link T} objects
 */
public interface GenericDAO<T> {

    /**
     * Creates a new add that corresponds to the {@link T} object
     *
     * @param object object to add
     */
    void add(T object) throws DAOException;

    /**
     * Returns {@link T} object with the corresponding Id or null
     *
     * @param id id of object
     * @return {@link T} with the corresponding Id
     */
    T findById(long id);

    /**
     * Updates the corresponding add
     *
     * @param object object to update add
     */
    void update(T object) throws DAOException;

    /**
     * Deletes an object add
     *
     * @param object object to delete
     */
    void delete(T object) throws DAOException;

    /**
     * Returns a list of {@link T} objects matching all clientRecords
     *
     * @return list of {@link T} objects matching all clientRecords
     */
    List<T> getAll();
}
