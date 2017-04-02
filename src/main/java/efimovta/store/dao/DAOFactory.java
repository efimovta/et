package efimovta.store.dao;

import efimovta.store.Config;
import efimovta.store.dao.impl.sim.SIMDAOFactory;

import java.util.HashMap;
import java.util.Map;

import static efimovta.store.dao.DAOFactory.DataSourceNames.STORAGE_IN_MEMORY;

/**
 * Created by jcd on 19.03.2017.
 */
public abstract class DAOFactory {

    private static Map<DataSourceNames, DAOFactory> cache = new HashMap<>();

    public abstract ClientDAO getClientDAO();

    public abstract DeviceDAO getDeviceDAO();

    public abstract SaleDAO getSaleDAO();


    public static DAOFactory get() {
        DAOFactory daoFactory = null;
        switch (Config.DATA_SOURCE) {
            case STORAGE_IN_MEMORY: {
                daoFactory = cache.get(STORAGE_IN_MEMORY);
                if (daoFactory == null) {
                    daoFactory = new SIMDAOFactory();
                    cache.put(STORAGE_IN_MEMORY, daoFactory);
                }
                break;
            }
        }
        return daoFactory;
    }

    public static enum DataSourceNames {
        STORAGE_IN_MEMORY
    }
}
