package efimovta.store;

import efimovta.store.entity.Brand;
import efimovta.store.entity.Client;
import efimovta.store.entity.Device;
import efimovta.store.entity.DeviceType;
import efimovta.store.entity.Identified;
import efimovta.store.entity.Sale;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Used to find the entity by parameter in the array
 */
public class FindHelper {

    public static final ByFieldComparator<Identified, Long> IDENTIFIED_BY_ID =
            new ByFieldComparator<Identified, Long>() {
                @Override
                public boolean check(Identified identified, Long id) {
                    return identified.getId() - id == 0;
                }
            };
    public static final ByFieldComparator<Sale, Long> SALE_BY_ID =
            new ByFieldComparator<Sale, Long>() {
                @Override
                public boolean check(Sale sale, Long id) {
                    return IDENTIFIED_BY_ID.check(sale, id);
                }
            };
    public static final ByFieldComparator<Device, Long> DEVICE_BY_ID =
            new ByFieldComparator<Device, Long>() {
                @Override
                public boolean check(Device device, Long id) {
                    return IDENTIFIED_BY_ID.check(device, id);
                }
            };
    public static final ByFieldComparator<Client, Long> CLIENT_BY_ID =
            new ByFieldComparator<Client, Long>() {
                @Override
                public boolean check(Client client, Long id) {
                    return IDENTIFIED_BY_ID.check(client, id);
                }
            };
    public static final ByFieldComparator<Sale, Long> SALE_BY_CLIENT_ID =
            new ByFieldComparator<Sale, Long>() {
                @Override
                public boolean check(Sale sale, Long clientId) {
                    return IDENTIFIED_BY_ID.check(sale.getClient(), clientId);
                }
            };

    public static final ByFieldComparator<Sale, Long> SALE_BY_DEVICE_ID =
            new ByFieldComparator<Sale, Long>() {
                @Override
                public boolean check(Sale sale, Long deviceId) {
                    List<Identified> i;
                    Set<Device> set = (sale).getDevices().keySet();
                    List<Identified> devices = new ArrayList<>();
                    devices.addAll(set);
                    i = find(devices, deviceId, IDENTIFIED_BY_ID);
                    return !i.isEmpty();
                }
            };

    public static final ByFieldComparator<Sale, Date> SALE_BY_SALE_DATE =
            new ByFieldComparator<Sale, Date>() {
                @Override
                public boolean check(Sale sale, Date saleDate) {
                    return sale.getSaleDate().equals(saleDate);
                }
            };

    public static final ByFieldComparator<Device, Date> DEVICE_BY_RELEASE_DATE =
            new ByFieldComparator<Device, Date>() {
                @Override
                public boolean check(Device device, Date releaseDate) {
                    return device.getReleaseDate().equals(releaseDate);
                }
            };

    public static final ByFieldComparator<Device, DeviceType> DEVICE_BY_TYPE =
            new ByFieldComparator<Device, DeviceType>() {
                @Override
                public boolean check(Device device, DeviceType type) {
                    return device.getType().equals(type);
                }
            };

    public static final ByFieldComparator<Device, Brand> DEVICE_BY_BRAND =
            new ByFieldComparator<Device, Brand>() {
                @Override
                public boolean check(Device device, Brand brand) {
                    return device.getBrand().equals(brand);
                }
            };

    public static final ByFieldComparator<Client, String> CLIENT_BY_FIO =
            new ByFieldComparator<Client, String>() {
                @Override
                public boolean check(Client client, String fio) {
                    return client.getFIO().compareToIgnoreCase(fio) == 0;
                }
            };

    public static final ByFieldComparator<Client, String> CLIENT_BY_MIDDLE_NAME =
            new ByFieldComparator<Client, String>() {
                @Override
                public boolean check(Client client, String middleName) {
                    return client.getMiddleName().compareToIgnoreCase(middleName) == 0;
                }
            };
    public static final ByFieldComparator<Client, String> CLIENT_BY_FIRST_NAME =
            new ByFieldComparator<Client, String>() {
                @Override
                public boolean check(Client client, String first) {
                    return client.getFirstName().compareToIgnoreCase(first) == 0;
                }
            };
    public static final ByFieldComparator<Client, String> CLIENT_BY_SECOND_NAME =
            new ByFieldComparator<Client, String>() {
                @Override
                public boolean check(Client client, String second) {
                    return client.getSecondName().compareToIgnoreCase(second) == 0;
                }
            };

    public static final ByFieldComparator<Client, String> CLIENT_BY_ANY_NAME =
            new ByFieldComparator<Client, String>() {
                @Override
                public boolean check(Client client, String any) {
                    return (client.getSecondName().compareToIgnoreCase(any) == 0)
                            || (client.getFirstName().compareToIgnoreCase(any) == 0)
                            || (client.getMiddleName().compareToIgnoreCase(any) == 0);
                }
            };


    private FindHelper() {
    }

    /**
     * Finds objects with a field that has the required value
     *
     * @param <T>               object type
     * @param <P>               field type
     * @param list              List of objects where you want to
     *                          search
     * @param value             value of corresponding field
     * @param byFieldComparator Checks the field of the object to
     *                          match the value
     * @return list of objects with the corresponding parameter
     */
    public static <T, P> List<T> find(
            List<T> list, P value, ByFieldComparator<T, P> byFieldComparator) {
        ArrayList<T> founded = new ArrayList<>();
        for (T t : list) {
            if (byFieldComparator.check(t, value))
                founded.add(t);
        }
        return founded;
    }

    /**
     * Contains a single method that checks the field of the object
     * to match the value
     *
     * @param <T> object type
     * @param <P> field type
     */
    abstract static class ByFieldComparator<T, P> {
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