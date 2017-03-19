package efimovta.store.dao;

import efimovta.store.dao.exeption.DAOException;
import efimovta.store.entity.Client;

import java.util.List;

/**
 * Unified interface for managing the persistent state of {@link Client} objects
 */
public interface ClientDAO extends GenericDAO<Client> {

    /**
     * Finds the {@link Client} objects with the appropriate FIO
     *
     * @param fio An array of strings containing respectively: first, second and middle names
     * @return list of {@link Client} objects with the appropriate FIO
     */
    public List<Client> findByFIO(String fio) throws DAOException;
}
