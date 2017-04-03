package efimovta.store.dao.impl.sim;

import efimovta.store.FindHelper;
import efimovta.store.dao.DAOException;
import efimovta.store.dao.DeviceDAO;
import efimovta.store.entity.Brand;
import efimovta.store.entity.Device;
import efimovta.store.entity.DeviceType;

import java.io.Serializable;
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
    public void add(Device object) throws DAOException {

    }

    @Override
    public Device findById(long id) throws DAOException {
        Device d = FindHelper.find(records, id, FindHelper.DEVICE_BY_ID)
                .get(0);
        return serialize(d);
    }

    @Override
    public List<Device> findDevicesByBrand(Brand brand) throws DAOException {
        List<Device> list = FindHelper.find(records, brand,
                FindHelper.DEVICE_BY_BRAND);
        return (List<Device>) serialize((Serializable) list);
    }

    @Override
    public List<Device> findDeviceByType(DeviceType type) throws DAOException {
        List<Device> list = FindHelper.find(records, type,
                FindHelper.DEVICE_BY_TYPE);
        return (List<Device>) serialize((Serializable)list);
    }

    @Override
    public List<Device> findDeviceByReleaseDate(Date releaseDate) throws
            DAOException {
        List<Device> list = FindHelper.find(records, releaseDate,
                FindHelper.DEVICE_BY_RELEASE_DATE);
        return (List<Device>) serialize((Serializable)list);
    }
}
