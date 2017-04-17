package efimovta.store.service;

import efimovta.store.OperationCanceledByUserException;
import efimovta.store.dao.ClientDAO;
import efimovta.store.dao.DAOFactory;
import efimovta.store.dao.DeviceDAO;
import efimovta.store.dao.SaleDAO;
import efimovta.store.entity.*;
import efimovta.store.requester.ClientParamsRequester;
import efimovta.store.requester.DeviceParamsRequester;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Searching in interactive mode.
 */
public class Searcher {
    private static ClientDAO clientDAO = DAOFactory.get().getClientDAO();
    private static DeviceDAO deviceDAO = DAOFactory.get().getDeviceDAO();
    private static SaleDAO saleDAO = DAOFactory.get().getSaleDAO();

    private static DeviceParamsRequester dpr =
            DeviceParamsRequester.getInstance();
    private static ClientParamsRequester cpr =
            ClientParamsRequester.getInstance();

    public static List<Client> findAllClients() {
        return clientDAO.getAll();
    }

    public static List<Device> findAllDevices() {
        return deviceDAO.getAll();
    }

    public static List<Sale> findAllSales() {
        return saleDAO.getAll();
    }

    public static List<Device> findDeviceByReleaseDate()
            throws IOException, OperationCanceledByUserException {
        Date date = dpr.requestReleaseDate();
        return deviceDAO.findDeviceByReleaseDate(date);
    }

    public static List<Device> findDeviceByType()
            throws IOException, OperationCanceledByUserException {
        DeviceType type = dpr.requestType();
        return deviceDAO.findDeviceByType(type);
    }

    public static List<Device> findDeviceByBrand()
            throws IOException, OperationCanceledByUserException {
        Brand brand = dpr.requestBrand();
        return deviceDAO.findDevicesByBrand(brand);
    }

    public static List<Client> findClientByFIO()
            throws IOException, OperationCanceledByUserException {
        String[] arrFIO = cpr.requestFIO();
        String fio = Arrays.toString(arrFIO)
                .replaceAll("\\[|\\]|,", "")
                .toLowerCase();
        return clientDAO.findByFIO(fio);
    }

    public static List<Client> findClientByAnyName()
            throws IOException, OperationCanceledByUserException {
        String name = cpr.requestName();
        return clientDAO.findByAnyName(name);
    }
}
