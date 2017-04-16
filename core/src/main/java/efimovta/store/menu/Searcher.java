package efimovta.store.menu;

import efimovta.store.dao.*;
import efimovta.store.entity.*;
import efimovta.store.menu.requester.ClientParamsRequester;
import efimovta.store.menu.requester.DeviceParamsRequester;

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

    private static DeviceParamsRequester dpr = DeviceParamsRequester.getInstance();
    private static ClientParamsRequester cpr = ClientParamsRequester.getInstance();

    public static List<Client> findAllClients() throws DAOException {
        return clientDAO.getAll();
    }

    public static List<Device> findAllDevices() throws DAOException {
        return deviceDAO.getAll();
    }

    public static List<Sale> findAllSales() throws DAOException {
        return saleDAO.getAll();
    }

    public static List<Device> findDeviceByReleaseDate()
            throws IOException, OperationCanceledByUserException, DAOException {
        Date date = dpr.requestReleaseDate();
        return deviceDAO.findDeviceByReleaseDate(date);
    }

    public static List<Device> findDeviceByType()
            throws IOException, OperationCanceledByUserException, DAOException {
        DeviceType type = dpr.requestType();
        return deviceDAO.findDeviceByType(type);
    }

    public static List<Device> findDeviceByBrand()
            throws IOException, OperationCanceledByUserException, DAOException {
        Brand brand = dpr.requestBrand();
        return deviceDAO.findDevicesByBrand(brand);
    }

    public static List<Client> findClientByFIO()
            throws IOException, OperationCanceledByUserException, DAOException {
        String[] arrFIO = cpr.requestFIO();
        String fio = Arrays.toString(arrFIO)
                .replaceAll("\\[|\\]|,", "")
                .toLowerCase();
        return clientDAO.findByFIO(fio);
    }

    public static List<Client> findClientByAnyName()
            throws IOException, OperationCanceledByUserException, DAOException {
        String name = cpr.requestName();
        return clientDAO.findByAnyName(name);
    }
}
