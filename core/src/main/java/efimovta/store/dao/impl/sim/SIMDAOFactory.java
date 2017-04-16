package efimovta.store.dao.impl.sim;

import efimovta.store.dao.ClientDAO;
import efimovta.store.dao.DAOFactory;
import efimovta.store.dao.DeviceDAO;
import efimovta.store.dao.SaleDAO;

/**
 * Concrete abstract factory for DAO.
 */
public class SIMDAOFactory extends DAOFactory {
    private ClientDAO clientDAO = new SIMClientDAO();
    private DeviceDAO deviceDAO = new SIMDeviceDAO();
    private SaleDAO saleDAO = new SIMSaleDAO();


    /**
     * @return {@link SIMClientDAO}
     */
    @Override
    public ClientDAO getClientDAO() {
        return clientDAO;
    }

    /**
     * @return {@link SIMDeviceDAO}
     */
    @Override
    public DeviceDAO getDeviceDAO() {
        return deviceDAO;
    }

    /**
     * @return {@link SIMSaleDAO}
     */
    @Override
    public SaleDAO getSaleDAO() {
        return saleDAO;
    }
}
