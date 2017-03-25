package efimovta.store.menu.creator;

import efimovta.store.menu.MainMenu;
import efimovta.store.menu.exception.OperationCanceledByUserException;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * Created by jcd on 13.03.2017.
 */
public class Creator {
    final static String EXIT_SYMBOL = "q";
    final static String INPUT_ERROR_MSG = "Неверный ввод. Повторите. Для выхода введите \""+EXIT_SYMBOL+"\".";

    final static BufferedReader br = MainMenu.br;


    public static int requestIntNumber(int start, int end) throws OperationCanceledByUserException, IOException {
        int otv = -1;
        while (true) {
            String str = br.readLine();
            if(str.equals(EXIT_SYMBOL))throw new OperationCanceledByUserException();

            otv = Integer.parseInt(str);

            if (start <= otv && otv <= end) break;
            else System.err.println(INPUT_ERROR_MSG);
        }
        return otv;
    }

    public static Date requestDate() throws IOException, OperationCanceledByUserException {
        Date date = null;
        while (true) {
            String str = br.readLine();
            if(str.equals(EXIT_SYMBOL))throw new OperationCanceledByUserException();

            try {
                date = DateFormat.getDateInstance().parse(str);
                break;
            } catch (ParseException e) {
                System.err.println(INPUT_ERROR_MSG);
            }
        }
        return date;
    }
}
