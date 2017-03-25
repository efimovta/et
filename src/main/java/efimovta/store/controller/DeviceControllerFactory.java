package efimovta.store.controller;

/**
 * Created by jcd on 25.03.2017.
 */
public class DeviceControllerFactory {
    private static DeviceController deviceController;
    public synchronized DeviceController get(){
        if (deviceController == null) {
            deviceController = new DeviceControllerImpl();
        }
        return deviceController;
    }
}
