package efimovta.store;

import efimovta.store.entity.creator.CreateMenu;
import efimovta.store.finder.Finder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Class contains only one method that represents the "main menu"
 */
public class Console {
    private static final int ADDING = 1;
    private static final int SEARCHING = 2;
    private static final int EXIT = 3;

    final public BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final public CreateMenu createMenu = new CreateMenu(br);
    final public Finder finder = new Finder(br, createMenu);

    /**
     * Represents the "main menu"
     * @throws IOException
     */
    public void run() throws IOException {
        while (true) {
            System.out.println("\n### Компания \"Horns and hooves and your super device\" ###");
            System.out.println("1. Добавление");
            System.out.println("2. Поиск");
            System.out.println("3. Выход из программы");
            System.out.println("Выбирете действие:");

            int otv = Integer.parseInt(br.readLine());

            switch (otv) {
                case ADDING:
                    createMenu.startDialog();
                    break;
                case SEARCHING:
                    finder.startDialog();
                    break;
                case EXIT:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Неверный ввод.");
            }
        }
    }
}
