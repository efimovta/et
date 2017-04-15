package efimovta.store.config;


import efimovta.store.Config;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by jcd on 26.03.2017.
 */
public class ConfigTester {

    @Test
    public void testDataSourceParam() throws Exception {
        assertNotNull(Config.DATA_SOURCE);
    }


}
