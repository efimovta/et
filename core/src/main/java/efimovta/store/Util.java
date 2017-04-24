package efimovta.store;

import efimovta.store.entity.CloneReady;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


/**
 * Util class.
 */
public class Util {
    private static final Scanner sc = new Scanner(System.in);

    private Util() {
    }

    /**
     * Print result of {@code object.toString()} on
     * ({@code System.out})<br/>
     * {@link System#out#println()} used.
     *
     * @param o object to print
     */
    public static void println(Object o) {
        System.out.println(o);
    }

    /**
     * Reads a line of text from ({@code System.in}).
     * {@link Scanner#nextLine()} used.
     *
     * @return A String containing the contents of the line.
     */
    public static String readLine() {
        return sc.nextLine();
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
