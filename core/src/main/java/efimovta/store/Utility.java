package efimovta.store;

import efimovta.store.entity.CloneReady;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static efimovta.store.Constants.br;

/**
 * Created by EFIMOVAT on 09.04.2017.
 */
public class Utility {
    public static void println(Object o) {
        System.out.println(o);
    }

    public static void printErr(Object o) {
        System.err.println(o);
    }

    public static String readLine() throws IOException {
        return br.readLine();
    }

    public static <T extends CloneReady> List<T> deepCopy(List<T> list) {
        List<T> clone = new ArrayList<>(list.size());
        for (T t : list) {
            clone.add((T) t.getClone());
        }
        return clone;
    }

    public static <T extends CloneReady, W> Map<T, W> deepCopy(Map<T, W> map) {
        Map<T, W> clone = new LinkedHashMap<>(map.size());
        for (Map.Entry<T, W> entry : map.entrySet()) {
            clone.put((T) entry.getKey().getClone(), entry.getValue());
        }
        return clone;
    }
}
