package efimovta.store.menu.creator;

import efimovta.store.dao.DeviceDAO;
import efimovta.store.dao.entity.Device;
import efimovta.store.dao.entity.enums.Brand;
import efimovta.store.dao.entity.enums.DeviceType;
import efimovta.store.dao.entity.enums.NamedColor;
import efimovta.store.dao.exeption.DAOException;
import efimovta.store.dao.factory.DAOFactory;
import efimovta.store.menu.exception.OperationCanceledByUserException;
import efimovta.store.menu.requester.DeviceParamsRequester;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by jcd on 13.03.2017.
 */
public class DeviceCreator extends Creator {//todo mb singleton


    public void startCreationDialog() throws IOException, OperationCanceledByUserException {
        DeviceDAO deviceDAO = DAOFactory.get().getDeviceDAO();
        DeviceParamsRequester dpr = DeviceParamsRequester.getInstance();
        DeviceType type = dpr.requestType();
        String model = dpr.requestModel();
        Brand brand = dpr.requestBrand();
        NamedColor color = dpr.requestColor();
        Date releaseDate = dpr.requestReleaseDate();
        BigDecimal price = dpr.requestPrice();

        Device device = Device.getBuilder()
                .setModel(model)
                .setType(type)
                .setBrand(brand)
                .setColor(color)
                .setReleaseDate(releaseDate)
                .setPrice(price)
                .build();


        //todo validator?
        try {
            deviceDAO.add(device);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
