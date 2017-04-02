package efimovta.store;

import efimovta.store.dao.RecordNotFoundException;
import efimovta.store.entity.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Used to find the entity by parameter in the array
 */
public class FindHelper {

    public static final FieldChecker<Sale, Long> SALE_BY_ID =
            new FieldChecker<Sale, Long>() {
                @Override
                public boolean check(Sale sale, Long id) {
                    return IDENTIFIED_BY_ID.check(sale, id);
                }
            };

    public static final FieldChecker<Device, Long> DEVICE_BY_ID =
            new FieldChecker<Device, Long>() {
                @Override
                public boolean check(Device device, Long id) {
                    return IDENTIFIED_BY_ID.check(device, id);
                }
            };

    public static final FieldChecker<Client, Long> CLIENT_BY_ID =
            new FieldChecker<Client, Long>() {
                @Override
                public boolean check(Client client, Long id) {
                    return IDENTIFIED_BY_ID.check(client, id);
                }
            };

    public static final FieldChecker<Identified, Long> IDENTIFIED_BY_ID =
            new FieldChecker<Identified, Long>() {
                @Override
                public boolean check(Identified identified, Long id) {
                    return identified.getId() - id == 0;
                }
            };


    public static final FieldChecker<Sale, Long> SALE_BY_CLIENT_ID =
            new FieldChecker<Sale, Long>() {
                @Override
                public boolean check(Sale sale, Long clientId) {
                    return IDENTIFIED_BY_ID.check(sale.getClient(), clientId);
                }
            };

    public static final FieldChecker<Sale, Long> SALE_BY_DEVICE_ID =
            new FieldChecker<Sale, Long>() {
                @Override
                public boolean check(Sale sale, Long deviceId) {
                    boolean otv;
                    try {
                        find(new ArrayList<Identified>((sale).getDevices().keySet()), deviceId, IDENTIFIED_BY_ID);
                        otv = true;
                    } catch (RecordNotFoundException notFoundException) {
                        otv = false;
                    }
                    return otv;
                }
            };

    public static final FieldChecker<Sale, Date> SALE_BY_SALE_DATE =
            new FieldChecker<Sale, Date>() {
                @Override
                public boolean check(Sale sale, Date saleDate) {
                    return sale.getSaleDate().equals(saleDate);
                }
            };

    public static final FieldChecker<Device, Date> DEVICE_BY_RELEASE_DATE =
            new FieldChecker<Device, Date>() {
                @Override
                public boolean check(Device device, Date releaseDate) {
                    return device.getReleaseDate().equals(releaseDate);
                }
            };

    public static final FieldChecker<Device, DeviceType> DEVICE_BY_TYPE =
            new FieldChecker<Device, DeviceType>() {
                @Override
                public boolean check(Device device, DeviceType type) {
                    return device.getType().equals(type);
                }
            };

    public static final FieldChecker<Device, Brand> DEVICE_BY_BRAND =
            new FieldChecker<Device, Brand>() {
                @Override
                public boolean check(Device device, Brand brand) {
                    return device.getBrand().equals(brand);
                }
            };

    public static final FieldChecker<Client, String> CLIENT_BY_FIO =
            new FieldChecker<Client, String>() {
                @Override
                public boolean check(Client client, String fio) {
                    return (client.getFIO().compareToIgnoreCase(fio) == 0);
                }
            };


    /**
     * Finds objects with a field that has the required value
     *
     * @param <T>          object type
     * @param <P>          field type
     * @param list         List of objects where you want to search
     * @param value        value of corresponding field
     * @param fieldChecker Checks the field of the object to match the value
     * @return list of objects with the corresponding parameter
     * @throws RecordNotFoundException If no objects are found with the corresponding parameter
     */
    public static <T, P> List<T> find(ArrayList<T> list, P value, FieldChecker<T, P> fieldChecker)
            throws RecordNotFoundException {
        ArrayList<T> founded = new ArrayList<>();
        for (T t : list) {
            if (fieldChecker.check(t, value))
                founded.add(t);
        }

        if (founded.size() == 0) throw new RecordNotFoundException();

        return founded;
    }

    /**
     * Contains a single method that checks the field of the object to match the value
     *
     * @param <T> object type
     * @param <P> field type
     */
    abstract static class FieldChecker<T, P> {
        /**
         * Checks the field of the object to match the value
         *
         * @param object Inspected object
         * @param value  Verified value
         * @return true if the field contains the required value
         */
        public abstract boolean check(T object, P value);
    }
}