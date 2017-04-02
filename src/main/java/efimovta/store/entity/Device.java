package efimovta.store.entity;

import efimovta.store.NotAllFieldsAreFilledException;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Immutable Device entity. Creation occurs through the builder.
 */
public class Device implements Identified {
    private static int nextId = 1;
    private final int id = nextId++;

    private String model;
    private DeviceType type;
    private Brand brand;

    private NamedColor color;
    private Date releaseDate;
    private BigDecimal price;

    private Device() {

    }

    /**
     * @return a new builder instance
     * @see Builder
     */
    public static Builder getBuilder() {
        return new Builder();
    }

    public long getId() {
        return id;
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

    /**
     * Compares this device to the specified object.
     * The identifier is not taken into comparing.
     *
     * @param o The object to compare this Device against
     * @return true if the given object represents a Device equivalent
     * to this device, false otherwise
     */
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

    /**
     * Returns a hash code for this device.
     * The identifier is not taken into calculation.
     *
     * @return a hash code for this device.
     */
    @Override
    public int hashCode() {
        int result = getType().hashCode();
        result = 31 * result + getBrand().hashCode();
        result = 31 * result + getColor().hashCode();
        result = 31 * result + getReleaseDate().hashCode();
        result = 31 * result + getPrice().hashCode();
        return result;
    }

    /**
     * @return a string representation of the device.
     */
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


    /**
     * Class is used to instantiate devices.<br/> Contains a temporary instance
     * of the device, which is filled with information through the setters.
     * <br/>Creation of new device instances is performed by calling
     * a {@link Builder#build()} method.
     * <br/>One instance of the builder can be used multiple times,
     * the constructed instances are independent
     *
     * @see Device#getBuilder()
     */
    public static class Builder {
        Device tmp = new Device();

        private Builder() {

        }


        /**
         * Verifies that all fields have been filled in and
         * creates a new instance of the device.
         * @return new device instance
         * @throws NotAllFieldsAreFilledException
         */
        public Device build() throws NotAllFieldsAreFilledException {
            checkFields();
            Device newDevice = tmp;
            tmp = new Device();
            return newDevice;
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
            tmp.releaseDate = (Date) releaseDate.clone();
            return this;
        }

        public Builder setPrice(BigDecimal price) {
            tmp.price = price;
            return this;
        }

        private void checkFields() throws NotAllFieldsAreFilledException {
            if( tmp.brand == null
                    || tmp.color == null
                    || tmp.model == null
                    || tmp.price == null
                    || tmp.releaseDate == null
                    || tmp.type == null){
                throw new NotAllFieldsAreFilledException();}
        }
    }


}
