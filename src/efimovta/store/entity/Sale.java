package efimovta.store.entity;

import java.util.Date;
import java.util.Map;

/**
 * Created by EFIMOVAT on 11.03.2017.
 */
public class Sale {
    int id;
    Client client;
    Date time;
    Map<Device,Integer> devices;
}
