package efimovta.store.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Device entity.
 */
public class Device implements Identified, Serializable, CloneReady<Device> {
    private long id;
    private String model;
    private DeviceType type;
    private Brand brand;
    private NamedColor color;
    private Date releaseDate;
    private BigDecimal price;

    /**
     * default constructor
     */
    public Device() {
        //default constructor
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
     * @return device id
     */
    @Override
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
     * @return model of this device
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model model for set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return type of this device
     */
    public DeviceType getType() {
        return type;
    }

    /**
     * @param type type for set
     */
    public void setType(DeviceType type) {
        this.type = type;
    }

    /**
     * @return brand of this device
     */
    public Brand getBrand() {
        return brand;
    }

    /**
     * @param brand brand for set
     */
    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    /**
     * @return color of this device
     */
    public NamedColor getColor() {
        return color;
    }

    /**
     * @param color color for set
     */
    public void setColor(NamedColor color) {
        this.color = color;
    }

    /**
     * @return clone instance of device release date
     */
    public Date getReleaseDate() {
        return (Date) releaseDate.clone();
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
     * @return price of this device
     */
    public BigDecimal getPrice() {
        return price;
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
            otv = true;
            if (model != null && !model.equals(device.model)
                    || model == null && model != device.model) {
                otv = false;
            } else if (type != null && !type.equals(device.type)
                    || type == null && type != device.type) {
                otv = false;
            } else if (brand != null && !brand.equals(device.brand)
                    || brand == null && brand != device.brand) {
                otv = false;
            } else if (color != null && !color.equals(device.color)
                    ||color == null &&  color != device.color) {
                otv = false;
            } else if (releaseDate != null && !releaseDate.equals(device.releaseDate)
                    || releaseDate == null && releaseDate != device.releaseDate) {
                otv = false;
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
