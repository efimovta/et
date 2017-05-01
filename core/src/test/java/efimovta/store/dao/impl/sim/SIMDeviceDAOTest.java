package efimovta.store.dao.impl.sim;

import efimovta.store.entity.Brand;
import efimovta.store.entity.Device;
import efimovta.store.entity.DeviceType;
import efimovta.store.entity.NamedColor;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by EFIMOVAT on 26.03.2017.
 */
public class SIMDeviceDAOTest {
    static String model = "gtx157";
    static DeviceType type = DeviceType.LAPTOP;
    static Brand brand = Brand.ACER;
    static NamedColor color = NamedColor.BLACK;
    static Date releaseDate = new Date();
    static Date releaseDate2 = new Date(0);
    static BigDecimal price = new BigDecimal(1.57);

    static SIMDeviceDAO simDeviceDAO;
    static Device device;
    static Device device2;

    @BeforeClass
    public static void setUp() throws Exception {
        device = new Device();
        device.setModel(model);
        device.setType(type);
        device.setBrand(brand);
        device.setColor(color);
        device.setReleaseDate(releaseDate);
        device.setPrice(price);

        device2 = new Device();
        device2.setModel(model);
        device2.setType(type);
        device2.setBrand(brand);
        device2.setColor(color);
        device2.setReleaseDate(releaseDate2);
        device2.setPrice(price);

        simDeviceDAO = new SIMDeviceDAO();
        simDeviceDAO.add(device);
        simDeviceDAO.add(device2);

    }


    @Test
    public void findDevicesByBrand() throws Exception {
        List<Device> list = simDeviceDAO.findDevicesByBrand(brand);
        assertTrue(list.contains(device));
        assertTrue(list.contains(device2));
    }

    @Test
    public void findDeviceByType() throws Exception {
        List<Device> list = simDeviceDAO.findDeviceByType(type);
        assertTrue(list.contains(device));
        assertTrue(list.contains(device2));

    }

    @Test
    public void findDeviceByReleaseDate() throws Exception {
        List<Device> list = simDeviceDAO.findDeviceByReleaseDate(releaseDate);
        assertTrue(list.contains(device));
        assertFalse(list.contains(device2));
    }

}