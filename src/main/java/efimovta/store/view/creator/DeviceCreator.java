package efimovta.store.view.creator;

import efimovta.store.controller.DeviceController;
import efimovta.store.controller.DeviceControllerFactory;
import efimovta.store.dao.entity.Device;
import efimovta.store.dao.entity.enums.Brand;
import efimovta.store.dao.entity.enums.DeviceType;
import efimovta.store.dao.entity.enums.NamedColor;
import efimovta.store.dao.exeption.DAOException;
import efimovta.store.view.creator.requester.DeviceParamsRequester;
import efimovta.store.view.exception.OperationCanceledByUserException;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by jcd on 13.03.2017.
 */
public class DeviceCreator extends Creator {//todo mb singleton


    public void startCreationDialog() throws IOException, OperationCanceledByUserException {
        DeviceController deviceController = (new DeviceControllerFactory()).get();
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

        try {
            deviceController.addNewDevice(device);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
