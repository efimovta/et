package efimovta.store.entity;

import efimovta.store.enums.Brand;
import efimovta.store.enums.DeviceType;
import efimovta.store.enums.NamedColor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by EFIMOVAT on 11.03.2017.
 */
public class Device {
    private static int nextId = 1;
    private final int id = nextId++;
    public int getId() {
        return id;
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

    public Device(String model, DeviceType type, Brand brand, NamedColor color, Date releaseDate, BigDecimal price) {
        this.model = model;
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.releaseDate = releaseDate;
        this.price = price;
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

    String model;
    DeviceType type;
    Brand brand;
    NamedColor color;
    Date releaseDate;
    BigDecimal price;
}
