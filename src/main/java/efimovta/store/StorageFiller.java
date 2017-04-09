package efimovta.store;

import efimovta.store.dao.*;
import efimovta.store.entity.*;

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
    @SuppressWarnings("all")
    public static void fillStorage() {
        ArrayList<Device> devices = new ArrayList<>();
        ArrayList<Client> clients = new ArrayList<>();
        ArrayList<Sale> sales = new ArrayList<>();

        try {
            devices.add(new Device().setModel("gbt-7").setType(DeviceType.LAPTOP).setBrand(Brand.HTC).setColor(NamedColor.BLACK).setReleaseDate(DateFormat.getDateInstance().parse("12.11.2995")).setPrice(new BigDecimal("100257")));
            devices.add(new Device().setModel("rjd-9").setType(DeviceType.PLAYER).setBrand(Brand.HP).setColor(NamedColor.BLACK).setReleaseDate(DateFormat.getDateInstance().parse("13.12.3995")).setPrice(new BigDecimal("37257")));
            devices.add(new Device().setModel("gtx-1").setType(DeviceType.PHONE).setBrand(Brand.SAMSUNG).setColor(NamedColor.BLACK).setReleaseDate(DateFormat.getDateInstance().parse("13.11.1995")).setPrice(new BigDecimal("10257")));
            devices.add(new Device().setModel("gtx-2").setType(DeviceType.PHONE).setBrand(Brand.SAMSUNG).setColor(NamedColor.BLACK).setReleaseDate(DateFormat.getDateInstance().parse("14.11.1995")).setPrice(new BigDecimal("10357")));
            devices.add(new Device().setModel("gtx-3").setType(DeviceType.PHONE).setBrand(Brand.SAMSUNG).setColor(NamedColor.BLACK).setReleaseDate(DateFormat.getDateInstance().parse("15.11.1995")).setPrice(new BigDecimal("10457")));
            devices.add(new Device().setModel("gtx-4").setType(DeviceType.PHONE).setBrand(Brand.SAMSUNG).setColor(NamedColor.BLACK).setReleaseDate(DateFormat.getDateInstance().parse("16.11.1995")).setPrice(new BigDecimal("10557")));
            devices.add(new Device().setModel("gtx-5").setType(DeviceType.PHONE).setBrand(Brand.SAMSUNG).setColor(NamedColor.BLACK).setReleaseDate(DateFormat.getDateInstance().parse("16.11.1995")).setPrice(new BigDecimal("10657")));

            clients.add(new Client().setSecondName("Васильев").setFirtsName("Вася").setMiddleName("Васильевич").setBirthday(DateFormat.getDateInstance().parse("11.11.1994")));
            clients.add(new Client().setSecondName("НеЕфимов").setFirtsName("НеТимур").setMiddleName("НеАндреевич").setBirthday(DateFormat.getDateInstance().parse("13.11.1995")));
            clients.add(new Client().setSecondName("Попов").setFirtsName("Александр").setMiddleName("Блександрович").setBirthday(DateFormat.getDateInstance().parse("13.11.1976")));
            clients.add(new Client().setSecondName("Попов").setFirtsName("Александр").setMiddleName("Влександрович").setBirthday(DateFormat.getDateInstance().parse("13.11.2016")));
            clients.add(new Client().setSecondName("Попов").setFirtsName("Александс").setMiddleName("Александрович").setBirthday(DateFormat.getDateInstance().parse("13.11.1996")));
            clients.add(new Client().setSecondName("Попов").setFirtsName("Александр").setMiddleName("Александрович").setBirthday(DateFormat.getDateInstance().parse("13.11.1995")));
            clients.add(new Client().setSecondName("Попов").setFirtsName("Александр").setMiddleName("Александрович").setBirthday(DateFormat.getDateInstance().parse("13.11.1994")));
            clients.add(new Client().setSecondName("Феоктистов").setFirtsName("Иван").setMiddleName("Олегович").setBirthday(DateFormat.getDateInstance().parse("13.11.1997")));
            clients.add(new Client().setSecondName("А").setFirtsName("Б").setMiddleName("В").setBirthday(DateFormat.getDateInstance().parse("13.11.1997")));

            Map<Device, Integer> ds = new HashMap<>();
            for (int i = 0; i < 6; i++) {
                ds.put(devices.get(i), i * i + 1);
                sales.add(new Sale().setClient(clients.get(i)).setSaleDate(DateFormat.getDateInstance().parse("13.11.199" + i)).setDevices(ds));
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
