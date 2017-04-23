package efimovta.store.service;

import efimovta.store.OperationCanceledByUserException;
import efimovta.store.OperationCanceledException;
import efimovta.store.dao.*;
import efimovta.store.entity.*;
import efimovta.store.requester.ClientParamsRequester;
import efimovta.store.requester.DeviceParamsRequester;
import efimovta.store.requester.SaleParamsRequester;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Contains static methods to start creating entities in interactive mode
 */
public class Creator {

    /**
     * Creating a new client in interactive mode.
     *
     * @throws IOException
     * @throws OperationCanceledByUserException
     */
    public static Client startClientCreationDialog() throws IOException,
            OperationCanceledByUserException, OperationCanceledException {
        ClientDAO clientDAO = DAOFactory.get().getClientDAO();
        ClientParamsRequester cpr = ClientParamsRequester.getInstance();

        String[] fio = cpr.requestFIO();
        Date birthDay = cpr.requestBirthDay();

        Client client = new Client();
        client.setSecondName(fio[0]);
        client.setFirstName(fio[1]);
        client.setMiddleName(fio[2]);
        client.setBirthday(birthDay);

        try {
            clientDAO.add(client);
        } catch (DAOException e) {
            throw new OperationCanceledException(
                    "Client was not added: " + client.toString(), e);
        }
        return client;
    }

    /**
     * Creating a new device in interactive mode.
     *
     * @throws IOException
     * @throws OperationCanceledByUserException
     */
    public static Device startDeviceCreationDialog() throws IOException,
            OperationCanceledByUserException, OperationCanceledException {
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

    /**
     * Creating a new sale in interactive mode.
     *
     * @throws IOException
     * @throws OperationCanceledByUserException
     */
    public static Sale startSaleCreationDialog() throws IOException,
            OperationCanceledByUserException, OperationCanceledException {
        SaleDAO saleDAO = DAOFactory.get().getSaleDAO();
        SaleParamsRequester spr = SaleParamsRequester.getInstance();

        Client client = spr.requestClient();
        Date saleDate = new Date();
        Map<Device, Integer> devices = new HashMap<>();
        //TODO CREATE REQUESTER FOR

        Sale sale = new Sale();
        sale.setClient(client);
        sale.setDevices(devices);
        sale.setSaleDate(saleDate);

        try {
            saleDAO.add(sale);
        } catch (DAOException e) {
            throw new OperationCanceledException(
                    "Sale was not added: " + sale.toString(), e);
        }
        return sale;
    }


}
