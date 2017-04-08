package efimovta.store.menu;

import efimovta.store.menu.exception.OperationException;

import java.io.IOException;

import static efimovta.store.Constants.br;


/**
 * Class contains only one method that represents the "main menu"
 */
public class MainMenu {

    /**
     * Represents the "main menu"
     *
     * @throws IOException
     */
    public static void startDialog() throws IOException {//todo mb more powerful tree menu
        while (true) {
            System.out.println("\n### Компания \"Horns and hooves and your super device\" ###");
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
            } catch (IndexOutOfBoundsException|NumberFormatException e) {
                System.err.println("Неверный ввод.");
            } catch (OperationException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static MenuItem[] menuItems = {
            new MenuItem("Добавление") {
                @Override public void execute() throws IOException {
                    CreateMenu.startDialog();
                }
            },
            new MenuItem("Поиск") {
                @Override public void execute() throws IOException {
                    SearchMenu.startDialog();
                }
            },
            new MenuItem("Просмотр в отсортированном виде") {
                @Override public void execute() throws IOException {
                    SortedViewMenu.startDialog();
                }
            },
            new MenuItem("Выход из программы") {
                @Override public void execute() {
                    System.exit(0);
                }
            }
    };
}
