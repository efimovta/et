package efimovta.store;

/**
 * Created by EFIMOVAT on 08.04.2017.
 */
public class DeviceStore {
    static {
        //StorageFiller.fillStorage();
    }

    public static void main(String[] args) {
        //IDeviceStore iDeviceStore = getDeviceStore();
    }

    public static IDeviceStore getDeviceStore() {
        return new DeviceStoreImpl();
    }
}
