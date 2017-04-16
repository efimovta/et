package efimovta.store.menu.requester;

import efimovta.store.Utility;
import efimovta.store.menu.OperationCanceledByUserException;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * Created by jcd on 25.03.2017.
 */
public class Requester {
    private static Requester ourInstance = new Requester();

    public static Requester getInstance() {
        return ourInstance;
    }

    protected Requester() {

    }

    public static final String EXIT_SYMBOL = "q";
    public static final String INPUT_ERROR_MSG =
            ("Неверный ввод. Повторите. Для выхода введите \""+EXIT_SYMBOL +"\".");


    public  int requestIntNumber(int start, int end) throws OperationCanceledByUserException, IOException {
        int otv = -1;
        while (true) {
            String str = Utility.readLine();
            if (str.equals(EXIT_SYMBOL)) throw new OperationCanceledByUserException();

            otv = Integer.parseInt(str);

            if (start <= otv && otv <= end) break;
            else Utility.printErr(INPUT_ERROR_MSG);
        }
        return otv;
    }

    public  Date requestDate() throws IOException, OperationCanceledByUserException {
        Date date = null;
        while (true) {
            String str = Utility.readLine();
            if (str.equals(EXIT_SYMBOL)) throw new OperationCanceledByUserException();

            try {
                date = DateFormat.getDateInstance().parse(str);
                break;
            } catch (ParseException e) {
                Utility.printErr(INPUT_ERROR_MSG);
            }
        }
        return date;
    }
}
