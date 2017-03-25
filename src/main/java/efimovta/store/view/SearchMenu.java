package efimovta.store.view;

import efimovta.store.dao.ClientDAO;
import efimovta.store.dao.DeviceDAO;
import efimovta.store.dao.SaleDAO;
import efimovta.store.dao.entity.Client;
import efimovta.store.dao.entity.Device;
import efimovta.store.dao.entity.Sale;
import efimovta.store.dao.entity.enums.Brand;
import efimovta.store.dao.entity.enums.DeviceType;
import efimovta.store.dao.exeption.DAOException;
import efimovta.store.dao.factory.DAOFactory;
import efimovta.store.view.creator.requester.ClientParamsRequester;
import efimovta.store.view.creator.requester.DeviceParamsRequester;
import efimovta.store.view.exception.OperationCanceledByUserException;
import efimovta.store.view.exception.OperationException;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by jcd on 13.03.2017.
 */
public class SearchMenu extends Menu{//todo mb singleton

    ClientDAO clientDAO = DAOFactory.get().getClientDAO();
    DeviceDAO deviceDAO = DAOFactory.get().getDeviceDAO();
    SaleDAO saleDAO = DAOFactory.get().getSaleDAO();

    DeviceParamsRequester dpr = DeviceParamsRequester.getInstance();
    ClientParamsRequester cpr = ClientParamsRequester.getInstance();


    public void startDialog() throws IOException {
        List<SearchMenuItem> items = Arrays.asList(SearchMenuItem.values());
        while (true) {
            System.out.println("\n### Поиск ###");
            for (SearchMenuItem smi : SearchMenuItem.values()) {
                System.out.println(smi.ordinal()+1 + ". " + smi);
            }

            System.out.println("Выбирете действие:");
            try {
                int otv = Integer.parseInt(getReader().readLine())-1;
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
        Date date = dpr.requestReleaseDate();

        return deviceDAO.findDeviceByReleaseDate(date);
    }

    private List<Device> findDeviceByType() throws IOException, OperationCanceledByUserException, DAOException {
        DeviceType type = dpr.requestType();

        return deviceDAO.findDeviceByType(type);
    }

    private List<Device> findDeviceByBrand() throws IOException, OperationCanceledByUserException, DAOException {
        Brand brand = dpr.requestBrand();

        return deviceDAO.findDevicesByBrand(brand);
    }

    private List<Client> findClientByFIO() throws IOException, OperationCanceledByUserException, DAOException {
        String[] fiom = cpr.requestFIO();

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
