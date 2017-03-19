package efimovta.store.entity;

import java.util.Date;
import java.util.Map;

/**
 * Created by EFIMOVAT on 11.03.2017.
 */
public class Sale implements Identified {
    private static long nextId = 1;
    private final long id = nextId++;

    private Client client;
    private Date saleDate;
    private Map<Device, Integer> devices;

    public Sale(Client client, Date saleDate, Map<Device, Integer> devices) {
        this.client = client;
        this.saleDate = saleDate;
        this.devices = devices;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "\n\tid=" + id +
                ", \n\tclient=\n\t\t" + client +
                ", \n\tsaleDate=\n\t\t" + saleDate +
                ", \n\tdevices=\n\t\t" + devices +
                '}';
    }

    public Client getClient() {
        return client;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public Map<Device, Integer> getDevices() {
        return devices;
    }

    @Override
    public long getId() {
        return id;
    }
}
