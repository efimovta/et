package efimovta.store.dao.impl.sim;

import efimovta.store.dao.entity.Client;
import efimovta.store.dao.entity.Device;
import efimovta.store.dao.entity.Sale;
import efimovta.store.dao.entity.enums.Brand;
import efimovta.store.dao.entity.enums.DeviceType;
import efimovta.store.dao.entity.enums.NamedColor;
import efimovta.store.dao.exeption.RecordNotFoundException;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by EFIMOVAT on 26.03.2017.
 */
public class SIMSaleDAOTest {
    static final public ArrayList<Device> devices = new ArrayList<>();
    static final public ArrayList<Client> clients = new ArrayList<>();
    static final public ArrayList<Sale> sales = new ArrayList<>();

    static SIMSaleDAO simSaleDAO = new SIMSaleDAO(sales);

    static Client client;
    static Client client2;

    static String model = "gtx157";
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
        client = Client.getBuilder()
                .setSecondName("Васильев")
                .setName("Вася")
                .setMiddleName("Васильевич")
                .setBirthDay(DateFormat.getDateInstance().parse("11.11.1994"))
                .build();

        client2 = Client.getBuilder()
                .setSecondName("Васильев2")
                .setName("Вася2")
                .setMiddleName("Васильевич2")
                .setBirthDay(DateFormat.getDateInstance().parse("22.22.2994"))
                .build();

        clients.add(client);
        clients.add(client2);

        device = Device.getBuilder()
                .setModel(model)
                .setType(type)
                .setBrand(brand)
                .setColor(color)
                .setReleaseDate(releaseDate)
                .setPrice(price)
                .build();

        device2 = Device.getBuilder()
                .setModel(model)
                .setType(type)
                .setBrand(brand)
                .setColor(color)
                .setReleaseDate(releaseDate2)//not releaseDate !!!
                .setPrice(price)
                .build();

        devices.add(device);
        devices.add(device2);


        Map<Device, Integer> ds = new HashMap<>();
        ds.put(device, 3);
        Sale sale = Sale.getBuilder()
                .setSaleDate(new Date())
                .setClient(client)
                .setDevices(ds)
                .build();

        sales.add(sale);
    }

    @Test
    public void add() throws Exception {
        Map<Device, Integer> ds = new HashMap<>();
        ds.put(device, 3);

        Sale sale = Sale.getBuilder()
                .setSaleDate(new Date())
                .setClient(client)
                .setDevices(ds)
                .build();

        simSaleDAO.add(sale);
        assertTrue(sales.contains(sale));
    }

    //You can not add a purchase to a client or device that does not exist in the database
    @Test(expected = RecordNotFoundException.class)
    public void addFail() throws Exception {
        Client c = Client.getBuilder().build();

        Map<Device, Integer> ds = new HashMap<>();
        ds.put(device, 3);

        Sale sale = Sale.getBuilder()
                .setSaleDate(new Date())
                .setClient(c)
                .setDevices(ds)
                .build();

        simSaleDAO.add(sale);
        assertTrue(sales.contains(sale));
    }

    @Test
    public void findBySaleId() throws Exception {
        Sale sale = sales.get(0);
        List<Sale> ss = simSaleDAO.findBySaleId(sale.getId());
        assertTrue(ss.size() == 1);
        assertTrue(ss.contains(sales.get(0)));
    }

    @Test
    public void findByClientId() throws Exception {
        Client client = clients.get(0);
        List<Sale> ss = simSaleDAO.findBySaleId(client.getId());
        assertTrue(ss.size() == 1);
        assertEquals(ss.get(0).getClient(), client);
    }

    @Test
    public void findByDeviceId() throws Exception {
        Device device = devices.get(0);
        List<Sale> ss = simSaleDAO.findByDeviceId(device.getId());
        assertTrue(ss.size() == 1);
        assertTrue(ss.get(0).getDevices().keySet().contains(device));
    }

    @Test
    public void findBySaleDate() throws Exception {
        Sale sale = sales.get(0);
        List<Sale> ss = simSaleDAO.findBySaleDate(sale.getSaleDate());
        assertTrue(ss.contains(sale));
    }

}