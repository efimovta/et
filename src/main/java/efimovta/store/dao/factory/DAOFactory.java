package efimovta.store.dao.factory;

import efimovta.store.dao.ClientDAO;
import efimovta.store.dao.DeviceDAO;
import efimovta.store.dao.SaleDAO;
import efimovta.store.dao.sim.factory.SIMDAOFactory;

/**
 * Created by jcd on 19.03.2017.
 */
public abstract class DAOFactory {
    public static final int STORAGE_IN_MEMORY = 1;


    public abstract ClientDAO getClientDAO();

    public abstract DeviceDAO getDeviceDAO();

    public abstract SaleDAO getSaleDAO();


    public static DAOFactory getDAOFactory(int whichFactory)  {

        switch (whichFactory) {
            case STORAGE_IN_MEMORY:
                return new SIMDAOFactory();
        }
        return null;
    }
}
