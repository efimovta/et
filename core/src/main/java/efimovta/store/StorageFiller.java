package efimovta.store;

import efimovta.store.dao.ClientDAO;
import efimovta.store.dao.DAOException;
import efimovta.store.dao.DAOFactory;
import efimovta.store.dao.DeviceDAO;
import efimovta.store.dao.SaleDAO;
import efimovta.store.entity.Brand;
import efimovta.store.entity.Client;
import efimovta.store.entity.Device;
import efimovta.store.entity.DeviceType;
import efimovta.store.entity.NamedColor;
import efimovta.store.entity.Sale;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * The class contains only one method that fills STORAGE_IN_MEMORY(SIM) storage with some data
 */
public class StorageFiller {
    private StorageFiller() {
    }

    /**
     * Fills STORAGE_IN_MEMORY(SIM) storage with some data
     */
    @SuppressWarnings("all")
    public static void fillStorage() {
        ArrayList<Device> devices = new ArrayList<>();
        ArrayList<Client> clients = new ArrayList<>();
        ArrayList<Sale> sales = new ArrayList<>();

        try {
            Device device;
            device = new Device();
            device.setModel("gbt-7");
            device.setType(DeviceType.LAPTOP);
            device.setBrand(Brand.HTC);
            device.setColor(NamedColor.BLACK);
            device.setReleaseDate(DateFormat.getDateInstance().parse("12.11.2995"));
            device.setPrice(new BigDecimal("100257"));
            devices.add(device);
            device = new Device();
            device.setModel("rjd-9");
            device.setType(DeviceType.PLAYER);
            device.setBrand(Brand.HP);
            device.setColor(NamedColor.BLACK);
            device.setReleaseDate(DateFormat.getDateInstance().parse("13.12.3995"));
            device.setPrice(new BigDecimal("37257"));
            devices.add(device);
            device = new Device();
            device.setModel("gtx-1");
            device.setType(DeviceType.PHONE);
            device.setBrand(Brand.SAMSUNG);
            device.setColor(NamedColor.BLACK);
            device.setReleaseDate(DateFormat.getDateInstance().parse("13.11.1995"));
            device.setPrice(new BigDecimal("10257"));
            devices.add(device);
            device = new Device();
            device.setModel("gtx-2");
            device.setType(DeviceType.PHONE);
            device.setBrand(Brand.SAMSUNG);
            device.setColor(NamedColor.BLACK);
            device.setReleaseDate(DateFormat.getDateInstance().parse("14.11.1995"));
            device.setPrice(new BigDecimal("10357"));
            devices.add(device);
            device = new Device();
            device.setModel("gtx-3");
            device.setType(DeviceType.PHONE);
            device.setBrand(Brand.SAMSUNG);
            device.setColor(NamedColor.BLACK);
            device.setReleaseDate(DateFormat.getDateInstance().parse("15.11.1995"));
            device.setPrice(new BigDecimal("10457"));
            devices.add(device);
            device = new Device();
            device.setModel("gtx-4");
            device.setType(DeviceType.PHONE);
            device.setBrand(Brand.SAMSUNG);
            device.setColor(NamedColor.BLACK);
            device.setReleaseDate(DateFormat.getDateInstance().parse("16.11.1995"));
            device.setPrice(new BigDecimal("10557"));
            devices.add(device);
            device = new Device();
            device.setModel("gtx-5");
            device.setType(DeviceType.PHONE);
            device.setBrand(Brand.SAMSUNG);
            device.setColor(NamedColor.BLACK);
            device.setReleaseDate(DateFormat.getDateInstance().parse("16.11.1995"));
            device.setPrice(new BigDecimal("10657"));
            devices.add(device);

            Client client;
            client = new Client();
            client.setSecondName("Васильев");
            client.setFirstName("Вася");
            client.setMiddleName("Васильевич");
            client.setBirthday(DateFormat.getDateInstance().parse("11.11.1994"));
            clients.add(client);
            client = new Client();
            client.setSecondName("НеЕфимов");
            client.setFirstName("НеТимур");
            client.setMiddleName("НеАндреевич");
            client.setBirthday(DateFormat.getDateInstance().parse("13.11.1995"));
            clients.add(client);
            client = new Client();
            client.setSecondName("Попов");
            client.setFirstName("Александр");
            client.setMiddleName("Блександрович");
            client.setBirthday(DateFormat.getDateInstance().parse("13.11.1976"));
            clients.add(client);
            client = new Client();
            client.setSecondName("Попов");
            client.setFirstName("Александр");
            client.setMiddleName("Влександрович");
            client.setBirthday(DateFormat.getDateInstance().parse("13.11.2016"));
            clients.add(client);
            client = new Client();
            client.setSecondName("Попов");
            client.setFirstName("Александс");
            client.setMiddleName("Александрович");
            client.setBirthday(DateFormat.getDateInstance().parse("13.11.1996"));
            clients.add(client);
            client = new Client();
            client.setSecondName("Попов");
            client.setFirstName("Александр");
            client.setMiddleName("Александрович");
            client.setBirthday(DateFormat.getDateInstance().parse("13.11.1995"));
            clients.add(client);
            client = new Client();
            client.setSecondName("Попов");
            client.setFirstName("Александр");
            client.setMiddleName("Александрович");
            client.setBirthday(DateFormat.getDateInstance().parse("13.11.1994"));
            clients.add(client);
            client = new Client();
            client.setSecondName("Феоктистов");
            client.setFirstName("Иван");
            client.setMiddleName("Олегович");
            client.setBirthday(DateFormat.getDateInstance().parse("13.11.1997"));
            clients.add(client);
            client = new Client();
            client.setSecondName("А");
            client.setFirstName("Б");
            client.setMiddleName("В");
            client.setBirthday(DateFormat.getDateInstance().parse("13.11.1997"));
            clients.add(client);

            Map<Device, Integer> ds = new HashMap<>();
            Sale sale;
            for (int i = 0; i < 6; i++) {
                ds.put(devices.get(i), i * i + 1);
                sale = new Sale();
                sale.setClient(clients.get(i));
                sale.setSaleDate(DateFormat.getDateInstance().parse("13.11.1995" + i));
                sale.setDevices(ds);
                sales.add(sale);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        DAOFactory df = DAOFactory.get();

        ClientDAO clientDAO = df.getClientDAO();
        DeviceDAO deviceDAO = df.getDeviceDAO();
        SaleDAO saleDAO = df.getSaleDAO();

        try {
            for (Client c : clients) {
                clientDAO.add(c);
            }
            for (Device d : devices) {
                deviceDAO.add(d);
            }
            for (Sale s : sales) {
                saleDAO.add(s);
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
