package efimovta.store.entity;

import efimovta.store.Util;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Sale entity.
 */
public class Sale implements Identified, Serializable, CloneReady<Sale> {
    private long id;
    private Date saleDate;
    private Client client;
    private Map<Device, Integer> devices;

    /**
     * default constructor
     */
    public Sale() {
        //default constructor
    }

    /**
     * Create copy of sale. All fields will be copied.
     *
     * @param sale to copy
     */
    public Sale(Sale sale) {
        id = sale.getId();
        saleDate = sale.getSaleDate();
        client = new Client(sale.getClient());
        devices = Util.deepCopy(sale.getDevices());
    }

    /**
     * @return sale id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id id for set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return Returns the client who made this purchase
     */
    public Client getClient() {
        return client;
    }

    /**
     * @param client client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * @return clone instance of sale date
     */
    public Date getSaleDate() {
        return (Date) saleDate.clone();
    }

    /**
     * @param saleDate sale date to set
     */
    public void setSaleDate(Date saleDate) {
        this.saleDate = (Date) saleDate.clone();
    }

    /**
     * @return {@link Collections.UnmodifiableMap} of purchased devices
     */
    public Map<Device, Integer> getDevices() {
        return Collections.unmodifiableMap(devices);
    }

    /**
     * Set copy {@link Map} of devices
     *
     * @param devices devices to set as purchased devices
     */
    public void setDevices(Map<Device, Integer> devices) {
        this.devices = new HashMap<>(devices);
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
            if (++i != size) {
                sb.append(',');
            }
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
