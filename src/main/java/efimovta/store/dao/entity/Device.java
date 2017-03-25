package efimovta.store.dao.entity;

import efimovta.store.dao.entity.enums.Brand;
import efimovta.store.dao.entity.enums.DeviceType;
import efimovta.store.dao.entity.enums.NamedColor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by EFIMOVAT on 11.03.2017.
 */
public class Device implements Identified {//TODO builder(or not?)
    private static int nextId = 1;
    private final int id = nextId++;

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
