package efimovta.store.entity;

import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by EFIMOVAT on 26.03.2017.
 */
public class DeviceTest {
    static Device device;
    static Device device2;
    static int id1 = 1;
    static int id2 = 2;
    static String model = "gtx157";
    static DeviceType type = DeviceType.LAPTOP;
    static Brand brand = Brand.ACER;
    static NamedColor color = NamedColor.BLACK;
    static Date releaseDate = new Date();
    static BigDecimal price = new BigDecimal(1.57);


    @BeforeClass
    public static void setUp() throws Exception {
        device = new Device();
        device.setId(id1);      //different id
        device.setModel(model);
        device.setType(type);
        device.setBrand(brand);
        device.setColor(color);
        device.setReleaseDate(releaseDate);
        device.setPrice(price);
        assertNotNull(device);

        device2 = new Device();
        device2.setId(id2);
        device2.setModel(model);
        device2.setType(type);
        device2.setBrand(brand);
        device2.setColor(color);
        device2.setReleaseDate(releaseDate);
        device2.setPrice(price);
        assertNotNull(device2);
    }

    @Test
    public void deviceEquals() throws Exception {
        assertTrue(device.equals(device2));

    }

    @Test
    public void deviceHashCode() throws Exception {
        assertTrue(device.hashCode() == device2.hashCode());
    }

    @Test
    public void getId() throws Exception {
        assertTrue(device.getId() == id1);
    }

    @Test
    public void deviceToString() throws Exception {
        assertNotNull(device.toString());
    }

    @Test
    public void getModel() throws Exception {
        assertEquals(device.getModel(), model);

    }

    @Test
    public void getType() throws Exception {
        assertEquals(device.getType(), type);

    }

    @Test
    public void getBrand() throws Exception {
        assertEquals(device.getBrand(), brand);

    }

    @Test
    public void getColor() throws Exception {
        assertEquals(device.getColor(), color);

    }

    @Test
    public void getReleaseDate() throws Exception {
        assertEquals(device.getReleaseDate(), releaseDate);

    }

    @Test
    public void getPrice() throws Exception {
        assertEquals(device.getPrice(), price);

    }

}