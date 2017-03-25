package efimovta.store.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;


/**
 * Class contains only one method that represents the "main menu"
 */
public class MainMenu {//todo mb singleton
    final static public BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    final public CreateMenu createMenu = new CreateMenu();
    final public SearchMenu searchMenu = new SearchMenu();

    /**
     * Represents the "main menu"
     *
     * @throws IOException
     */
    public void run() throws IOException {
        List<MainMenuItem> items = Arrays.asList(MainMenuItem.values());
        while (true) {
            System.out.println("\n### Компания \"Horns and hooves and your super device\" ###");
            for (MainMenuItem mmi : MainMenuItem.values()) {
                System.out.println(mmi.ordinal() + 1 + ". " + mmi);
            }

            System.out.println("Выбирете действие:");
            try {
                int otv = Integer.parseInt(br.readLine()) - 1;
                MainMenuItem otvItem = items.get(otv);
                switch (otvItem) {
                    case ADDING:
                        createMenu.startDialog();
                        break;
                    case SEARCHING:
                        searchMenu.startDialog();
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
