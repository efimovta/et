package efimovta.store.dao.entity;

import java.util.Date;
import java.util.Map;

/**
 * Created by EFIMOVAT on 11.03.2017.
 */
public class Sale implements Identified {
    @Override
    public boolean equals(Object o) {
        boolean otv = false;
        if (this == o) {
            otv = true;
        } else if (o != null && getClass() == o.getClass()) {
            Sale sale = (Sale) o;
            if (getClient().equals(sale.getClient())
                    && getSaleDate().equals(sale.getSaleDate())
                    && getDevices().equals(sale.getDevices())){
                otv = true;
            }
        }

        return otv;
    }

    @Override
    public int hashCode() {
        int result = getClient().hashCode();
        result = 31 * result + getSaleDate().hashCode();
        result = 31 * result + getDevices().hashCode();
        return result;
    }

    private static long nextId = 1;
    private final long id = nextId++;

    private Client client;
    private Date saleDate;
    private Map<Device, Integer> devices;

    private Sale() {
        
    }

    @Override
    public String toString() {//TODO delete view piece from model
        StringBuilder sb = new StringBuilder()
                .append("Sale{")
                .append("\nid=").append(id)
                .append(", \nclient=\n").append(client.toStringWithOneTab())
                .append(", \nsaleDate=").append(saleDate)
                .append(", \ndevices=");

        for (Map.Entry<Device, Integer> entry : devices.entrySet()) {
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

    public static Builder getBuilder() {
        return new Sale().new Builder();
    }


    public class Builder {
        private Builder() {

        }

        public Sale build(){
            return Sale.this;
        }
        
        public Builder setClient(Client client) {
            Sale.this.client = client;
            return this;
        }

        public Builder setSaleDate(Date saleDate) {
            Sale.this.saleDate = saleDate;
            return this;
        }

        public Builder setDevices(Map<Device, Integer> devices) {
            Sale.this.devices = devices;
            return this;
        }
    }
}
