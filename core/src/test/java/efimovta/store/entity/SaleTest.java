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
    static int id1 = 1;
    static int id2 = 2;
    static Date saleDate = new Date();
    static Client client;
    static Map<Device, Integer> devices;


    @BeforeClass
    public static void setUp() throws Exception {
        client = new Client();
        client.setId(id1);
        client.setFirstName("a");
        client.setSecondName("b");
        client.setMiddleName("c");
        devices = new HashMap<>();

        sale = new Sale();
        sale.setId(id1);        //different id
        sale.setSaleDate(saleDate);
        sale.setClient(client);
        sale.setDevices(devices);

        sale2 = new Sale();
        sale2.setId(id2);
        sale2.setSaleDate(saleDate);
        sale2.setClient(client);
        sale2.setDevices(devices);
    }

    @Test
    public void saleEquals() throws Exception {
        assertTrue(sale.equals(sale2));
    }

    @Test
    public void saleHashCode() throws Exception {
        assertTrue(sale.hashCode() == sale2.hashCode());
    }

    @Test
    public void getId() throws Exception {
        assertTrue(sale.getId() == id1);
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