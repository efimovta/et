package efimovta.store.dao.sim;

import efimovta.store.dao.DeviceDAO;
import efimovta.store.dao.exeption.RecordNotFoundException;
import efimovta.store.dao.sim.helper.FindHelper;
import efimovta.store.entity.Device;
import efimovta.store.enums.Brand;
import efimovta.store.enums.DeviceType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jcd on 19.03.2017.
 */
public class SIMDeviceDAO extends SIMGenericDAO<Device> implements DeviceDAO {

    public SIMDeviceDAO(ArrayList<Device> records) {
        super(records);
    }

    @Override
    public List<Device> findDevicesByBrand(Brand brand) throws RecordNotFoundException {
        return FindHelper.find(records, brand, FindHelper.DEVICE_BY_BRAND);
    }

    @Override
    public List<Device> findDeviceByType(DeviceType type) throws RecordNotFoundException {
        return FindHelper.find(records, type, FindHelper.DEVICE_BY_TYPE);
    }

    @Override
    public List<Device> findDeviceByReleaseDate(Date releaseDate) throws RecordNotFoundException {
        return FindHelper.find(records, releaseDate, FindHelper.DEVICE_BY_RELEASE_DATE);
    }
}
