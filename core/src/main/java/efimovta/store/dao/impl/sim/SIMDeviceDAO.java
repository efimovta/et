package efimovta.store.dao.impl.sim;

import efimovta.store.FindHelper;
import efimovta.store.Utility;
import efimovta.store.dao.DeviceDAO;
import efimovta.store.dao.NotAllFieldsAreFilledException;
import efimovta.store.dao.RecordAlreadyExistsException;
import efimovta.store.entity.Brand;
import efimovta.store.entity.Device;
import efimovta.store.entity.DeviceType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Class provide DAO for {@link Device}
 */
public class SIMDeviceDAO extends SIMGenericDAO<Device> implements DeviceDAO {
    protected List<Device> deviceRecords = StorageInMemory.deviceRecords;

    /**
     * Adding a device if all fields are not null and device not
     * already exists
     *
     * @param device for adding
     * @throws RecordAlreadyExistsException
     * @throws NotAllFieldsAreFilledException
     */
    @Override
    public void add(Device device) throws RecordAlreadyExistsException,
            NotAllFieldsAreFilledException {
        checkBeforeAdd(device);
        deviceRecords.add(device.getClone());
    }

    /**
     * Device search by id
     *
     * @param id id of device
     * @return founded device or null otherwise
     */
    @Override
    public Device findById(long id) {
        Device device = null;
        List<Device> list = FindHelper.find(deviceRecords, id,
                FindHelper.DEVICE_BY_ID);
        if (!list.isEmpty()) {
            device = list.get(0).getClone();
        }
        return device;
    }

    /**
     * Device search by brand
     *
     * @param brand of device
     * @return founded device or empty list otherwise
     * @see Brand
     */
    @Override
    public List<Device> findDevicesByBrand(Brand brand) {
        List<Device> devices = FindHelper.find(deviceRecords, brand,
                FindHelper.DEVICE_BY_BRAND);
        if (!devices.isEmpty()) {
            devices = Utility.deepCopy(devices);
        }
        return devices;
    }

    /**
     * Device search by type
     *
     * @param type of device
     * @return founded device or empty list otherwise
     * @see DeviceType
     */
    @Override
    public List<Device> findDeviceByType(DeviceType type) {
        List<Device> devices = FindHelper.find(deviceRecords, type,
                FindHelper.DEVICE_BY_TYPE);
        if (!devices.isEmpty()) {
            devices = Utility.deepCopy(devices);
        }
        return devices;
    }

    /**
     * Device search by release date
     *
     * @param releaseDate of device
     * @return founded device or empty list otherwise
     */
    @Override
    public List<Device> findDeviceByReleaseDate(Date releaseDate) {
        List<Device> devices = FindHelper.find(deviceRecords, releaseDate,
                FindHelper.DEVICE_BY_RELEASE_DATE);
        if (!devices.isEmpty()) {
            devices = Utility.deepCopy(devices);
        }
        return devices;
    }

    /**
     * Get all devices
     *
     * @return all devices or empty list if not exists
     */
    @Override
    public List<Device> getAll() {
        List<Device> devices;
        if (deviceRecords.size() == 0) {
            devices = new ArrayList<>(0);
        } else {
            devices = Utility.deepCopy(deviceRecords);
        }
        return devices;
    }

    @Override
    protected void checkNullFields(Device device)
            throws NotAllFieldsAreFilledException {
        if (device.getBrand() == null
                || device.getColor() == null
                || device.getModel() == null
                || device.getPrice() == null
                || device.getReleaseDate() == null
                || device.getType() == null) {
            throw new NotAllFieldsAreFilledException();
        }
    }

    @Override
    protected void checkAlreadyExists(Device d)
            throws RecordAlreadyExistsException {
        if (deviceRecords.contains(d)) {
            throw new RecordAlreadyExistsException();
        }
    }
}
