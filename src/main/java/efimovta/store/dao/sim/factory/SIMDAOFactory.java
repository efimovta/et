package efimovta.store.dao.sim.factory;

import efimovta.store.dao.ClientDAO;
import efimovta.store.dao.DeviceDAO;
import efimovta.store.dao.SaleDAO;
import efimovta.store.dao.factory.DAOFactory;
import efimovta.store.dao.sim.SIMClientDAO;
import efimovta.store.dao.sim.SIMDeviceDAO;
import efimovta.store.dao.sim.SIMSaleDAO;
import efimovta.store.storage.StorageInMemory;

/**
 * Created by jcd on 19.03.2017.
 */
public class SIMDAOFactory extends DAOFactory {
    ClientDAO clientDAO = new SIMClientDAO(StorageInMemory.clients);
    DeviceDAO deviceDAO = new SIMDeviceDAO(StorageInMemory.devices);
    SaleDAO saleDAO = new SIMSaleDAO(StorageInMemory.sales);

    @Override
    public ClientDAO getClientDAO() {
        return clientDAO;
    }

    @Override
    public DeviceDAO getDeviceDAO() {
        return deviceDAO;

    }

    @Override
    public SaleDAO getSaleDAO() {
        return saleDAO;
    }
}
