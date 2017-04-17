package efimovta.store.dao.impl.sim;

import efimovta.store.dao.ClientDAO;
import efimovta.store.dao.DAOFactory;
import efimovta.store.dao.DeviceDAO;
import efimovta.store.dao.SaleDAO;

/**
 * Concrete abstract factory for DAO.
 * Returns singletons.
 */
public class SIMDAOFactory extends DAOFactory {
    private ClientDAO clientDAO = new SIMClientDAO();
    private DeviceDAO deviceDAO = new SIMDeviceDAO();
    private SaleDAO saleDAO = new SIMSaleDAO();


    /**
     * @return Singleton {@link SIMClientDAO}
     */
    @Override
    public ClientDAO getClientDAO() {
        return clientDAO;
    }

    /**
     * @return Singleton {@link SIMDeviceDAO}
     */
    @Override
    public DeviceDAO getDeviceDAO() {
        return deviceDAO;
    }

    /**
     * @return Singleton {@link SIMSaleDAO}
     */
    @Override
    public SaleDAO getSaleDAO() {
        return saleDAO;
    }
}
