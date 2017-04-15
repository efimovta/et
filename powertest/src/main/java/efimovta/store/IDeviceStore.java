package efimovta.store;

/**
 * Created by EFIMOVAT on 08.04.2017.
 */
public interface IDeviceStore {
    /**
     * Create new client
     *
     * @param lastName   - like Ivanov
     * @param firstName  - like Ivan
     * @param middleName - like Ivanovich
     * @param birthDate  - like 01.01.1990
     */
    void addClient(String lastName, String firstName, String middleName, java.util.Date birthDate);

    /**
     * Create new device
     *
     * @param type      - type of device: LAPTOP, PHONE, PLAYER or TABLET
     * @param brand     - device brand: ACER, APPLE, ASUS, DELL, HP, LENOVO, MICROSOFT, SAMSUNG, SONY
     * @param model     - device model, any String
     * @param color     - java.awt.Color only
     * @param issueDate - date of device issue
     */
    void addDevice(String type, String brand, String model, java.awt.Color color, java.util.Date issueDate);
    /**
     * Create new sale
     *
     * @param saleDate            - date of sale
     * @param clientId            - id of the client
     * @param deviceIdAndQuantity - map of device id and its quantity
     */
    void addSale(java.util.Date saleDate, Integer clientId, java.util.Map<Integer, Integer> deviceIdAndQuantity);
    /**
     * Search clients by any name (last name, first name or middle name)
     *
     * @param name - last name, first name or middle name
     */
    void searchClientsByName(String name);

    /**
     * Search devices by date of issue
     *
     * @param issueDate - date of device issue
     */
    void searchDevicesByIssueDate(java.util.Date issueDate);

    /**
     * Sort clients by name
     */
    void sortClientsByName();

    /**
     * Sort devices by model
     */
    void sortDevicesByModel();

    /**
     * Sort sales by date
     */
    void sortSalesByDate();
}