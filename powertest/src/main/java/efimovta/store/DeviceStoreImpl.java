package efimovta.store;

import efimovta.store.dao.ClientDAO;
import efimovta.store.dao.DAOException;
import efimovta.store.dao.DAOFactory;
import efimovta.store.dao.DeviceDAO;
import efimovta.store.dao.SaleDAO;
import efimovta.store.entity.Brand;
import efimovta.store.entity.Client;
import efimovta.store.entity.ClientComparator;
import efimovta.store.entity.Device;
import efimovta.store.entity.DeviceComparator;
import efimovta.store.entity.DeviceType;
import efimovta.store.entity.NamedColor;
import efimovta.store.entity.Sale;
import efimovta.store.entity.SaleComparator;

import java.awt.Color;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by EFIMOVAT on 08.04.2017.
 */
public class DeviceStoreImpl implements IDeviceStore {
    private static final Logger log = Logger.getLogger(DeviceStoreImpl.class.getName());

    ClientDAO clientDAO = DAOFactory.get().getClientDAO();
    DeviceDAO deviceDAO = DAOFactory.get().getDeviceDAO();
    SaleDAO saleDAO = DAOFactory.get().getSaleDAO();


    public void addClient(String lastName, String firstName, String middleName, Date birthDate) {
        try {
            Client client = new Client();
            client.setSecondName(lastName);
            client.setFirstName(firstName);
            client.setMiddleName(middleName);
            client.setBirthday(birthDate);

            clientDAO.add(client);
        } catch (DAOException e) {
            log.log(Level.SEVERE, e.getMessage(), e);

        }
    }


    public void addDevice(String type, String brand, String model, Color color, Date issueDate) {
        try {
            DeviceType deviceType = DeviceType.valueOf(type);
            Brand deviceBrand = Brand.valueOf(brand);
            NamedColor deviceColor = NamedColor.getNamedColor(color);

            Device device = new Device();
            device.setType(deviceType);
            device.setBrand(deviceBrand);
            device.setModel(model);
            device.setColor(deviceColor);
            device.setPrice(new BigDecimal(0));
            device.setReleaseDate(issueDate);

            deviceDAO.add(device);
        } catch (DAOException e) {
            log.log(Level.SEVERE, e.getMessage(), e);
        }
    }


    public void addSale(Date saleDate, Integer clientId, Map<Integer, Integer> deviceIdAndQuantity) {
        try {
            Client client = clientDAO.findById(clientId);
            Map<Device, Integer> devices = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : deviceIdAndQuantity.entrySet()) {
                int id = entry.getKey();
                int count = entry.getValue();
                Device device = deviceDAO.findById(id);
                devices.put(device, count);
            }

            Sale sale = new Sale();
            sale.setSaleDate(saleDate);
            sale.setClient(client);
            sale.setDevices(devices);
            saleDAO.add(sale);
        } catch (DAOException e) {
            log.log(Level.SEVERE, e.getMessage(), e);
        }
    }


    public void searchClientsByName(String name) {
        List<Client> clients = new ArrayList<>();
        clients.addAll(clientDAO.findByAnyName(name));
    }


    public void searchDevicesByIssueDate(Date issueDate) {
        deviceDAO.findDeviceByReleaseDate(issueDate);
    }


    public void sortClientsByName() {
        List<Client> clients = clientDAO.getAll();
        Collections.sort(clients, ClientComparator.BY_FIO);
    }


    public void sortDevicesByModel() {
        List<Device> devices = deviceDAO.getAll();
        Collections.sort(devices, DeviceComparator.BY_MODEL);
    }


    public void sortSalesByDate() {
        List<Sale> sales = saleDAO.getAll();
        Collections.sort(sales, SaleComparator.BY_SALE_DATE);
    }
}
