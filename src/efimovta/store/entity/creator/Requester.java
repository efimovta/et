package efimovta.store.entity.creator;

import efimovta.store.exception.ExceededAttemptsException;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * Created by jcd on 13.03.2017.
 */
public class Requester {
    final int NUMBER_OF_ATTEMPTS;
    final String ERR_IN_MSG = "Неверный ввод, осталось попыток: ";

    BufferedReader br;

    Requester(BufferedReader br) {
        this(br, 3);
    }

    Requester(BufferedReader br, int numberOfAttempts) {
        NUMBER_OF_ATTEMPTS = numberOfAttempts;
        this.br = br;
    }

    public int requestIntNumber(int start, int end) throws ExceededAttemptsException, IOException {
        int otv = -1;
        for (int i = 1; i <= NUMBER_OF_ATTEMPTS; i++) {
            otv = Integer.parseInt(br.readLine());

            if (start <= otv && otv <= end) break;

            if (i < NUMBER_OF_ATTEMPTS)
                System.err.println(ERR_IN_MSG + (NUMBER_OF_ATTEMPTS - i));
            else throw new ExceededAttemptsException();
        }
        return otv;
    }

    public Date requestDate() throws IOException, ExceededAttemptsException {
        Date date = null;
        for (int i = 1; i <= NUMBER_OF_ATTEMPTS; i++) {
            String strDate = br.readLine();
            try {
                date = DateFormat.getDateInstance().parse(strDate);
                break;
            } catch (ParseException e) {
                if (i < NUMBER_OF_ATTEMPTS)
                    System.err.println(ERR_IN_MSG + (NUMBER_OF_ATTEMPTS - i));
                else throw new ExceededAttemptsException();
            }
        }
        return date;
    }
}
