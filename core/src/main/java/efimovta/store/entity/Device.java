package efimovta.store.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Device entity.
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

    /**
     * id was auto generated from static field "nextId"
     * by incrementation
     */
    public Device() {
        id = nextId++;
    }

    /**
     * Create copy of device. All fields will be copied.
     *
     * @param device to copy
     */
    public Device(Device device) {
        id = device.getId();
        model = device.getModel();
        type = device.getType();
        brand = device.getBrand();
        color = device.getColor();
        releaseDate = device.getReleaseDate();
        price = device.getPrice();
    }


    /**
     * Return unique identifier of this device.
     * For first instance it is 0.
     *
     * @return Unique identifier of this device
     */
    public long getId() {
        return id;
    }

    /**
     * @return model of this device
     */
    public String getModel() {
        return model;
    }

    /**
     * @return type of this device
     */
    public DeviceType getType() {
        return type;
    }

    /**
     * @return brand of this device
     */
    public Brand getBrand() {
        return brand;
    }

    /**
     * @return color of this device
     */
    public NamedColor getColor() {
        return color;
    }

    /**
     * @return clone instance of device release date
     */
    public Date getReleaseDate() {
        return (Date) releaseDate.clone();
    }

    /**
     * @return price of this device
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param model model for set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @param type type for set
     */
    public void setType(DeviceType type) {
        this.type = type;
    }

    /**
     * @param brand brand for set
     */
    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    /**
     * @param color color for set
     */
    public void setColor(NamedColor color) {
        this.color = color;
    }

    /**
     * Set copy of releaseDate
     *
     * @param releaseDate release date for set
     */
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = (Date) releaseDate.clone();
    }

    /**
     * @param price price for set
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
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
                    && getType().equals(device.getType())
                    && getBrand().equals(device.getBrand())
                    && getColor().equals(device.getColor())
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
     * Creates and returns a copy of this object.
     * Uses the copy constructor.
     *
     * @return copy of this object
     */
    @Override
    public Device getClone() {
        return new Device(this);
    }
}
