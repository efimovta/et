package efimovta.store;


import efimovta.store.dao.DAOFactory;
import efimovta.store.dao.impl.sim.SIMDAOFactory;

/**
 * Class is used as a configuration file
 */
public class Config {
    public static final DAOFactory DATA_SOURCE = new SIMDAOFactory();

    public static final String BACKUP_LOCATION =
            "store.backup";//i.e. Next to jar

    private Config() {
    }
}
