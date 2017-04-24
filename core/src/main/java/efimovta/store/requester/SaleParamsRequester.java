package efimovta.store.requester;

import efimovta.store.OperationCanceledByUserException;
import efimovta.store.Util;
import efimovta.store.dao.ClientDAO;
import efimovta.store.dao.DAOFactory;
import efimovta.store.dao.DeviceDAO;
import efimovta.store.entity.Client;
import efimovta.store.entity.Device;

import java.util.HashMap;
import java.util.Map;

import static efimovta.store.Messages.CLIENT_NOT_FOUND;
import static efimovta.store.Messages.DEVICE_ADDED_TO_LIST;
import static efimovta.store.Messages.DEVICE_NOT_FOUND;
import static efimovta.store.Messages.ENTER_SALE_CLIENT_ID;
import static efimovta.store.Messages.ENTER_SALE_DEVICE_ID_AND_COUNT;
import static efimovta.store.Messages.PRESS_TO_END;

/**
 * Sale params requester. Used for request sale params.
 */
public class SaleParamsRequester extends Requester {
    private static SaleParamsRequester ourInstance = new SaleParamsRequester();
    ClientDAO clientDAO = DAOFactory.get().getClientDAO();
    DeviceDAO deviceDAO = DAOFactory.get().getDeviceDAO();

    private SaleParamsRequester() {
    }

    /**
     * @return Singleton {@link SaleParamsRequester}
     */
    public static SaleParamsRequester getInstance() {
        return ourInstance;
    }

    /**
     * Request id and return client with corresponding id
     *
     * @return requested client
     * @throws OperationCanceledByUserException if user type
     *                                          {@link #EXIT_SYMBOL}
     */
    public Client requestClient() throws OperationCanceledByUserException {
        Client client = null;
        Util.println(ENTER_SALE_CLIENT_ID);
        while (client == null) {
            int id = requestIntNumber(0, Integer.MAX_VALUE);
            client = clientDAO.findById(id);
            if (client == null) {
                Util.println(CLIENT_NOT_FOUND + '\n' + INPUT_ERROR_MSG);
            }
        }
        return client;
    }

    /**
     * Request device id and count in cycle, while user not enter
     * exit symbol. Attempt to add another device will overwrite
     * the previous amount.
     *
     * @return map of devices their count
     * @throws OperationCanceledByUserException if map is empty
     */
    public Map<Device, Integer> requestDevices()
            throws OperationCanceledByUserException {
        Map<Device, Integer> map = new HashMap<>();
        String[] ss = null;
        while (true) {
            Util.println(ENTER_SALE_DEVICE_ID_AND_COUNT);
            Util.println(PRESS_TO_END + EXIT_SYMBOL);
            String str = Util.readLine();
            if (str.equals(EXIT_SYMBOL)) {
                break;
            }

            ss = str.trim().split("[ ]+");
            if (ss.length != 2) {
                Util.println(INPUT_ERROR_MSG);
                continue;
            }

            int deviceId;
            int deviceCount;
            try {
                deviceId = Integer.parseInt(ss[0]);
                deviceCount = Integer.parseInt(ss[1]);
            } catch (NumberFormatException e) {
                Util.println(INPUT_ERROR_MSG);
                continue;
            }

            if (deviceCount <= 0) {
                Util.println(INPUT_ERROR_MSG);
                continue;
            }

            Device device = deviceDAO.findById(deviceId);
            if (device == null) {
                Util.println(DEVICE_NOT_FOUND + '\n' + INPUT_ERROR_MSG);
                continue;
            }

            map.put(device, deviceCount);
            Util.println(DEVICE_ADDED_TO_LIST);
        }
        if (map.isEmpty()) {
            throw new OperationCanceledByUserException();
        }

        return map;
    }
}
