package efimovta.store.entity;

import efimovta.store.Util;

import java.io.Serializable;
import java.util.*;

/**
 * Sale entity.
 */
public class Sale implements Identified, Serializable, CloneReady<Sale> {
    private static long nextId = 0;
    private final long id;

    private Date saleDate;
    private Client client;
    private Map<Device, Integer> devices;

    public Sale() {
        id = nextId++;
    }

    public Sale(Sale sale) {
        id = sale.getId();
        saleDate = sale.getSaleDate();
        client = new Client(sale.getClient());
        devices = Util.deepCopy(sale.getDevices());
    }

    @Override
    public long getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public Date getSaleDate() {
        return (Date) saleDate.clone();
    }

    /**
     * @return {@link Collections.UnmodifiableMap}
     */
    public Map<Device, Integer> getDevices() {
        return Collections.unmodifiableMap(devices);
    }

    public Sale setClient(Client client) {
        this.client = client;
        return this;
    }

    public Sale setSaleDate(Date saleDate) {
        this.saleDate = (Date) saleDate.clone();
        return this;
    }

    public Sale setDevices(Map<Device, Integer> devices) {
        this.devices = new HashMap<>(devices);
        return this;
    }

    /**
     * Compares this sale to the specified object.
     * The identifier is not taken into comparing.
     *
     * @param o The object to compare this Sale against
     * @return true if the given object represents a Sale equivalent
     * to this sale, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        boolean otv = false;
        if (this == o) {
            otv = true;
        } else if (o != null && getClass() == o.getClass()) {
            Sale sale = (Sale) o;
            /* yes, Map Correctly checks equals */
            if (getClient().equals(sale.getClient())
                    && getSaleDate().equals(sale.getSaleDate())
                    && getDevices().equals(sale.getDevices())) {
                otv = true;
            }
        }
        return otv;
    }

    /**
     * Returns a hash code for this client.
     * The identifier is not taken into calculation.
     *
     * @return a hash code for this client.
     */
    @Override
    public int hashCode() {
        int result = client.hashCode();
        result = 31 * result + saleDate.hashCode();
        result = 31 * result + devices.hashCode();
        return result;
    }

    /**
     * String looks like: {@code
     * Sale{id=3, saleDate=Sat Nov 13 00:00:00 MSK 1993, clientId=3,
     * devices(id:count)={(1:2),(2:5),(3:10),(0:1)}}
     * }
     * @return a string representation of the sale.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder()
                .append("Sale{")
                .append("id=").append(id)
                .append(", saleDate=").append(saleDate)
                .append(", clientId=").append(client.getId())
                .append(", devices(id:count)={");

        Set<Map.Entry<Device, Integer>> entries = devices.entrySet();
        int size = entries.size();
        int i = 0;
        for (Map.Entry<Device, Integer> entry : entries) {
            sb
                    .append('(')
                    .append(entry.getKey().getId())
                    .append(':')
                    .append(entry.getValue())
                    .append(')');
            if (++i != size) sb.append(',');
        }

        sb.append("}}");
        return sb.toString();
    }

    /**
     * Creates and returns a copy of this object.
     * Uses the copy constructor.
     *
     * @return copy of this object
     */
    @Override
    public Sale getClone() {
        return new Sale(this);
    }
}
