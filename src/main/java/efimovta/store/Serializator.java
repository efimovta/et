package efimovta.store;

import java.io.*;

/**
 * Created by EFIMOVAT on 03.04.2017.
 */
public class Serializator {
    public static<T extends Serializable> T clone(T o) throws IOException {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(b)) {
            oos.writeObject(o);
        }

        // десериализация в новый список
        T clone = null;
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(b.toByteArray()))) {
            clone = (T) ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();//Unreachable
        }
        return clone;
    }
}
