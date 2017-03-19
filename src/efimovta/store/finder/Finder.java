package efimovta.store.finder;

import efimovta.store.entity.Client;
import efimovta.store.entity.Device;
import efimovta.store.entity.creator.CreateMenu;
import efimovta.store.enums.Brand;
import efimovta.store.enums.DeviceType;
import efimovta.store.exception.ExceededAttemptsException;
import efimovta.store.exception.OperationException;
import efimovta.store.storage.StorageInMemory;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by jcd on 13.03.2017.
 */
public class Finder {
    BufferedReader br;
    CreateMenu createMenu;

    public Finder(BufferedReader br, CreateMenu createMenu) {
        this.br = br;
        this.createMenu = createMenu;
    }

    public void startDialog() throws IOException {
        while (true) {
            System.out.println("\n### Поиск ###");
            System.out.println("1. Поиск клиента(ов) по ФИО");
            System.out.println("2. Поиск устройств по марке");
            System.out.println("3. Поиск устройств по типу");
            System.out.println("4. Поиск устройств по году выпуска");
            System.out.println("5. Возврат к главному меню");
            System.out.println("Выбирете действие:");

            int otv = Integer.parseInt(br.readLine());

            try {
                switch (otv) {
                    case 1:
                        findClient();
                        break;
                    case 2:
                        findDeviceByBrand();
                        break;
                    case 3:
                        findDeviceByType();
                        break;
                    case 4:
                        findDeviceByReleaseDate();
                        break;
                    case 5:
                        return;
                    default:
                        System.err.println("Неверный ввод.");
                }
            } catch (OperationException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private void findDeviceByReleaseDate() throws IOException, ExceededAttemptsException {
        Date type = createMenu.deviceCreator.requestReleaseDate();

        find(StorageInMemory.devices, type, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Device) o1).getReleaseDate().compareTo((Date) o2);
            }
        });
    }

    private void findDeviceByType() throws IOException, ExceededAttemptsException {
        DeviceType type = createMenu.deviceCreator.requestType();

        find(StorageInMemory.devices, type, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Device) o1).getType().compareTo((DeviceType) o2);
            }
        });
    }

    private void findDeviceByBrand() throws IOException, ExceededAttemptsException {
        Brand brand = createMenu.deviceCreator.requestBrand();

        find(StorageInMemory.devices, brand, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Device) o1).getBrand().compareTo((Brand) o2);
            }
        });
    }

    private void findClient() throws IOException, ExceededAttemptsException {
        String[] fiom = createMenu.clientCreator.requestFIO();

        String fio = Arrays.toString(fiom).replaceAll("\\[|\\]|,", "").toLowerCase();

        find(StorageInMemory.clients, fio, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Client) o1).getFIO().compareToIgnoreCase((String) o2);
            }
        });
    }

    public <T, E> void find(ArrayList<T> list, E key, Comparator c) throws IOException {

        ArrayList<T> founded = new ArrayList<>();
        for (T t : list) {
            if (c.compare(t, key) == 0)
                founded.add(t);
        }

        int size = founded.size();
        if (size == 0) System.out.println("Совпадений не найдено.");
        else {
            System.out.println("Найдено совпадений: " + size);
            for (T t : founded) {
                System.out.println(t);
            }
        }
        System.out.println("Нажмите Enter...");
        br.read();
    }


}
