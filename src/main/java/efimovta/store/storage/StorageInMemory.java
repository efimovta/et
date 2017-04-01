package efimovta.store.storage;

import efimovta.store.entity.Client;
import efimovta.store.entity.Device;
import efimovta.store.entity.Sale;

import java.util.ArrayList;

/**
 * Created by EFIMOVAT on 13.03.2017.
 */
public class StorageInMemory {
    public static ArrayList<Device> getDevices() {
        return devices;
    }

    public static ArrayList<Client> getClients() {
        return clients;
    }

    public static ArrayList<Sale> getSales() {
        return sales;
    }

    static final public ArrayList<Device> devices = new ArrayList<>();
    static final public ArrayList<Client> clients = new ArrayList<>();
    static final public ArrayList<Sale> sales = new ArrayList<>();

}
