package efimovta.store.controller;

import efimovta.store.dao.DeviceDAO;
import efimovta.store.dao.entity.Device;
import efimovta.store.dao.exeption.DAOException;
import efimovta.store.dao.factory.DAOFactory;

/**
 * Created by jcd on 25.03.2017.
 */
public class DeviceControllerImpl extends DeviceController {

    DeviceDAO deviceDAO = DAOFactory.get().getDeviceDAO();

    @Override
    public void addNewDevice(Device device) throws DAOException {
        //todo validator?
        deviceDAO.add(device);
    }
}
