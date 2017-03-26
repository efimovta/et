package efimovta.store.menu;

import efimovta.store.dao.exeption.DAOException;
import efimovta.store.entity.Client;
import efimovta.store.entity.Device;
import efimovta.store.entity.Sale;
import efimovta.store.menu.exception.OperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jcd on 13.03.2017.
 */
public class SearchMenu {

    public static void startDialog() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<SearchMenuItem> items = Arrays.asList(SearchMenuItem.values());
        while (true) {
            System.out.println("\n### Поиск ###");
            for (SearchMenuItem smi : SearchMenuItem.values()) {
                System.out.println(smi.ordinal()+1 + ". " + smi);
            }

            System.out.println("Выбирете действие:");
            String strOtv = br.readLine();
            try {
                int otv = Integer.parseInt(strOtv)-1;
                SearchMenuItem otvItem = items.get(otv);
                switch (otvItem) {
                    case ALL_CLIENT:
                        for (Client client : Searcher.findAllClients()) {
                            System.out.println(client);
                        }
                        break;
                    case ALL_DEVICE:
                        for (Device device : Searcher.findAllDevices()) {
                            System.out.println(device);
                        }
                        break;
                    case ALL_SALE:
                        for (Sale sale : Searcher.findAllSales()) {
                            System.out.println(sale);
                        }
                        break;
                    case CLIENT_BY_FIO:
                        for (Client client : Searcher.findClientByFIO()) {
                            System.out.println(client);
                        }
                        break;
                    case DEVICE_BY_BRAND:
                        for (Device device : Searcher.findDeviceByBrand()) {
                            System.out.println(device);
                        }
                        break;
                    case DEVICE_BY_TYPE:
                        for (Device device : Searcher.findDeviceByType()) {
                            System.out.println(device);
                        }
                        break;
                    case DEVICE_BY_RELEASE_DATE:
                        for (Device device : Searcher.findDeviceByReleaseDate()) {
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
