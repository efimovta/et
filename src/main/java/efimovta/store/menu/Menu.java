package efimovta.store.menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jcd on 25.03.2017.
 */
public abstract class Menu {
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public BufferedReader getReader() {
        return br;
    }

    public abstract void startDialog() throws IOException;
}
