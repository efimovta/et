package efimovta.store.menu;

import efimovta.store.menu.creator.ClientCreator;
import efimovta.store.menu.creator.DeviceCreator;
import efimovta.store.menu.creator.SaleCreator;
import efimovta.store.menu.exception.OperationException;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * The class contains only one method that represents "create menu"
 */
public class CreateMenu extends Menu{//todo mb singleton

    final static public ClientCreator clientCreator = new ClientCreator();
    final static public DeviceCreator deviceCreator = new DeviceCreator();
    final static public SaleCreator saleCreator = new SaleCreator();

    /**
     * represents "create menu"
     *
     * @throws IOException
     */
    public void startDialog() throws IOException {
        List<CreateMenuItem> items = Arrays.asList(CreateMenuItem.values());
        while (true) {
            System.out.println("\n### Добавление ###");
            for (CreateMenuItem cmi : CreateMenuItem.values()) {
                System.out.println(cmi.ordinal()+1 + ". " + cmi);
            }

            System.out.println("Выбирете действие:");
            try {
                int otv = Integer.parseInt(getReader().readLine())-1;
                CreateMenuItem otvItem = items.get(otv);
                switch (otvItem) {
                    case ADDING_A_CLIENT:
                        clientCreator.startCreationDialog();
                        System.out.println("Клиент успешно добавлен.");
                        break;
                    case ADDING_A_DEVICE:
                        deviceCreator.startCreationDialog();
                        System.out.println("Устройство успешно добавлено.");
                        break;
                    case ADDING_A_SALE:
                        saleCreator.startCreationDialog();
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