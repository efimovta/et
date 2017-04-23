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
     * @return Changeable client list
     */
    static List<Client> getClients() {
        return clients;
    }

    /**
     * @return Changeable device list
     */
    static List<Device> getDevices() {
        return devices;
    }

    /**
     * @return Changeable sale list
     */
    static List<Sale> getSales() {
        return sales;
    }

    /**
     * Load data from file
     *
     * @param file with backup
     * @throws FileNotFoundException if file not found
     * @throws BackupException       if there was a deserialize
     *                               problem
     */
    public static void loadBackup(File file)
            throws FileNotFoundException, BackupException {
        Map<Class, List> newArr;
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(file))) {
            newArr = (HashMap<Class, List>) ois.readObject();

            clients.clear();
            devices.clear();
            sales.clear();

            clients.addAll(newArr.get(Client.class));
            devices.addAll(newArr.get(Device.class));
            sales.addAll(newArr.get(Sale.class));

            ((ArrayList) clients).trimToSize();
            ((ArrayList) devices).trimToSize();
            ((ArrayList) sales).trimToSize();
        } catch (ClassNotFoundException e) {
            Util.log.log(Level.SEVERE,
                    "Occurred while trying to read " +
                            "the HashMap<Class, List>) instance from file", e);
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            throw new BackupException("Deserialize problem", e);
        }
    }

    /**
     * Save data in file
     *
     * @param file for saving to
     * @throws FileNotFoundException if file not found
     * @throws BackupException       if There was a deserialize
     *                               problem
     */
    public static void saveBackup(File file) throws BackupException, FileNotFoundException {
        HashMap<Class, List> arr = new HashMap<>();
        arr.put(Client.class, clients);
        arr.put(Device.class, devices);
        arr.put(Sale.class, sales);

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(arr);
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            throw new BackupException("Serialize problem", e);
        }
    }

    private StorageInMemory() {
    }
}