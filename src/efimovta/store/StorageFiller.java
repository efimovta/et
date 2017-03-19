package efimovta.store;

import efimovta.store.dao.ClientDAO;
import efimovta.store.dao.factory.DAOFactory;
import efimovta.store.dao.DeviceDAO;
import efimovta.store.dao.SaleDAO;
import efimovta.store.dao.exeption.DAOException;
import efimovta.store.entity.Client;
import efimovta.store.entity.Device;
import efimovta.store.entity.Sale;
import efimovta.store.enums.Brand;
import efimovta.store.enums.DeviceType;
import efimovta.store.enums.NamedColor;

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
    /**
     * Fills STORAGE_IN_MEMORY(SIM) storage with some data
     */
    public static void fillStorage() {
        ArrayList<Device> devices = new ArrayList<>();
        ArrayList<Client> clients = new ArrayList<>();
        ArrayList<Sale> sales = new ArrayList<>();

        try {
            devices.add(new Device("gbt-7", DeviceType.LAPTOP, Brand.HTC, NamedColor.BLACK, DateFormat.getDateInstance().parse("12.11.2995"), new BigDecimal("100257")));
            devices.add(new Device("rjd-9", DeviceType.PLAYER, Brand.HP, NamedColor.BLACK, DateFormat.getDateInstance().parse("13.12.3995"), new BigDecimal("37257")));

            devices.add(new Device("gtx-1", DeviceType.PHONE, Brand.SAMSUNG, NamedColor.BLACK, DateFormat.getDateInstance().parse("13.11.1995"), new BigDecimal("10257")));
            devices.add(new Device("gtx-2", DeviceType.PHONE, Brand.SAMSUNG, NamedColor.BLACK, DateFormat.getDateInstance().parse("14.11.1995"), new BigDecimal("10357")));
            devices.add(new Device("gtx-3", DeviceType.PHONE, Brand.SAMSUNG, NamedColor.BLACK, DateFormat.getDateInstance().parse("15.11.1995"), new BigDecimal("10457")));
            devices.add(new Device("gtx-4", DeviceType.PHONE, Brand.SAMSUNG, NamedColor.BLACK, DateFormat.getDateInstance().parse("16.11.1995"), new BigDecimal("10557")));
            devices.add(new Device("gtx-5", DeviceType.PHONE, Brand.SAMSUNG, NamedColor.BLACK, DateFormat.getDateInstance().parse("16.11.1995"), new BigDecimal("10657")));

            clients.add(new Client("Васильев", "Вася", "Васильевич", DateFormat.getDateInstance().parse("11.11.1994")));
            clients.add(new Client("НеЕфимов", "НеТимур", "НеАндреевич", DateFormat.getDateInstance().parse("13.11.1995")));
            clients.add(new Client("Попов", "Александр", "Александрович", DateFormat.getDateInstance().parse("13.11.1976")));
            clients.add(new Client("Попов", "Александр", "Александрович", DateFormat.getDateInstance().parse("13.11.2016")));
            clients.add(new Client("Попов", "Александр", "Александрович", DateFormat.getDateInstance().parse("13.11.1996")));
            clients.add(new Client("Попов", "Александр", "Александрович", DateFormat.getDateInstance().parse("13.11.1995")));
            clients.add(new Client("Попов", "Александр", "Александрович", DateFormat.getDateInstance().parse("13.11.1994")));
            clients.add(new Client("Феоктистов", "Иван", "Олегович", DateFormat.getDateInstance().parse("13.11.1997")));
            clients.add(new Client("А", "Б", "В", DateFormat.getDateInstance().parse("13.11.1997")));

            Map<Device,Integer> ds = new HashMap<>();
            for (int i = 0; i < 6; i++) {
                ds.put(devices.get(i),i+1);
                sales.add(new Sale(clients.get(i),DateFormat.getDateInstance().parse("13.11.199"+i),ds));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }



        DAOFactory df = DAOFactory.getDAOFactory(DAOFactory.STORAGE_IN_MEMORY);

        ClientDAO clientDAO = df.getClientDAO();
        DeviceDAO deviceDAO = df.getDeviceDAO();
        SaleDAO saleDAO = df.getSaleDAO();

        try {
            for (Client c : clients) {
                clientDAO.record(c);
            }
            for (Device d : devices) {
                deviceDAO.record(d);
            }
            for (Sale s : sales) {
                saleDAO.record(s);
                System.out.println(s);
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
