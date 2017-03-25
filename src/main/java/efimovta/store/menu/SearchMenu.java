package efimovta.store.menu;

import efimovta.store.dao.ClientDAO;
import efimovta.store.dao.DeviceDAO;
import efimovta.store.dao.SaleDAO;
import efimovta.store.dao.entity.Sale;
import efimovta.store.dao.exeption.DAOException;
import efimovta.store.dao.factory.DAOFactory;
import efimovta.store.dao.entity.Client;
import efimovta.store.dao.entity.Device;
import efimovta.store.dao.entity.enums.Brand;
import efimovta.store.dao.entity.enums.DeviceType;
import efimovta.store.menu.exception.OperationCanceledByUserException;
import efimovta.store.menu.exception.OperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by jcd on 13.03.2017.
 */
public class SearchMenu {

    BufferedReader br = MainMenu.br;

    ClientDAO clientDAO = DAOFactory.getDAOFactory(DAOFactory.STORAGE_IN_MEMORY).getClientDAO();
    DeviceDAO deviceDAO = DAOFactory.getDAOFactory(DAOFactory.STORAGE_IN_MEMORY).getDeviceDAO();
    SaleDAO saleDAO = DAOFactory.getDAOFactory(DAOFactory.STORAGE_IN_MEMORY).getSaleDAO();

    public void startDialog() throws IOException {
        while (true) {
            System.out.println("\n### Поиск ###");
            List<SearchMenuItem> items = Arrays.asList(SearchMenuItem.values());
            for (SearchMenuItem smi : SearchMenuItem.values()) {
                System.out.println(smi.ordinal()+1 + ". " + smi);
            }

            System.out.println("Выбирете действие:");
            try {
                int otv = Integer.parseInt(br.readLine())-1;
                SearchMenuItem otvItem = items.get(otv);
                switch (otvItem) {
                    case ALL_CLIENT:
                        for (Client client : clientDAO.getAll()) {
                            System.out.println(client);
                        }
                        break;
                    case ALL_DEVICE:
                        for (Device device : deviceDAO.getAll()) {
                            System.out.println(device);
                        }
                        break;
                    case ALL_SALE:
                        for (Sale device : saleDAO.getAll()) {
                            System.out.println(device);
                        }
                        break;
                    case CLIENT_BY_FIO:
                        for (Client client : findClientByFIO()) {
                            System.out.println(client);
                        }
                        break;
                    case DEVICE_BY_BRAND:
                        for (Device device : findDeviceByBrand()) {
                            System.out.println(device);
                        }
                        break;
                    case DEVICE_BY_TYPE:
                        for (Device device : findDeviceByType()) {
                            System.out.println(device);
                        }
                        break;
                    case DEVICE_BY_RELEASE_DATE:
                        for (Device device : findDeviceByReleaseDate()) {
                            System.out.println(device);
                        }
                        break;
                    case RETURN_TO_MAIN_MENU:
                        return;
                }
            } catch (OperationException | DAOException e) {
                System.err.println(e.getMessage());
            }catch (IndexOutOfBoundsException|NumberFormatException e) {
                System.err.println("Неверный ввод.");
            }
        }
    }

    private List<Device> findDeviceByReleaseDate() throws IOException, OperationCanceledByUserException, DAOException {
        Date date = CreateMenu.deviceCreator.requestReleaseDate();

        return deviceDAO.findDeviceByReleaseDate(date);
    }

    private List<Device> findDeviceByType() throws IOException, OperationCanceledByUserException, DAOException {
        DeviceType type = CreateMenu.deviceCreator.requestType();

        return deviceDAO.findDeviceByType(type);
    }

    private List<Device> findDeviceByBrand() throws IOException, OperationCanceledByUserException, DAOException {
        Brand brand = CreateMenu.deviceCreator.requestBrand();

        return deviceDAO.findDevicesByBrand(brand);
    }

    private List<Client> findClientByFIO() throws IOException, OperationCanceledByUserException, DAOException {
        String[] fiom = CreateMenu.clientCreator.requestFIO();

        String fio = Arrays.toString(fiom).replaceAll("\\[|\\]|,", "").toLowerCase();

        return clientDAO.findByFIO(fio);
    }

    enum SearchMenuItem {
        ALL_CLIENT("Все клиенты"),
        ALL_DEVICE("Все устройства"),
        ALL_SALE("Все продажи"),
        CLIENT_BY_FIO("Поиск клиента(ов) по ФИО"),
        DEVICE_BY_BRAND("Поиск устройств по марке"),
        DEVICE_BY_TYPE("Поиск устройств по типу"),
        DEVICE_BY_RELEASE_DATE("Поиск устройств по году выпуска"),
        RETURN_TO_MAIN_MENU("Возврат к главному меню");

        String description;

        SearchMenuItem(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return description;
        }
    }

}
