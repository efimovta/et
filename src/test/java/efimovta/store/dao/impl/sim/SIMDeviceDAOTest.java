package efimovta.store.dao.impl.sim;

import efimovta.store.entity.Brand;
import efimovta.store.entity.Device;
import efimovta.store.entity.DeviceType;
import efimovta.store.entity.NamedColor;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
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
    static ArrayList<Device> source;

    @BeforeClass
    public static void setUp() throws Exception {
        device = new Device()
                .setModel(model)
                .setType(type)
                .setBrand(brand)
                .setColor(color)
                .setReleaseDate(releaseDate)
                .setPrice(price);

        device2 = new Device()
                .setModel(model)
                .setType(type)
                .setBrand(brand)
                .setColor(color)
                .setReleaseDate(releaseDate2)//not releaseDate !!!
                .setPrice(price);

        source = new ArrayList<>();
        source.add(device);
        source.add(device2);

        simDeviceDAO = new SIMDeviceDAO(source);
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