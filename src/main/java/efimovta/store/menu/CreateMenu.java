package efimovta.store.menu;

import efimovta.store.menu.exception.OperationException;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static efimovta.store.Constants.br;

/**
 * The class contains only one method that represents "create menu"
 */
public class CreateMenu {

    /**
     * represents "create menu"
     *
     * @throws IOException
     */
    public static void startDialog() throws IOException {
        List<CreateMenuItem> items = Arrays.asList(CreateMenuItem.values());
        while (true) {
            System.out.println("\n### Добавление ###");
            for (CreateMenuItem cmi : CreateMenuItem.values()) {
                System.out.println(cmi.ordinal()+1 + ". " + cmi);
            }

            System.out.println("Выбирете действие:");
            String strOtv = br.readLine();
            try {
                int otv = Integer.parseInt(strOtv)-1;
                CreateMenuItem otvItem = items.get(otv);
                switch (otvItem) {
                    case ADDING_A_CLIENT:
                        Creator.startClientCreationDialog();
                        System.out.println("Клиент успешно добавлен.");
                        break;
                    case ADDING_A_DEVICE:
                        Creator.startDeviceCreationDialog();
                        System.out.println("Устройство успешно добавлено.");
                        break;
                    case ADDING_A_SALE:
                        Creator.startSaleCreationDialog();
                        System.out.println("Продажа успешно добавлена.");
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


    public enum CreateMenuItem {
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
