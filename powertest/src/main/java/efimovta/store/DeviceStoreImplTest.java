package efimovta.store;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * easy Power test
 */

public class DeviceStoreImplTest {
    public static final int NUMBER = 100;
    public static final String TYPE = "LAPTOP";
    public static final String BRAND = "HP";

    private static final Logger log = Logger.getLogger(DeviceStoreImplTest.class.getName());

    static IDeviceStore ids = DeviceStore.getDeviceStore();
    static StringRandomer sr = new StringRandomer();
    static List<String> ss = new ArrayList<>();
    static List<Date> dd = new ArrayList<>();

    public void setUp() {
        for (int i = 0; i < NUMBER; i++) {
            ss.add(sr.createRandomString());
            dd.add(new Date(127 + i * i * i * i));
        }
        addClient();
        addDevice();
        addSale();
        searchClientsByName();
        searchDevicesByIssueDate();
        sortClientsByName();
        sortDevicesByModel();
        sortSalesByDate();
    }


    public void addClient() {
        long a = System.currentTimeMillis();
        for (int i = 0; i < NUMBER; i++) {
            ids.addClient(ss.get(i), ss.get(NUMBER - 1 - i), ss.get(i), dd.get(i));
        }
        long b = System.currentTimeMillis();
        String msg = "addClient time: " + (b - a);
        log.info(msg);
    }


    public void addDevice() {
        long a = System.currentTimeMillis();
        for (int i = 0; i < NUMBER; i++) {
            ids.addDevice(TYPE, BRAND, ss.get(i), Color.BLACK, dd.get(i));
        }
        long b = System.currentTimeMillis();
        String msg = "addDevice time: " + (b - a);
        log.info(msg);
    }


    public void addSale() {
        long a = System.currentTimeMillis();
        Map<Integer, Integer> d = new HashMap<>();
        for (int i = 0; i < NUMBER; i++) {
            ids.addSale(dd.get(i), i, d);
        }
        long b = System.currentTimeMillis();
        String msg = "addSale time: " + (b - a);
        log.info(msg);
    }


    public void searchClientsByName() {
        long a = System.currentTimeMillis();
        for (int i = 0; i < NUMBER; i++) {
            ids.searchClientsByName(ss.get(i));
        }
        long b = System.currentTimeMillis();
        String msg = "searchClientsByName time: " + (b - a);
        log.info(msg);
    }


    public void searchDevicesByIssueDate() {
        long a = System.currentTimeMillis();
        for (int i = 0; i < NUMBER; i++) {
            ids.searchDevicesByIssueDate(dd.get(i));
        }
        long b = System.currentTimeMillis();
        String msg = "searchDevicesByIssueDate time: " + (b - a);
        log.info(msg);
    }


    public void sortClientsByName() {
        long a = System.currentTimeMillis();
        ids.sortClientsByName();
        long b = System.currentTimeMillis();
        String msg = "sortClientsByName time: " + (b - a);
        log.info(msg);
    }


    public void sortDevicesByModel() {
        long a = System.currentTimeMillis();
        ids.sortDevicesByModel();
        long b = System.currentTimeMillis();
        String msg = "sortDevicesByModel time: " + (b - a);
        log.info(msg);
    }


    public void sortSalesByDate() {
        long a = System.currentTimeMillis();
        ids.sortSalesByDate();
        long b = System.currentTimeMillis();
        String msg = "sortSalesByDate time: " + (b - a);
        log.info(msg);

    }

}