package efimovta.store.service.creator;

import efimovta.store.OperationCanceledByUserException;
import efimovta.store.OperationCanceledException;
import efimovta.store.dao.DAOException;
import efimovta.store.dao.DAOFactory;
import efimovta.store.dao.DeviceDAO;
import efimovta.store.entity.Brand;
import efimovta.store.entity.Device;
import efimovta.store.entity.DeviceType;
import efimovta.store.entity.NamedColor;
import efimovta.store.requester.DeviceParamsRequester;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Contains static methods to start creating device instances in
 * interactive mode. Singleton.
 */
public class DeviceCreator implements Creator<Device> {

    private static DeviceCreator ourInstance = new DeviceCreator();

    private DeviceCreator() {

    }

    /**
     * @return Singleton {@link DeviceCreator}
     */
    public static DeviceCreator getInstance() {
        return ourInstance;
    }


    /**
     * Creating a new device in interactive mode.
     *
     * @return created device instance
     */
    public Device startCreationDialog()
            throws OperationCanceledByUserException, OperationCanceledException {
        DeviceDAO deviceDAO = DAOFactory.get().getDeviceDAO();
        DeviceParamsRequester dpr = DeviceParamsRequester.getInstance();
        DeviceType type = dpr.requestType();
        String model = dpr.requestModel();
        Brand brand = dpr.requestBrand();
        NamedColor color = dpr.requestColor();
        Date releaseDate = dpr.requestReleaseDate();
        BigDecimal price = dpr.requestPrice();

        Device device = new Device();
        device.setModel(model);
        device.setType(type);
        device.setBrand(brand);
        device.setColor(color);
        device.setReleaseDate(releaseDate);
        device.setPrice(price);


        try {
            deviceDAO.add(device);
        } catch (DAOException e) {
            throw new OperationCanceledException(
                    "Device was not added: " + device.toString(), e);
        }
        return device;
    }

}
