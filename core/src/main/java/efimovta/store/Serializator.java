package efimovta.store;

import java.io.*;

/**
 * It contains the only method that clones an object through serialization
 */
public class Serializator {
    /**
     * Clones an object using serialization
     * @param o - object to clone
     * @param <T> - type of cloning object
     * @return clone of object
     * @throws IOException - problem with Serialization
     */
    public static<T extends Serializable> T serialize(T o) throws IOException {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(b)) {
            oos.writeObject(o);
        }

        T clone = null;
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(b.toByteArray()))) {
            clone = (T) ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();//Unreachable
        }
        return clone;
    }
}
