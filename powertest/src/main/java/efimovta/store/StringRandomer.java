package efimovta.store;

import java.util.Random;

/**
 * Random string generator
 */
public class StringRandomer {
    private static final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static final int STR_LENGTH = 9; // длина генерируемой строки
    Random random = new Random();

    public String createRandomString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < STR_LENGTH; i++) {
            int number = random.nextInt(CHARS.length());
            char ch = CHARS.charAt(number);
            builder.append(ch);
        }
        return builder.toString();
    }

    public String get() {
        return createRandomString();
    }
}
