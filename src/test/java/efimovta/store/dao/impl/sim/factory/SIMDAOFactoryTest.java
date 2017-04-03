package efimovta.store.dao.impl.sim.factory;

import efimovta.store.dao.impl.sim.SIMDAOFactory;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by EFIMOVAT on 26.03.2017.
 */
public class SIMDAOFactoryTest {
    static SIMDAOFactory simdaoFactory = new SIMDAOFactory();

    @Test
    public void getClientDAO() throws Exception {
        assertNotNull(simdaoFactory.getClientDAO());
    }

    @Test
    public void getDeviceDAO() throws Exception {
        assertNotNull(simdaoFactory.getClientDAO());
    }

    @Test
    public void getSaleDAO() throws Exception {
        assertNotNull(simdaoFactory.getClientDAO());
    }

}