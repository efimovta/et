package efimovta.store.service.creator;

import efimovta.store.OperationCanceledByUserException;
import efimovta.store.OperationCanceledException;
import efimovta.store.dao.DAOException;
import efimovta.store.dao.DAOFactory;
import efimovta.store.dao.SaleDAO;
import efimovta.store.entity.Client;
import efimovta.store.entity.Device;
import efimovta.store.entity.Sale;
import efimovta.store.requester.SaleParamsRequester;

import java.util.Date;
import java.util.Map;

/**
 * Contains static methods to start creating sale instances in
 * interactive mode. Singleton.
 */
public class SaleCreator implements Creator<Sale> {

    private static SaleCreator ourInstance = new SaleCreator();

    private SaleCreator() {

    }

    /**
     * @return Singleton {@link SaleCreator}
     */
    public static SaleCreator getInstance() {
        return ourInstance;
    }

    /**
     * Creating a new sale in interactive mode.
     *
     * @return created sale instance
     */
    public Sale startCreationDialog()
            throws OperationCanceledByUserException, OperationCanceledException {
        SaleDAO saleDAO = DAOFactory.get().getSaleDAO();
        SaleParamsRequester spr = SaleParamsRequester.getInstance();

        Client client = spr.requestClient();
        Date saleDate = new Date();
        Map<Device, Integer> devices = spr.requestDevices();

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
