package efimovta.store.dao.sim.factory;

import efimovta.store.dao.sim.SIMDeviceDAO;
import efimovta.store.dao.sim.SIMSaleDAO;
import efimovta.store.storage.StorageInMemory;
import efimovta.store.dao.ClientDAO;
import efimovta.store.dao.factory.DAOFactory;
import efimovta.store.dao.DeviceDAO;
import efimovta.store.dao.SaleDAO;
import efimovta.store.dao.sim.SIMClientDAO;

/**
 * Created by jcd on 19.03.2017.
 */
public class SIMDAOFactory extends DAOFactory {

    @Override
    public ClientDAO getClientDAO() {
        return new SIMClientDAO(StorageInMemory.clients);
    }

    @Override
    public DeviceDAO getDeviceDAO() {
        return new SIMDeviceDAO(StorageInMemory.devices);

    }

    @Override
    public SaleDAO getSaleDAO() {
        return new SIMSaleDAO(StorageInMemory.sales);
    }
}
