package efimovta.store;

import efimovta.StringRandomer;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by EFIMOVAT on 16.04.2017.
 */

@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class DeviceStoreImplTest {
    static public final int NUMBER = 100;
    static public final String TYPE = "LAPTOP";
    static public final String BRAND = "HP";

    static IDeviceStore ids = DeviceStore.getDeviceStore();
    static StringRandomer sr = new StringRandomer();
    static List<String> ss = new ArrayList<>();
    static List<Date> dd = new ArrayList<>();

    @BeforeClass
    public static void setUp() throws Exception {
        for (int i = 0; i < NUMBER; i++) {
            ss.add(sr.createRandomString());
            dd.add(new Date(127 + i * i * i * i));
        }
    }

    @Test
    public void addClient() throws Exception {
        long a = System.currentTimeMillis();
        for (int i = 0; i < NUMBER; i++) {
            ids.addClient(ss.get(i), ss.get(NUMBER - 1 - i), ss.get(i), dd.get(i));
        }
        long b = System.currentTimeMillis();
        System.out.println("time: " + (b - a));
    }

    @Test
    public void addDevice() throws Exception {
        long a = System.currentTimeMillis();
        for (int i = 0; i < NUMBER; i++) {
            ids.addDevice(TYPE, BRAND, ss.get(i), Color.BLACK, dd.get(i));
        }
        long b = System.currentTimeMillis();
        System.out.println("time: " + (b - a));
    }

    @Test
    public void addSale() throws Exception {
        long a = System.currentTimeMillis();
        Map<Integer, Integer> d = new HashMap<>();
        for (int i = 0; i < NUMBER; i++) {
            ids.addSale(dd.get(i), i, d);
        }
        long b = System.currentTimeMillis();
        System.out.println("time: " + (b - a));
    }

    @Test
    public void searchClientsByName() throws Exception {
        long a = System.currentTimeMillis();
        for (int i = 0; i < NUMBER; i++) {
            ids.searchClientsByName(ss.get(i));
        }
        long b = System.currentTimeMillis();
        System.out.println("time: " + (b - a));
    }

    @Test
    public void searchDevicesByIssueDate() throws Exception {
        long a = System.currentTimeMillis();
        for (int i = 0; i < NUMBER; i++) {
            ids.searchDevicesByIssueDate(dd.get(i));
        }
        long b = System.currentTimeMillis();
        System.out.println("time: " + (b - a));
    }

    @Test
    public void sortClientsByName() throws Exception {
        long a = System.currentTimeMillis();
        ids.sortClientsByName();
        long b = System.currentTimeMillis();
        System.out.println("time: " + (b - a));
    }

    @Test
    public void sortDevicesByModel() throws Exception {
        long a = System.currentTimeMillis();
        ids.sortDevicesByModel();
        long b = System.currentTimeMillis();
        System.out.println("time: " + (b - a));
    }

    @Test
    public void sortSalesByDate() throws Exception {
        long a = System.currentTimeMillis();
        ids.sortSalesByDate();
        long b = System.currentTimeMillis();
        System.out.println("time: " + (b - a));

    }

}