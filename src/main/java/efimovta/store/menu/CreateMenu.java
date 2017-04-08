package efimovta.store.menu;

import efimovta.store.menu.exception.OperationCanceledByUserException;
import efimovta.store.menu.exception.OperationException;

import java.io.IOException;

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
        while (true) {
            System.out.println("\n### Добавление ###");
            int i=1;
            for (MenuItem mi : menuItems) {
                System.out.println(i + ". " + mi);
                i++;
            }

            System.out.println("Выбирете действие:");
            String strOtv = br.readLine();
            try {
                int otv = Integer.parseInt(strOtv) - 1;
                menuItems[otv].execute();
            } catch (OperationException e) {
                System.err.println(e.getMessage());
            }catch (IndexOutOfBoundsException|NumberFormatException e) {
                System.err.println("Неверный ввод.");
            }
        }
    }
    static MenuItem[] menuItems = {
            new MenuItem("Добавление клиента") {//todo mb move strings to Constants
                @Override public void execute() throws IOException, OperationCanceledByUserException {
                    Creator.startClientCreationDialog();
                    System.out.println("Клиент успешно добавлен.");
                }
            },
            new MenuItem("Добавление устройства") {
                @Override public void execute() throws IOException, OperationCanceledByUserException {
                    Creator.startDeviceCreationDialog();
                    System.out.println("Устройство успешно добавлено.");
                }
            },
            new MenuItem("Добавление продажи") {
                @Override public void execute() throws IOException, OperationCanceledByUserException {
                    Creator.startSaleCreationDialog();
                    System.out.println("Продажа успешно добавлена.");
                }
            },
            new MenuItem("Возвращение к главному меню") {
                @Override public void execute() throws IOException {
                    System.out.println("...возвращение к главному меню...");
                    //todo mb better way?
                }
            }
    };
}
