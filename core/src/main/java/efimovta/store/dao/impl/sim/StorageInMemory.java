package efimovta.store.dao.impl.sim;

import efimovta.store.BackupException;
import efimovta.store.Util;
import efimovta.store.entity.Client;
import efimovta.store.entity.Device;
import efimovta.store.entity.Sale;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

/**
 * It contains lists representing the storage in memory
 */
public class StorageInMemory {

    static private List<Client> clients = new ArrayList<>();
    static private List<Device> devices = new ArrayList<>();
    static private List<Sale> sales = new ArrayList<>();

    /**
     * Use it for edit/add/remove records in storage
     *
     * @return Changeable client list
     */
    static List<Client> getClients() {
        return clients;
    }

    /**
     * Use it for edit/add/remove records in storage
     *
     * @return Changeable device list
     */
    static List<Device> getDevices() {
        return devices;
    }

    /**
     * Use it for edit/add/remove records in storage
     *
     * @return Changeable sale list
     */
    static List<Sale> getSales() {
        return sales;
    }

    /**
     * Load data from file
     *
     * @param file with backup
     * @throws BackupException       if There was a deserialize
     *                               problem of if file not found
     */
    public static void loadBackup(File file)
            throws BackupException {
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(file))) {
            Map<Class, List> newArr = (HashMap<Class, List>) ois.readObject();

            List<Client> clients = newArr.get(Client.class);
            List<Device> devices = newArr.get(Device.class);
            List<Sale> sales = newArr.get(Sale.class);

            StorageInMemory.clients.clear();
            StorageInMemory.devices.clear();
            StorageInMemory.sales.clear();

            StorageInMemory.clients.addAll(clients);
            StorageInMemory.devices.addAll(devices);
            StorageInMemory.sales.addAll(sales);

            ((ArrayList) clients).trimToSize();
            ((ArrayList) devices).trimToSize();
            ((ArrayList) sales).trimToSize();
        } catch (ClassNotFoundException e) {
            Util.log.log(Level.SEVERE,
                    "Occurred while trying to read " +
                            "the HashMap<Class, List>) instance from file", e);
        } catch (FileNotFoundException e) {
            throw new BackupException("File not found!", e);
        } catch (IOException e) {
            throw new BackupException("Deserialize problem", e);
        }
    }

    /**
     * Save data in file
     *
     * @param file for saving to
     * @throws BackupException       if There was a deserialize
     *                               problem of if file not found
     */
    public static void saveBackup(File file)
            throws BackupException {
        HashMap<Class, List> arr = new HashMap<>();
        arr.put(Client.class, clients);
        arr.put(Device.class, devices);
        arr.put(Sale.class, sales);

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(arr);
        } catch (FileNotFoundException e) {
            throw new BackupException("File not found!", e);
        } catch (IOException e) {
            throw new BackupException("Serialize problem", e);
        }
    }

    private StorageInMemory() {
    }
}