package efimovta.store.entity;

import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by EFIMOVAT on 26.03.2017.
 */
public class DeviceTest {
    static Device device;
    static Device device2;
    static String model = "gtx157";
    static DeviceType type = DeviceType.LAPTOP;
    static Brand brand = Brand.ACER;
    static NamedColor color = NamedColor.BLACK;
    static Date releaseDate = new Date();
    static BigDecimal price = new BigDecimal(1.57);


    @BeforeClass
    public static void setUp() throws Exception {
        Device builder = new Device();
        assertNotNull(builder);

        device = builder
                .setModel(model)
                .setType(type)
                .setBrand(brand)
                .setColor(color)
                .setReleaseDate(releaseDate)
                .setPrice(price)
                ;
        assertNotNull(device);

        device2 = builder
                .setModel(model)
                .setType(type)
                .setBrand(brand)
                .setColor(color)
                .setReleaseDate(releaseDate)
                .setPrice(price)
                ;
        assertNotNull(device2);
    }

    @Test
    public void deviceEquals() throws Exception {
        assertTrue(device.equals(device2));

    }

    @Test
    public void deviceHashCode() throws Exception {
        assertTrue(device.hashCode()==device2.hashCode());
    }
    
    @Test
    public void getId() throws Exception {
        assertNotNull(device.getId());
        assertTrue(device.getId() > 0);
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