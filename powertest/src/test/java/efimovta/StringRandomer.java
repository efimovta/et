package efimovta;

import java.util.Random;

/**
 * Created by EFIMOVAT on 16.04.2017.
 */
public class StringRandomer {
    private static final String mCHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static final int STR_LENGTH = 9; // длина генерируемой строки
    Random random = new Random();

    public String createRandomString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < STR_LENGTH; i++) {
            int number = random.nextInt(mCHAR.length());
            char ch = mCHAR.charAt(number);
            builder.append(ch);
        }
        return builder.toString();
    }

    public String get() {
        return createRandomString();
    }
}
