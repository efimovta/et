package efimovta.store.menu;

import efimovta.store.dao.DAOException;
import efimovta.store.entity.*;
import efimovta.store.menu.exception.OperationCanceledByUserException;
import efimovta.store.menu.exception.OperationException;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static efimovta.store.Constants.br;

/**
 * Created by EFIMOVAT on 08.04.2017.
 */
public class Menu {


    public static void startDialog() throws IOException {//todo mb more powerful tree menu
        activateMenu(new MainMenuItems());
    }

    private static void activateMenu(MenuItems menuItems) throws IOException {
        while (true) {
            System.out.println(menuItems);
            int i = 1;
            for (MenuItem mi : menuItems.get()) {
                System.out.println(i + ". " + mi);
                i++;
            }

            System.out.println("Выбирете действие:");
            String strOtv = br.readLine();
            try {
                int otv = Integer.parseInt(strOtv) - 1;
                menuItems.get().get(otv).execute();
            } catch (IndexOutOfBoundsException | NumberFormatException e) {
                System.err.println("Неверный ввод.");
            } catch (OperationException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    MenuItems search = new MenuItems("\n### Поиск ###") {
        MenuItem[] menuItems = {
                new MenuItem("Все клиенты") {
                    @Override
                    public void execute() throws IOException {
                        try {
                            for (Client client : Searcher.findAllClients()) {
                                System.out.println(Viewer.toString(client));
                            }
                        } catch (DAOException e) {
                            System.err.println(e.getMessage());
                        }
                    }
                },
                new MenuItem("Все устройства") {
                    @Override
                    public void execute() throws IOException {
                        try {
                            for (Device device : Searcher.findAllDevices()) {
                                System.out.println(Viewer.toString(device));
                            }
                        } catch (DAOException e) {
                            System.err.println(e.getMessage());
                        }
                    }
                },
                new MenuItem("Все продажи") {
                    @Override
                    public void execute() throws IOException {
                        try {
                            for (Sale sale : Searcher.findAllSales()) {
                                System.out.println(Viewer.toString(sale));
                            }
                        } catch (DAOException e) {
                            System.err.println(e.getMessage());
                        }
                    }
                },
                new MenuItem("Поиск клиента(ов) по ФИО") {
                    @Override
                    public void execute() throws IOException, OperationCanceledByUserException {
                        try {
                            for (Client client : Searcher.findClientByFIO()) {
                                System.out.println(Viewer.toString(client));
                            }
                        } catch (DAOException e) {
                            System.err.println(e.getMessage());
                        }
                    }
                },
                new MenuItem("Поиск устройств по марке") {
                    @Override
                    public void execute() throws IOException, OperationCanceledByUserException {
                        try {
                            for (Device device : Searcher.findDeviceByBrand()) {
                                System.out.println(Viewer.toString(device));
                            }
                        } catch (DAOException e) {
                            System.err.println(e.getMessage());
                        }
                    }
                },
                new MenuItem("Поиск устройств по типу") {
                    @Override
                    public void execute() throws IOException, OperationCanceledByUserException {
                        try {
                            for (Device device : Searcher.findDeviceByType()) {
                                System.out.println(Viewer.toString(device));
                            }
                        } catch (DAOException e) {
                            System.err.println(e.getMessage());
                        }
                    }
                },
                new MenuItem("Поиск устройств по году выпуска") {
                    @Override
                    public void execute() throws IOException, OperationCanceledByUserException {
                        try {
                            for (Device device : Searcher.findDeviceByReleaseDate()) {
                                System.out.println(Viewer.toString(device));
                            }
                        } catch (DAOException e) {
                            System.err.println(e.getMessage());
                        }
                    }
                },
                new MenuItem("Возвращение к главному меню") {
                    @Override
                    public void execute() throws IOException {
                        System.out.println("...возвращение к главному меню...");
                        //todo mb better way?
                    }
                }
        };

        @Override
        public List<MenuItem> get() {
            return menuItems;
        }
    };

    MenuItems search = new MenuItems("\n### Поиск ###") {
        MenuItem[] menuItems = {
                new MenuItem("Просмотр клиентов, отстортированных по ФИО") {//todo mb move strings to Constants
                    @Override
                    public void execute() throws IOException {
                        List<Client> ar = null;
                        try {
                            ar = Searcher.findAllClients();
                        } catch (DAOException e) {
                            System.err.println(e.getMessage());
                        }
                        Collections.sort(ar, ClientComparator.BY_FIO);
                        for (Client client : ar) {
                            System.out.println(Viewer.toString(client));
                        }
                    }
                },
                new MenuItem("Возвращение к главному меню") {
                    @Override
                    public void execute() throws IOException {
                        System.out.println("...возвращение к главному меню...");
                        //todo mb better way?
                    }
                }
        };

        @Override
        public List<MenuItem> get() {
            return menuItems;
        }
    };
}
