package efimovta.store.entity;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by EFIMOVAT on 26.03.2017.
 */
public class SaleTest {
    static Sale sale;
    static Sale sale2;
    static Date saleDate = new Date();
    static Client client = Client.getBuilder().build();
    static Map<Device, Integer> devices = new HashMap<>();


    @BeforeClass
    public static void setUp() throws Exception {
        Sale.Builder builder = Sale.getBuilder();
        assertNotNull(builder);

        sale = builder
                .setSaleDate(saleDate)
                .setClient(client)
                .setDevices(devices)
                .build();
        assertNotNull(sale);

        sale2 = builder
                .setSaleDate(saleDate)
                .setClient(client)
                .setDevices(devices)
                .build();
        assertNotNull(sale2);
    }

    @Test
    public void saleEquals() throws Exception {
        assertTrue(sale.equals(sale2));

    }

    @Test
    public void saleHashCode() throws Exception {
        assertTrue(sale.hashCode()==sale2.hashCode());
    }

    @Test
    public void getId() throws Exception {
        assertNotNull(sale.getId());
        assertTrue(sale.getId() > 0);
    }

    @Test
    public void saleToString() throws Exception {
        assertNotNull(sale.toString());
    }

    @Test
    public void getClient() throws Exception {
        assertEquals(sale.getClient(), client);
    }

    @Test
    public void getSaleDate() throws Exception {
        assertEquals(sale.getSaleDate(), saleDate);
    }

    @Test
    public void getDevices() throws Exception {
        assertEquals(sale.getDevices(), devices);
    }


}