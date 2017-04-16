package efimovta.store.menu;

import efimovta.store.Utility;
import efimovta.store.dao.*;
import efimovta.store.entity.*;
import efimovta.store.menu.requester.ClientParamsRequester;
import efimovta.store.menu.requester.DeviceParamsRequester;
import efimovta.store.menu.requester.SaleParamsRequester;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jcd on 13.03.2017.
 */
public class Creator {

    /**
     * Creating a new client in interactive mode.
     * @throws IOException
     * @throws OperationCanceledByUserException
     */
    public static void startClientCreationDialog() throws IOException, OperationCanceledByUserException {
        ClientDAO clientDAO = DAOFactory.get().getClientDAO();
        ClientParamsRequester cpr = ClientParamsRequester.getInstance();

        String[] fio = cpr.requestFIO();
        Date birthDay = cpr.requestBirthDay();

        Client client = new Client()
                .setSecondName(fio[0])
                .setFirtsName(fio[1])
                .setMiddleName(fio[2])
                .setBirthday(birthDay);

        //todo validator?
        try {
            clientDAO.add(client);
        } catch (DAOException e) {
            Utility.printErr(e.getMessage());
        }
    }

    /**
     * Creating a new device in interactive mode.
     * @throws IOException
     * @throws OperationCanceledByUserException
     */
    public static void startDeviceCreationDialog() throws IOException, OperationCanceledByUserException {
        DeviceDAO deviceDAO = DAOFactory.get().getDeviceDAO();
        DeviceParamsRequester dpr = DeviceParamsRequester.getInstance();
        DeviceType type = dpr.requestType();
        String model = dpr.requestModel();
        Brand brand = dpr.requestBrand();
        NamedColor color = dpr.requestColor();
        Date releaseDate = dpr.requestReleaseDate();
        BigDecimal price = dpr.requestPrice();

        Device device = new Device()
                .setModel(model)
                .setType(type)
                .setBrand(brand)
                .setColor(color)
                .setReleaseDate(releaseDate)
                .setPrice(price);


        //todo validator?
        try {
            deviceDAO.add(device);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creating a new sale in interactive mode.
     * @throws IOException
     * @throws OperationCanceledByUserException
     */
    public static void startSaleCreationDialog() throws IOException, OperationCanceledByUserException {
        SaleDAO saleDAO = DAOFactory.get().getSaleDAO();
        SaleParamsRequester spr = SaleParamsRequester.getInstance();

        Client client = spr.requestClient();
        Date saleDate = new Date();
        Map<Device, Integer> devices=new HashMap<>();//TODO CREATE REQUESTER FOR

        Sale sale = new Sale()
                .setClient(client)
                .setDevices(devices)
                .setSaleDate(saleDate);

        //todo validator?

        try {
            saleDAO.add(sale);
        } catch (DAOException e) {
            Utility.printErr(e.getMessage());
        }

    }


}
