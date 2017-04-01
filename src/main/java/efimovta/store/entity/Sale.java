package efimovta.store.entity;

import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * Created by EFIMOVAT on 11.03.2017.
 */
public class Sale implements Identified, Cloneable  {
    private static long nextId = 1;
    private final long id = nextId++;

    private Client client;
    private Date saleDate;
    private Map<Device, Integer> devices;

    private Sale() {

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
        return new Builder();
    }


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

    @Override
    public int hashCode() {
        int result = getClient().hashCode();
        result = 31 * result + getSaleDate().hashCode();
        result = 31 * result + getDevices().hashCode();
        return result;
    }

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


    public static class Builder {
        Sale tmp = new Sale();
        
        private Builder() {

        }

        public Sale build() {
            try {
                return (Sale) tmp.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return null;//Unreachable
        }

        public Builder setClient(Client client) {
            tmp.client = client;
            return this;
        }

        public Builder setSaleDate(Date saleDate) {
            tmp.saleDate = saleDate;
            return this;
        }

        public Builder setDevices(Map<Device, Integer> devices) {
            tmp.devices = devices;
            return this;
        }
    }
}
