package efimovta.store.dao.impl.sim;

import efimovta.store.dao.RecordNotFoundException;
import efimovta.store.entity.Brand;
import efimovta.store.entity.Client;
import efimovta.store.entity.Device;
import efimovta.store.entity.DeviceType;
import efimovta.store.entity.NamedColor;
import efimovta.store.entity.Sale;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

/**
 * Created by EFIMOVAT on 26.03.2017.
 */
public class SIMSaleDAOTest {
    static final public ArrayList<Device> devices = new ArrayList<>();
    static final public ArrayList<Client> clients = new ArrayList<>();
    static final public ArrayList<Sale> sales = new ArrayList<>();

    static SIMSaleDAO simSaleDAO = new SIMSaleDAO();
    static SIMClientDAO simClientDAO = new SIMClientDAO();
    static SIMDeviceDAO simDeviceDAO = new SIMDeviceDAO();

    static Client client;
    static Client client2;

    static String model = "gtx1575456456";
    static DeviceType type = DeviceType.LAPTOP;
    static Brand brand = Brand.ACER;
    static NamedColor color = NamedColor.BLACK;
    static Date releaseDate = new Date();
    static Date releaseDate2 = new Date(0);
    static BigDecimal price = new BigDecimal(1.57);

    static Device device;
    static Device device2;


    @BeforeClass
    public static void setUp() throws Exception {
        client = new Client();
        client.setSecondName("Васильев123");
        client.setFirstName("Вася");
        client.setMiddleName("Васильевич");
        client.setBirthday(DateFormat.getDateInstance().parse("11.11.1994"));

        client2 = new Client();
        client2.setSecondName("Васильев2123");
        client2.setFirstName("Вася2");
        client2.setMiddleName("Васильевич2");
        client2.setBirthday(DateFormat.getDateInstance().parse("22.22.2994"));


        clients.add(client);
        clients.add(client2);

        simClientDAO.add(client);
        simClientDAO.add(client2);


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


        devices.add(device);
        devices.add(device2);

        simDeviceDAO.add(device);
        simDeviceDAO.add(device2);


        Map<Device, Integer> ds = new HashMap<>();
        ds.put(device, 3);
        ds.put(device2, 2);
        Sale sale = new Sale();
        sale.setSaleDate(new Date());
        sale.setClient(client);
        sale.setDevices(ds);

        sales.add(sale);
        simSaleDAO.add(sale);
    }
//
//    @Test
//    public void add() throws Exception {
//        Map<Device, Integer> ds = new HashMap<>();
//        ds.put(device, 3);
//
//        Sale sale = Sale.getBuilder()
//                ;sale.setSaleDate(new Date())
//                ;sale.setClient(client)
//                ;sale.setDevices(ds)
//                .build();
//
//        simSaleDAO.add(sale);
//        assertTrue(sales.contains(sale));
//    }

    //You can not add a purchase to a client or device that does not exist in the database
    @Test(expected = RecordNotFoundException.class)
    public void addFail() throws Exception {
        Client c;
        c = new Client();
        c.setSecondName("В");
        c.setFirstName("Ва");
        c.setMiddleName("Вас");
        c.setBirthday(new Date());

        Map<Device, Integer> ds = new HashMap<>();
        ds.put(device, 3);

        Sale sale = new Sale();
        sale.setSaleDate(new Date());
        sale.setClient(c);
        sale.setDevices(ds);

        simSaleDAO.add(sale);
        assertTrue(sales.contains(sale));
    }

    @Test
    public void findBySaleId() throws Exception {
        Sale sale = sales.get(0);
        Sale ss = simSaleDAO.findById(sale.getId());
        assertTrue(ss.equals(sale));
    }


    @Test
    public void findBySaleDate() throws Exception {
        Sale sale = sales.get(0);
        List<Sale> ss = simSaleDAO.findBySaleDate(sale.getSaleDate());
        assertTrue(ss.contains(sale));
    }

}