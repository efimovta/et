package efimovta.store.dao;

import efimovta.store.entity.Sale;

import java.util.Date;
import java.util.List;

/**
 * Unified interface for managing the persistent state of {@link Sale} objects
 */
public interface SaleDAO extends GenericDAO<Sale> {

    /**
     * Finds the {@link Sale} objects by client id
     *
     * @param id client id
     * @return list of {@link Sale} objects founded by client id
     */
    public List<Sale> findByClientId(long id) throws DAOException;

    /**
     * Finds the {@link Sale} objects by device id
     *
     * @param id device id
     * @return list of {@link Sale} objects founded by device id
     */
    public List<Sale> findByDeviceId(long id) throws DAOException;

    /**
     * Finds the {@link Sale} objects by sale date
     *
     * @param saleDate sale date
     * @return list of {@link Sale} objects founded by sale date
     */
    public List<Sale> findBySaleDate(Date saleDate) throws DAOException;
}
