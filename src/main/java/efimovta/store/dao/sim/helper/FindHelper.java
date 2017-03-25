package efimovta.store.dao.sim.helper;

import efimovta.store.dao.entity.Client;
import efimovta.store.dao.entity.Device;
import efimovta.store.dao.entity.Identified;
import efimovta.store.dao.entity.Sale;
import efimovta.store.dao.entity.enums.Brand;
import efimovta.store.dao.entity.enums.DeviceType;
import efimovta.store.dao.exeption.RecordNotFoundException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * Used to find the entity by parameter in the array
 */
public class FindHelper { //todo delete comparators

    public static final Comparator BY_ID = new Comparator() {
        @Override
        public int compare(Object identified, Object id) {
            return (int) (((Identified) identified).getId() - (long) id);
        }
    };

    public static final Comparator SALE_BY_CLIENT_ID = new Comparator() {
        @Override
        public int compare(Object sale, Object id) {
            return BY_ID.compare(((Sale) sale).getClient(), id);
        }
    };

    public static final Comparator SALE_BY_DEVICE_ID = new Comparator() {
        @Override
        public int compare(Object sale, Object id) {
            try {
                find(new ArrayList<Device>(((Sale) sale).getDevices().keySet()), id, BY_ID);
            } catch (RecordNotFoundException notFoundException) {
                return -1;
            }
            return 0;
        }
    };

    public static final Comparator SALE_BY_SALE_DATE = new Comparator() {
        @Override
        public int compare(Object sale, Object saleDate) {
            return ((Sale) sale).getSaleDate().compareTo((Date) saleDate);
        }
    };

    public static final Comparator DEVICE_BY_RELEASE_DATE = new Comparator() {
        @Override
        public int compare(Object device, Object releaseDate) {
            return ((Device) device).getReleaseDate().compareTo((Date) releaseDate);
        }
    };

    public static final Comparator DEVICE_BY_TYPE = new Comparator() {
        @Override
        public int compare(Object device, Object type) {
            return ((Device) device).getType().compareTo((DeviceType) type);
        }
    };

    public static final Comparator DEVICE_BY_BRAND = new Comparator() {
        @Override
        public int compare(Object device, Object brand) {
            return ((Device) device).getBrand().compareTo((Brand) brand);
        }
    };

    public static final Comparator CLIENT_BY_FIO = new Comparator() {
        @Override
        public int compare(Object client, Object fio) {
            return ((Client) client).getFIO().compareToIgnoreCase((String) fio);
        }
    };


    public static <T, E> List<T> find(ArrayList<T> list, E key, Comparator c)
            throws RecordNotFoundException {
        ArrayList<T> founded = new ArrayList<>();
        for (T t : list) {
            if (c.compare(t, key) == 0)
                founded.add(t);
        }

        if (founded.size() == 0) throw new RecordNotFoundException();

        return founded;
    }
}