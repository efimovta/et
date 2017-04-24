package efimovta.store;

/**
 * For powertest
 */
public class DeviceStore {

    private DeviceStore() {
    }

    public static void main(String[] args) {
        //non
    }

    public static IDeviceStore getDeviceStore() {
        return new DeviceStoreImpl();
    }
}
