package efimovta.store.requester;

import efimovta.store.OperationCanceledByUserException;
import efimovta.store.Util;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * Base class for request methods. Singleton.
 */
public class Requester {
    public static final String EXIT_SYMBOL = "q";
    public static final String INPUT_ERROR_MSG =
            "Неверный ввод. Повторите. Для выхода введите \""
                    + EXIT_SYMBOL + "\".";
    private static Requester ourInstance = new Requester();

    protected Requester() {

    }

    /**
     * @return Singleton {@link Requester}
     */
    public static Requester getInstance() {
        return ourInstance;
    }

    /**
     * Request int number with a given range of allowed values.
     *
     * @param start start of range
     * @param end   end of range
     * @return requested int number
     * @throws OperationCanceledByUserException if user type
     *                                          {@link #EXIT_SYMBOL}
     */
    public int requestIntNumber(int start, int end)
            throws OperationCanceledByUserException {
        int otv = -1;
        while (start > otv || otv > end) {
            String str = Util.readLine();
            if (str.equals(EXIT_SYMBOL)) {
                throw new OperationCanceledByUserException();
            }

            try {
                otv = Integer.parseInt(str);

                if (start > otv || otv > end) {
                    Util.println(INPUT_ERROR_MSG);
                }
            } catch (NumberFormatException e) {
                Util.println(INPUT_ERROR_MSG);
            }
        }
        return otv;
    }

    /**
     * Request date
     *
     * @return requested date
     * @throws OperationCanceledByUserException if user type
     *                                          {@link #EXIT_SYMBOL}
     */
    public Date requestDate() throws OperationCanceledByUserException {
        Date date;
        while (true) {
            String str = Util.readLine();
            if (str.equals(EXIT_SYMBOL)) {
                throw new OperationCanceledByUserException();
            }

            try {
                date = DateFormat.getDateInstance().parse(str);
                break;
            } catch (ParseException e) {
                Util.println(INPUT_ERROR_MSG);
            }
        }
        return date;
    }
}
