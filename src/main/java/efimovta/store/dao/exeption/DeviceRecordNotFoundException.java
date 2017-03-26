package efimovta.store.dao.exeption;

/**
 * Created by EFIMOVAT on 26.03.2017.
 */
public class DeviceRecordNotFoundException extends RecordNotFoundException {
    public DeviceRecordNotFoundException(String s) {
        super(s);
    }

    public DeviceRecordNotFoundException() {
        super("Запись об устройстве не найдена");
    }
}
