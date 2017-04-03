package efimovta.store.menu;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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
    public static void startDialog() throws IOException {//todo mb command executor
        List<MainMenuItem> items = Arrays.asList(MainMenuItem.values());
        while (true) {
            System.out.println("\n### Компания \"Horns and hooves and your super device\" ###");
            for (MainMenuItem mmi : MainMenuItem.values()) {
                System.out.println(mmi.ordinal() + 1 + ". " + mmi);
            }

            System.out.println("Выбирете действие:");
            String strOtv = br.readLine();
            try {
                int otv = Integer.parseInt(strOtv) - 1;
                MainMenuItem otvItem = items.get(otv);
                switch (otvItem) {
                    case ADDING:
                        CreateMenu.startDialog();
                        break;
                    case SEARCHING:
                        SearchMenu.startDialog();
                        break;
                    case SORTED_VIEW:
                        SortedViewMenu.startDialog();
                        break;
                    case EXIT:
                        System.exit(0);
                        break;
                }
            } catch (IndexOutOfBoundsException|NumberFormatException e) {
                System.err.println("Неверный ввод.");
            }
        }
    }

    enum MainMenuItem {
        ADDING("Добавление"),
        SEARCHING("Поиск"),
        SORTED_VIEW("Просмотр в отсортированном виде"),
        EXIT("Выход из программы");

        String description;

        MainMenuItem(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return description;
        }
    }
}
