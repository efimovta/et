package efimovta.store.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by EFIMOVAT on 11.03.2017.
 */
public class Device implements Identified, Cloneable {
    private static int nextId = 1;
    private final int id = nextId++;

    private String model;
    private DeviceType type;
    private Brand brand;

    private NamedColor color;
    private Date releaseDate;
    private BigDecimal price;

    public long getId() {
        return id;
    }


    private Device() {

    }

    @Override
    protected Device clone() {
        Device d = null;
        try {
            d = (Device) super.clone();
        } catch (CloneNotSupportedException e) {
        } // Won't happen
        return d;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public String getModel() {
        return model;
    }

    public DeviceType getType() {
        return type;
    }

    public Brand getBrand() {
        return brand;
    }

    public NamedColor getColor() {
        return color;
    }

    public Date getReleaseDate() {
        return (Date) releaseDate.clone();
    }

    public BigDecimal getPrice() {
        return price;
    }


    @Override
    public boolean equals(Object o) {
        boolean otv = false;

        if (this == o) {
            otv = true;
        } else if (o != null && getClass() == o.getClass()) {
            Device device = (Device) o;
            if (getModel().equals(device.getModel())
                    && getType() == device.getType()
                    && getBrand() == device.getBrand()
                    && getColor() == device.getColor()
                    && getReleaseDate().equals(device.getReleaseDate())) {
                otv = true;
            }
        }

        return otv;
    }

    @Override
    public int hashCode() {
        int result = getType().hashCode();
        result = 31 * result + getBrand().hashCode();
        result = 31 * result + getColor().hashCode();
        result = 31 * result + getReleaseDate().hashCode();
        result = 31 * result + getPrice().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", type=" + type +
                ", brand=" + brand +
                ", color=" + color +
                ", releaseDate=" + releaseDate +
                ", price=" + price +
                '}';
    }

    public static class Builder {
        Device tmp = new Device();

        private Builder() {

        }

        public Device build() {
            return tmp.clone();
        }

        public Builder setModel(String model) {
            tmp.model = model;
            return this;
        }

        public Builder setType(DeviceType type) {
            tmp.type = type;
            return this;
        }

        public Builder setBrand(Brand brand) {
            tmp.brand = brand;
            return this;
        }

        public Builder setColor(NamedColor color) {
            tmp.color = color;
            return this;
        }

        public Builder setReleaseDate(Date releaseDate) {
            tmp.releaseDate = releaseDate;
            return this;
        }

        public Builder setPrice(BigDecimal price) {
            tmp.price = price;
            return this;
        }
    }


}
