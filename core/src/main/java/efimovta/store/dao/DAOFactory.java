package efimovta.store.dao;

import efimovta.store.Config;

/**
 * Abstract factory for DAO.
 * Static method get() returns realization defined in {@link Config#DATA_SOURCE}
 */
public abstract class DAOFactory {

    /**
     * @return realization of {@link ClientDAO}
     */
    public abstract ClientDAO getClientDAO();


    /**
     * @return realization of {@link DeviceDAO}
     */
    public abstract DeviceDAO getDeviceDAO();

    /**
     * @return realization of {@link SaleDAO}
     */
    public abstract SaleDAO getSaleDAO();

    /**
     * @return realization of {@link DAOFactory} defined in {@link Config#DATA_SOURCE}
     */
    public static DAOFactory get() {
        return Config.DATA_SOURCE;
    }
}
