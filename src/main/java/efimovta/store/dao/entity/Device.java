package efimovta.store.dao.entity;

import efimovta.store.dao.entity.enums.Brand;
import efimovta.store.dao.entity.enums.DeviceType;
import efimovta.store.dao.entity.enums.NamedColor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by EFIMOVAT on 11.03.2017.
 */
public class Device implements Identified {
    private static int nextId = 1;
    private final int id = nextId++;

    String model;
    DeviceType type;
    Brand brand;

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

    NamedColor color;
    Date releaseDate;
    BigDecimal price;

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Device{" +
                "\n\tid=" + id +
                ",\n\tmodel='" + model + '\'' +
                ",\n\ttype=" + type +
                ",\n\tbrand=" + brand +
                ",\n\tcolor=" + color +
                ",\n\treleaseDate=" + releaseDate +
                ",\n\tprice=" + price +
                "\n}";
    }

    public String toStringWithOneTab() {//TODO delete view piece from model
        return "\tDevice{" +
                "\n\t\tid=" + id +
                ", \n\t\tmodel='" + model + '\'' +
                ", \n\t\ttype=" + type +
                ", \n\t\tbrand=" + brand +
                ", \n\t\tcolor=" + color +
                ", \n\t\treleaseDate=" + releaseDate +
                ", \n\t\tprice=" + price +
                "\n\t}";
    }

    private Device() {

    }

    public static int getNextId() {
        return nextId;
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
        return releaseDate;
    }

    public BigDecimal getPrice() {
        return price;
    }


    public static Builder getBuilder() {
        return new Device().new Builder();
    }


    public class Builder {
        private Builder() {

        }

        public Device build() {
            return Device.this;
        }

        public Builder setModel(String model) {
            Device.this.model = model;
            return this;
        }

        public Builder setType(DeviceType type) {
            Device.this.type = type;
            return this;
        }

        public Builder setBrand(Brand brand) {
            Device.this.brand = brand;
            return this;
        }

        public Builder setColor(NamedColor color) {
            Device.this.color = color;
            return this;
        }

        public Builder setReleaseDate(Date releaseDate) {
            Device.this.releaseDate = releaseDate;
            return this;
        }

        public Builder setPrice(BigDecimal price) {
            Device.this.price = price;
            return this;
        }
    }


}
