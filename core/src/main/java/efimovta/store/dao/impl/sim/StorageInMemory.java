package efimovta.store.dao.impl.sim;

import efimovta.store.Util;
import efimovta.store.entity.Client;
import efimovta.store.entity.Device;
import efimovta.store.entity.Sale;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * It contains lists representing the storage in memory
 */
public class StorageInMemory {
    static List<Client> clientRecords = new ArrayList<>();
    static List<Device> deviceRecords = new ArrayList<>();
    static List<Sale> saleRecords = new ArrayList<>();

    public static void saveBackup(File file) throws IOException {
        List<List> arr = new ArrayList<>();
        arr.add(clientRecords);
        arr.add(deviceRecords);
        arr.add(saleRecords);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(arr);
        }
    }

    public static void loadBackup(File file) throws IOException {
        List<List> newArr;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            newArr = (List<List>) ois.readObject();

            clientRecords = newArr.get(0);
            deviceRecords = newArr.get(1);
            saleRecords = newArr.get(2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();//how reach?
            Util.log.log(Level.SEVERE, "how you reach this!?", e);
        }
    }
}