package efimovta.store.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Immutable Sale entity. Creation occurs through the builder.
 */
public class Sale implements Identified, Serializable {
    private static long nextId = 1;
    private final long id = nextId++;

    private Client client;
    private Date saleDate;
    private Map<Device, Integer> devices;

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

    public Map<Device, Integer> getDevices() {
        return devices;
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
        int result = getClient().hashCode();
        result = 31 * result + getSaleDate().hashCode();
        result = 31 * result + getDevices().hashCode();
        return result;
    }

    /**
     * todo example
     *
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
}
