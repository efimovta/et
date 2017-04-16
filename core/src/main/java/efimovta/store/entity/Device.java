package efimovta.store.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Immutable Device entity.
 */
public class Device implements Identified, Serializable, CloneReady<Device> {
    private static long nextId = 0;
    private final long id;

    private String model;
    private DeviceType type;
    private Brand brand;
    private NamedColor color;
    private Date releaseDate;
    private BigDecimal price;

    public Device() {
        id = nextId++;
    }

    public Device(Device device) {
        id = device.getId();
        model = device.getModel();
        type = device.getType();
        brand = device.getBrand();
        color = device.getColor();
        releaseDate = device.getReleaseDate();
        price = device.getPrice();
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

    public Device setModel(String model) {
        this.model = model;
        return this;
    }

    public Device setType(DeviceType type) {
        this.type = type;
        return this;
    }

    public Device setBrand(Brand brand) {
        this.brand = brand;
        return this;
    }

    public Device setColor(NamedColor color) {
        this.color = color;
        return this;
    }

    public Device setReleaseDate(Date releaseDate) {
        this.releaseDate = (Date) releaseDate.clone();
        return this;
    }

    public Device setPrice(BigDecimal price) {
        this.price = price;
        return this;
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

    @Override
    public Device getClone() {
        return new Device(this);
    }
}
