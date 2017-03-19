package efimovta.store.storage;

import efimovta.store.entity.Client;
import efimovta.store.entity.Device;
import efimovta.store.entity.Sale;
import efimovta.store.enums.Brand;
import efimovta.store.enums.DeviceType;
import efimovta.store.enums.NamedColor;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * Created by EFIMOVAT on 13.03.2017.
 */
public class StorageInMemory {
    static final public ArrayList<Device> devices = new ArrayList<>();
    static final public ArrayList<Client> clients = new ArrayList<>();
    static final public ArrayList<Sale> sales = new ArrayList<>();
}
