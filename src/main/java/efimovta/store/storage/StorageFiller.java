package efimovta.store.storage;

import efimovta.store.NotAllFieldsAreFilledException;
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
            devices.add(Device.getBuilder().setModel("gbt-7").setType(DeviceType.LAPTOP).setBrand(Brand.HTC).setColor( NamedColor.BLACK).setReleaseDate( DateFormat.getDateInstance().parse("12.11.2995")).setPrice( new BigDecimal("100257")).build());
            devices.add(Device.getBuilder().setModel("rjd-9").setType( DeviceType.PLAYER).setBrand( Brand.HP).setColor( NamedColor.BLACK).setReleaseDate( DateFormat.getDateInstance().parse("13.12.3995")).setPrice( new BigDecimal("37257")).build());
            devices.add(Device.getBuilder().setModel("gtx-1").setType( DeviceType.PHONE).setBrand( Brand.SAMSUNG).setColor( NamedColor.BLACK).setReleaseDate( DateFormat.getDateInstance().parse("13.11.1995")).setPrice( new BigDecimal("10257")).build());
            devices.add(Device.getBuilder().setModel("gtx-2").setType( DeviceType.PHONE).setBrand( Brand.SAMSUNG).setColor( NamedColor.BLACK).setReleaseDate( DateFormat.getDateInstance().parse("14.11.1995")).setPrice( new BigDecimal("10357")).build());
            devices.add(Device.getBuilder().setModel("gtx-3").setType( DeviceType.PHONE).setBrand( Brand.SAMSUNG).setColor( NamedColor.BLACK).setReleaseDate( DateFormat.getDateInstance().parse("15.11.1995")).setPrice( new BigDecimal("10457")).build());
            devices.add(Device.getBuilder().setModel("gtx-4").setType( DeviceType.PHONE).setBrand( Brand.SAMSUNG).setColor( NamedColor.BLACK).setReleaseDate( DateFormat.getDateInstance().parse("16.11.1995")).setPrice( new BigDecimal("10557")).build());
            devices.add(Device.getBuilder().setModel("gtx-5").setType( DeviceType.PHONE).setBrand( Brand.SAMSUNG).setColor( NamedColor.BLACK).setReleaseDate( DateFormat.getDateInstance().parse("16.11.1995")).setPrice( new BigDecimal("10657")).build());

            clients.add(Client.getBuilder().setSecondName("Васильев").setName("Вася").setMiddleName("Васильевич").setBirthDay(DateFormat.getDateInstance().parse("11.11.1994")).build());
            clients.add(Client.getBuilder().setSecondName("НеЕфимов").setName( "НеТимур").setMiddleName( "НеАндреевич").setBirthDay( DateFormat.getDateInstance().parse("13.11.1995")).build());
            clients.add(Client.getBuilder().setSecondName("Попов").setName( "Александр").setMiddleName( "Александрович").setBirthDay( DateFormat.getDateInstance().parse("13.11.1976")).build());
            clients.add(Client.getBuilder().setSecondName("Попов").setName( "Александр").setMiddleName( "Александрович").setBirthDay( DateFormat.getDateInstance().parse("13.11.2016")).build());
            clients.add(Client.getBuilder().setSecondName("Попов").setName( "Александр").setMiddleName( "Александрович").setBirthDay( DateFormat.getDateInstance().parse("13.11.1996")).build());
            clients.add(Client.getBuilder().setSecondName("Попов").setName( "Александр").setMiddleName( "Александрович").setBirthDay( DateFormat.getDateInstance().parse("13.11.1995")).build());
            clients.add(Client.getBuilder().setSecondName("Попов").setName( "Александр").setMiddleName( "Александрович").setBirthDay( DateFormat.getDateInstance().parse("13.11.1994")).build());
            clients.add(Client.getBuilder().setSecondName("Феоктистов").setName( "Иван").setMiddleName( "Олегович").setBirthDay( DateFormat.getDateInstance().parse("13.11.1997")).build());
            clients.add(Client.getBuilder().setSecondName("А").setName( "Б").setMiddleName( "В").setBirthDay( DateFormat.getDateInstance().parse("13.11.1997")).build());

            Map<Device,Integer> ds = new HashMap<>();
            for (int i = 0; i < 6; i++) {
                ds.put(devices.get(i),i*i+1);
                sales.add(Sale.getBuilder().setClient(clients.get(i)).setSaleDate(DateFormat.getDateInstance().parse("13.11.199"+i)).setDevices(ds).build());
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }catch (NotAllFieldsAreFilledException e) {
            e.printStackTrace();
        }

        DAOFactory df = DAOFactory.get();

        ClientDAO clientDAO = df.getClientDAO();
        DeviceDAO deviceDAO = df.getDeviceDAO();
        SaleDAO saleDAO = df.getSaleDAO();

        try {
            for (Client c : clients) {
                clientDAO.add(c);
                System.out.println(c);
            }
            for (Device d : devices) {
                deviceDAO.add(d);
                System.out.println(d);
            }
            for (Sale s : sales) {
                saleDAO.add(s);
                System.out.println(s);
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
