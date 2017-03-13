package efimovta.store;

import efimovta.store.entity.creator.Creator;
import efimovta.store.finder.Finder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {
    final public BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    final public Creator creator = new Creator(br);
    final public Finder finder = new Finder(br, creator);

    public static void main(String[] args) throws IOException {
        Console console = new Console();
        console.run();
    }

    private void run() throws IOException {
        while (true) {
            System.out.println("\n### Компания \"Horns and hooves and your super device\" ###");
            System.out.println("1. Добавление");
            System.out.println("2. Поиск");
            System.out.println("3. Выход из программы");
            System.out.println("Выбирете действие:");

            int otv = Integer.parseInt(br.readLine());

            switch (otv) {
                case 1:
                    creator.startDialog();
                    break;
                case 2:
                    finder.startDialog();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Неверный ввод.");
            }
        }
    }
}
