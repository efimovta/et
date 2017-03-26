package efimovta.store.dao.impl.sim.helper;

import efimovta.store.dao.entity.Client;
import efimovta.store.dao.entity.Device;
import efimovta.store.dao.entity.Identified;
import efimovta.store.dao.entity.Sale;
import efimovta.store.dao.entity.enums.Brand;
import efimovta.store.dao.entity.enums.DeviceType;
import efimovta.store.dao.exeption.RecordNotFoundException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Used to find the entity by parameter in the array
 */
public class FindHelper { //todo delete comparators

    public static final ParameterChecker<Identified, Long> BY_ID =
            new ParameterChecker<Identified, Long>() {
                @Override
                public boolean check(Identified identified, Long id) {
                    return identified.getId() - id == 0;
                }
            };

    public static final ParameterChecker<Sale, Long> SALE_BY_CLIENT_ID =
            new ParameterChecker<Sale, Long>() {
                @Override
                public boolean check(Sale entity, Long param) {
                    return false;
                }

                @Override
        public int compare(Object sale, Object clientId) {
            return BY_ID.compare(((Sale) sale).getClient(), clientId);
        }
    };

    public static final ParameterChecker<Sale, Long> SALE_BY_DEVICE_ID =
            new ParameterChecker<Sale, Long>() {
                @Override
                public boolean check(Sale sale, Long deviceId) {
                    boolean otv;
                    try {
                        find(new ArrayList<>((sale).getDevices().keySet()), deviceId, BY_ID);
                        otv = true;
                    } catch (RecordNotFoundException notFoundException) {
                        otv = false;
                    }
                    return otv;
                }
            };

    public static final ParameterChecker<Sale, Date> SALE_BY_SALE_DATE =
            new ParameterChecker<Sale, Date>() {
                @Override
                public boolean check(Sale sale, Date saleDate) {
                    return sale.getSaleDate().equals(saleDate);
                }
            };

    public static final ParameterChecker<Device, Date> DEVICE_BY_RELEASE_DATE =
            new ParameterChecker<Device, Date>() {
                @Override
                public boolean check(Device device, Date releaseDate) {
                    return device.getReleaseDate().equals(releaseDate);
                }
            };

    public static final ParameterChecker<Device, DeviceType> DEVICE_BY_TYPE =
            new ParameterChecker<Device, DeviceType>() {
                @Override
                public boolean check(Device device, DeviceType type) {
                    return device.getType().equals(type);
                }
            };

    public static final ParameterChecker<Device, Brand> DEVICE_BY_BRAND =
            new ParameterChecker<Device, Brand>() {
                @Override
                public boolean check(Device device, Brand brand) {
                    return device.getBrand().equals(brand);
                }
            };

    public static final ParameterChecker<Client, String> CLIENT_BY_FIO =
            new ParameterChecker<Client, String>() {
                @Override
                public boolean check(Client client, String fio) {
                    return (client.getFIO().compareToIgnoreCase(fio) == 0);
                }
            };


    public static <T, P, C super T> List<T> find(ArrayList<T> list, P key, ParameterChecker<C, P> c)
            throws RecordNotFoundException {
        ArrayList<T> founded = new ArrayList<>();
        for (T t : list) {
            if (c.check(t, key))
                founded.add(t);
        }

        if (founded.size() == 0) throw new RecordNotFoundException();

        return founded;
    }

    abstract static class ParameterChecker<T, P> {
        public abstract boolean check(T entity, P param);
    }
}