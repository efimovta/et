package efimovta.store.dao.entity;

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
        StringBuilder sb = new StringBuilder()
                .append("Sale{")
                .append("\nid=").append(id)
                .append(", \nclient=\n").append(client.toStringWithOneTab())
                .append(", \nsaleDate=").append(saleDate)
                .append(", \ndevices=");

        for(Map.Entry<Device, Integer> entry: devices.entrySet()){
            sb.append('\n').append(entry.getKey().toStringWithOneTab()).append("---Number of this devices: ").append(entry.getValue());
        }

        sb.append("\n}");
        return sb.toString();
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
