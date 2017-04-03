package efimovta.store.dao.factory;

import efimovta.store.dao.DAOFactory;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by EFIMOVAT on 26.03.2017.
 */
public class DAOFactoryTest {
    @Test
    public void get() throws Exception {
        assertNotNull(DAOFactory.get());
    }
}