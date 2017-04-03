package efimovta.store.menu;

import efimovta.store.dao.DAOException;
import efimovta.store.entity.Client;
import efimovta.store.entity.ClientComparator;
import efimovta.store.entity.Viewer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by jcd on 13.03.2017.
 */
public class SortedViewMenu {

    public static void startDialog() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<SortedViewMenuItem> items = Arrays.asList(SortedViewMenuItem.values());
        while (true) {
            System.out.println("\n### Просмотр ###");
            for (SortedViewMenuItem smi : SortedViewMenuItem.values()) {
                System.out.println(smi.ordinal() + 1 + ". " + smi);
            }

            System.out.println("Выбирете действие:");
            String strOtv = br.readLine();
            try {
                int otv = Integer.parseInt(strOtv) - 1;
                SortedViewMenuItem otvItem = items.get(otv);
                switch (otvItem) {
                    case CLIENTS_BY_FIO:
                        List<Client> ar = Searcher.findAllClients();
                        Collections.sort(ar, ClientComparator.BY_FIO);
                        for (Client client : ar) {
                            System.out.println(Viewer.toString(client));
                        }
                        break;
                    case RETURN_TO_MAIN_MENU:
                        return;
                }
            } catch (DAOException e) {
                System.err.println(e.getMessage());
            } catch (IndexOutOfBoundsException | NumberFormatException e) {
                System.err.println("Неверный ввод.");
            }
        }
    }

    enum SortedViewMenuItem {
        //        CLIENTS_BY_ID("Просмотр клиентов, отстортированных по ФИО"),
        CLIENTS_BY_FIO("Просмотр клиентов, отстортированных по ФИО"),
        //        CLIENTS_BY_SECOND_NAME("Просмотр клиентов, отстортированных по ФИО"),
        //        CLIENTS_BY_NAME("Просмотр клиентов, отстортированных по ФИО"),
        //        CLIENTS_BY_MIDDLE_NAME("Просмотр клиентов, отстортированных по ФИО"),
        RETURN_TO_MAIN_MENU("Возврат к главному меню");

        String description;

        SortedViewMenuItem(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return description;
        }
    }

}
