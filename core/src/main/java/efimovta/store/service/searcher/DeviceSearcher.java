package efimovta.store.service.searcher;

import efimovta.store.OperationCanceledByUserException;
import efimovta.store.dao.DAOFactory;
import efimovta.store.dao.DeviceDAO;
import efimovta.store.entity.Brand;
import efimovta.store.entity.Device;
import efimovta.store.entity.DeviceType;
import efimovta.store.requester.DeviceParamsRequester;

import java.util.Date;
import java.util.List;

/**
 * Searching devices in interactive mode. Singleton.
 */
public class DeviceSearcher implements Searcher<Device> {
    private static DeviceSearcher ourInstance = new DeviceSearcher();
    private static DeviceDAO deviceDAO = DAOFactory.get().getDeviceDAO();

    private static DeviceParamsRequester dpr =
            DeviceParamsRequester.getInstance();


    protected DeviceSearcher() {

    }

    /**
     * @return Singleton {@link DeviceSearcher}
     */
    public static DeviceSearcher getInstance() {
        return ourInstance;
    }

    /**
     * @return all devices
     */
    @Override
    public List<Device> findAll() {
        return deviceDAO.getAll();
    }


    /**
     * Request release date from the user and return devices
     * with corresponding release date
     *
     * @return devices with corresponding release date
     * @throws OperationCanceledByUserException if user cancel operation
     */
    public List<Device> findByReleaseDate()
            throws OperationCanceledByUserException {
        Date date = dpr.requestReleaseDate();
        return deviceDAO.findDeviceByReleaseDate(date);
    }

    /**
     * Request type from the user and return devices
     * with corresponding type
     *
     * @return devices with corresponding type
     * @throws OperationCanceledByUserException if user cancel operation
     */
    public List<Device> findByType()
            throws OperationCanceledByUserException {
        DeviceType type = dpr.requestType();
        return deviceDAO.findDeviceByType(type);
    }

    /**
     * Request brand from the user and return devices
     * with corresponding brand
     *
     * @return devices with corresponding brand
     * @throws OperationCanceledByUserException if user cancel operation
     */
    public List<Device> findDeviceByBrand()
            throws OperationCanceledByUserException {
        Brand brand = dpr.requestBrand();
        return deviceDAO.findDevicesByBrand(brand);
    }
}
