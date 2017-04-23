package efimovta.store;

import efimovta.store.entity.CloneReady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static efimovta.store.Config.LOGGING_PROPERTIES_LOCATION;


/**
 * Util class.
 */
public class Util {
    public static final Logger log = Logger.getLogger(Main.class.getName());

    public static final BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));

    static {
        try {
            LogManager.getLogManager().readConfiguration(
                    Main.class.getResourceAsStream(LOGGING_PROPERTIES_LOCATION));
        } catch (IOException e) {
            println("Could not setup logger configuration: "
                    + e.toString());
        }
    }

    private Util() {
    }

    /**
     * Print result of {@code object.toString()} on "standard" output
     * stream ({@code System.out})
     *
     * @param o object to print
     */
    public static void println(Object o) {
        System.out.println(o);
    }

    /**
     * Reads a line of text from "standard" input ({@code System.in})
     *
     * @return A String containing the contents of the line.
     * @throws IOException If an I/O error occurs
     * @see #br
     */
    public static String readLine() throws IOException {
        return br.readLine();
    }

    /**
     * Deep copy of list.
     *
     * @param list to copy
     * @param <T>  the type of elements in this list
     * @return deep copy of list
     */
    public static <T extends CloneReady> List<T> deepCopy(List<T> list) {
        List<T> clone = new ArrayList<>(list.size());
        for (T t : list) {
            clone.add((T) t.getClone());
        }
        return clone;
    }

    /**
     * Deep copy of map. Only keys will be subject to deep copying.
     * Uses {@link CloneReady#getClone()} to copy keys.
     *
     * @param map to copy
     * @param <T> - the type of keys maintained by this map
     * @param <W> - the type of mapped values
     * @return deep copy of map
     */
    public static <T extends CloneReady, W> Map<T, W> deepCopy(Map<T, W> map) {
        Map<T, W> clone = new LinkedHashMap<>(map.size());
        for (Map.Entry<T, W> entry : map.entrySet()) {
            clone.put((T) entry.getKey().getClone(), entry.getValue());
        }
        return clone;
    }
}
