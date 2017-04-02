package efimovta.store.dao.impl.sim;

import efimovta.store.FindHelper;
import efimovta.store.dao.DeviceDAO;
import efimovta.store.dao.RecordNotFoundException;
import efimovta.store.entity.Brand;
import efimovta.store.entity.Device;
import efimovta.store.entity.DeviceType;

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
    public Device findById(long id) throws RecordNotFoundException {
        return FindHelper.find(records, id, FindHelper.DEVICE_BY_ID).get(0);
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
