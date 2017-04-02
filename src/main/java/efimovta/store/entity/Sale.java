package efimovta.store.entity;

import efimovta.store.NotAllFieldsAreFilledException;

import java.util.*;

/**
 * Immutable Sale entity. Creation occurs through the builder.
 */
public class Sale implements Identified, Cloneable {
    private static long nextId = 1;
    private final long id = nextId++;

    private Client client;
    private Date saleDate;
    private Map<Device, Integer> devices = new HashMap<>();

    private Sale() {

    }

    /**
     * @return a new builder instance
     * @see Client.Builder
     */
    public static Builder getBuilder() {
        return new Builder();
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

    public Map<Device, Integer> getDevices() {
        return Collections.unmodifiableMap(devices);
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

    /**
     * Class is used to instantiate sales.<br/> Contains a temporary instance
     * of the sale, which is filled with information through the setters.
     * <br/>Creation of new sale instances is performed by calling
     * a {@link Builder#build()} method.
     * <br/>One instance of the builder can be used multiple times,
     * the constructed instances are independent
     *
     * @see Sale#getBuilder()
     */
    public static class Builder {
        Sale tmp = new Sale();

        private Builder() {

        }

        /**
         * Verifies that all fields have been filled in and
         * creates a new instance of the sale.
         *
         * @return new sale instance
         * @throws NotAllFieldsAreFilledException
         */
        public Sale build() throws NotAllFieldsAreFilledException {
            checkFields();
            Sale newSale = tmp;
            tmp = new Sale();
            return newSale;
        }

        public Builder setClient(Client client) {
            tmp.client = client;
            return this;
        }

        public Builder setSaleDate(Date saleDate) {
            tmp.saleDate = (Date) saleDate.clone();
            return this;
        }

        public Builder setDevices(Map<Device, Integer> devices) {
            tmp.devices = new HashMap<>(devices);
            return this;
        }

        private void checkFields() throws NotAllFieldsAreFilledException {
            if (tmp.saleDate == null
                    || tmp.client == null
                    || tmp.devices == null) {
                throw new NotAllFieldsAreFilledException();
            }
        }
    }
}
