package efimovta.store.menu;

import efimovta.store.menu.exception.OperationException;
import efimovta.store.menu.creator.ClientCreator;
import efimovta.store.menu.creator.DeviceCreator;
import efimovta.store.menu.creator.SaleCreator;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * The class contains only one method that represents "create a menu"
 */
public class CreateMenu {
    private static final int ADDING_A_CLIENT = 1;
    private static final int ADDING_A_DEVICE = ADDING_A_CLIENT + 1;
    private static final int ADDING_A_SALE = ADDING_A_DEVICE + 1;
    private static final int RETURN_TO_MAIN_MENU = ADDING_A_SALE + 1;

    final static public ClientCreator clientCreator = new ClientCreator();
    final static public DeviceCreator deviceCreator = new DeviceCreator();
    final static public SaleCreator saleCreator = new SaleCreator();

    BufferedReader br = MainMenu.br;


    /**
     * represents "create a menu"
     *
     * @throws IOException
     */
    public void startDialog() throws IOException {
        while (true) {
            System.out.println("\n### Добавление ###");
            List<CreateMenuItem> items = Arrays.asList(CreateMenuItem.values());
            for (CreateMenuItem cmi : CreateMenuItem.values()) {
                System.out.println(cmi.ordinal()+1 + ". " + cmi);
            }

            System.out.println("Выбирете действие:");
            try {
                int otv = Integer.parseInt(br.readLine())-1;
                CreateMenuItem otvItem = items.get(otv);
                switch (otvItem) {
                    case ADDING_A_CLIENT:
                        clientCreator.createClient();
                        System.out.println("Клиент успешно добавлен.");
                        break;
                    case ADDING_A_DEVICE:
                        deviceCreator.createDevice();
                        System.out.println("Устройство успешно добавлено.");
                        break;
                    case ADDING_A_SALE:
                        System.err.println("Магазин закрыт.");
                        break;
                    case RETURN_TO_MAIN_MENU:
                        return;
                    default:
                        System.err.println("Неверный ввод.");
                }
            } catch (OperationException e) {
                System.err.println(e.getMessage());
            }catch (IndexOutOfBoundsException|NumberFormatException e) {
                System.err.println("Неверный ввод.");
            }
        }
    }


    enum CreateMenuItem {
        ADDING_A_CLIENT("Добавление клиента"),
        ADDING_A_DEVICE("Добавление устройства"),
        ADDING_A_SALE("Добавление продажи"),
        RETURN_TO_MAIN_MENU("Возврат к главному меню");

        String description;

        CreateMenuItem(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return description;
        }
    }
}
