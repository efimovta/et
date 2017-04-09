package efimovta.store;

import java.io.IOException;

import static efimovta.store.Constants.br;

/**
 * Created by EFIMOVAT on 09.04.2017.
 */
public class Utility {
    public static void println(Object o){
        System.out.println(o);
    }
    public static void printErr(Object o){
        System.err.println(o);
    }
    public static String readLine() throws IOException {
        return br.readLine();
    }
}
