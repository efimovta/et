package efimovta.store.dao;

import efimovta.store.dao.exeption.DAOException;
import efimovta.store.entity.Brand;
import efimovta.store.entity.Device;
import efimovta.store.entity.DeviceType;

import java.util.Date;
import java.util.List;

/**
 * Unified interface for managing the persistent state of {@link Device} objects
 */
public interface DeviceDAO extends GenericDAO<Device> {
    /**
     * Finds the {@link Device} objects with the appropriate brand
     *
     * @param brand specific brand
     * @return list of {@link Device} objects with the appropriate brand
     */
    public List<Device> findDevicesByBrand(Brand brand) throws DAOException;

    /**
     * Finds the {@link Device} objects with the appropriate type
     *
     * @param type specific type
     * @return list of {@link Device} objects with the appropriate type
     */
    public List<Device> findDeviceByType(DeviceType type) throws DAOException;

    /**
     * Finds the {@link Device} objects with the appropriate release date
     *
     * @param releaseDate specific release date
     * @return list of {@link Device} objects with the appropriate release date
     */
    public List<Device> findDeviceByReleaseDate(Date releaseDate) throws DAOException;
}
