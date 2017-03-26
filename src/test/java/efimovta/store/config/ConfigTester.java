package efimovta.store.config;


import org.junit.Test;

import static org.junit.Assert.assertNull;

/**
 * Created by jcd on 26.03.2017.
 */
public class ConfigTester {

    @Test
    public void testDataSourceParam() throws Exception {
        assertNull(Config.DATA_SOURCE);
    }
}
