package efimovta.store.dao;

import efimovta.store.dao.entity.Client;
import efimovta.store.dao.exeption.DAOException;

import java.util.List;

/**
 * Unified interface for managing the persistent state of {@link Client} objects
 */
public interface ClientDAO extends GenericDAO<Client> {

    /**
     * Finds the {@link Client} objects with the appropriate FIO
     *
     * @param fio string contains respectively: first, second and middle names;
     *            with space delimiter
     * @return list of {@link Client} objects with the appropriate FIO
     */
    public List<Client> findByFIO(String fio) throws DAOException;
}
