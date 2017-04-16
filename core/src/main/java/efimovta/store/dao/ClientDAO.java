package efimovta.store.dao;

import efimovta.store.entity.Client;

import java.util.List;

/**
 * Unified interface for managing the persistent
 * state of {@link Client} objects
 */
public interface ClientDAO extends GenericDAO<Client> {

    /**
     * Finds the {@link Client} objects with the appropriate FIO
     *
     * @param fio string contains respectively: first,
     *            second and middle names; with space delimiter
     * @return list of {@link Client} objects with
     * the appropriate FIO
     */
    List<Client> findByFIO(String fio);

    /**
     * Finds the {@link Client} objects with the appropriate
     * first name
     *
     * @param firstName first name
     * @return list of {@link Client} objects with
     * the appropriate FIO
     */
    List<Client> findByFirstName(String firstName);

    /**
     * Finds the {@link Client} objects with the appropriate
     * second name
     *
     * @param secondName second name
     * @return list of {@link Client} objects with
     * the appropriate FIO
     */
    List<Client> findBySecondName(String secondName);

    /**
     * Finds the {@link Client} objects with the appropriate
     * middle name
     *
     * @param middleName middle name
     * @return list of {@link Client} objects with
     * the appropriate FIO
     */
    List<Client> findByMiddleName(String middleName);

    /**
     * Finds the {@link Client} objects with the appropriate name
     *
     * @param name any name
     * @return list of {@link Client} objects with
     * the appropriate FIO
     */
    List<Client> findByAnyName(String name);
}
