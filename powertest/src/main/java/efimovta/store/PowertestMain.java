package efimovta.store;

/**
 * Entry poin for powertest
 */
public class PowertestMain {

    private PowertestMain() {
    }

    public static void main(String[] args) {
        DeviceStoreImplTest deviceStoreImplTest = new DeviceStoreImplTest();
        deviceStoreImplTest.setUp();
    }
}
