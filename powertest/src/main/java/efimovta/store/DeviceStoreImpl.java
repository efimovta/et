package efimovta.store;

import efimovta.store.dao.*;
import efimovta.store.entity.*;

import java.awt.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.List;

/**
 * Created by EFIMOVAT on 08.04.2017.
 */
public class DeviceStoreImpl implements IDeviceStore {
    ClientDAO clientDAO = DAOFactory.get().getClientDAO();
    DeviceDAO deviceDAO = DAOFactory.get().getDeviceDAO();
    SaleDAO saleDAO = DAOFactory.get().getSaleDAO();


   
    public void addClient(String lastName, String firstName, String middleName, Date birthDate) {
        try {
            Client client = new Client()
                    .setSecondName(lastName)
                    .setFirtsName(firstName)
                    .setMiddleName(middleName)
                    .setBirthday(birthDate);
            clientDAO.add(client);
        } catch (DAOException e) {
            e.printStackTrace();//todo mb make better
        }
    }

   
    public void addDevice(String type, String brand, String model, Color color, Date issueDate) {
        try {
            DeviceType deviceType = DeviceType.valueOf(type);
            Brand deviceBrand = Brand.valueOf(brand);
            NamedColor deviceColor = NamedColor.getNamedColor(color);

            Device device = new Device()
                    .setType(deviceType)
                    .setBrand(deviceBrand)
                    .setModel(model)
                    .setColor(deviceColor)
                    .setPrice(new BigDecimal(0))
                    .setReleaseDate(issueDate);
            deviceDAO.add(device);
        } catch (DAOException e) {
            e.printStackTrace();
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

            Sale sale = new Sale()
                    .setSaleDate(saleDate)
                    .setClient(client)
                    .setDevices(devices);
            saleDAO.add(sale);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

   
    public void searchClientsByName(String name) {
        try {
            List<Client> clients = new ArrayList<>();
            clients.addAll(clientDAO.findByFirstName(name));
        } catch (DAOException e) {
            System.err.println("findByFirstName(\'"+name+"\') not found");
        }
        try {
            List<Client> clients = new ArrayList<>();
            clients.addAll(clientDAO.findBySecondName(name));
        } catch (DAOException e) {
            System.err.println("findBySecondName(\'"+name+"\') not found");
        }
        try {
            List<Client> clients = new ArrayList<>();
            clients.addAll(clientDAO.findByMiddleName(name));
        } catch (DAOException e) {
            System.err.println("findByMiddleName(\'"+name+"\') not found");
        }
    }

   
    public void searchDevicesByIssueDate(Date issueDate) {
        try {
            List<Device> devices = deviceDAO.findDeviceByReleaseDate(issueDate);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

   
    public void sortClientsByName() {
        try {
            List<Client> clients = clientDAO.getAll();
            Collections.sort(clients, ClientComparator.BY_FIO);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

   
    public void sortDevicesByModel() {
        try {
            List<Device> devices = deviceDAO.getAll();
            Collections.sort(devices, DeviceComparator.BY_MODEL);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

   
    public void sortSalesByDate() {
        try {
            List<Sale> sales = saleDAO.getAll();
            Collections.sort(sales, SaleComparator.BY_SALE_DATE);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
