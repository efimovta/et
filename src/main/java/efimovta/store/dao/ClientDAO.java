package efimovta.store.dao;

import efimovta.store.entity.Client;

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
    List<Client> findByFIO(String fio) throws DAOException;

    List<Client> findByFirstName(String firstName) throws DAOException;

    List<Client> findBySecondName(String firstName) throws DAOException;

    List<Client> findByMiddleName(String firstName) throws DAOException;
}
