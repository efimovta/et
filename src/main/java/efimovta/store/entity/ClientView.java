package efimovta.store.entity;

/**
 * Created by EFIMOVAT on 11.03.2017.
 */
public class ClientView {

    /**
     * Return structured client information
     *
     * @param client client to view
     * @return
     */
    public static String toString(Client client) {
        return toStringWithIndentations(0, client);
    }

    /**
     * Return structured client information with a specified number of indentations
     *
     * @param num    number of indentations
     * @param client client to view
     * @return
     */
    public static String toStringWithIndentations(int num, Client client) {
        String i;
        if (num == 0) {
            i = "";
        } else {
            i = String.format("%" + num + "s", "");
        }
        return i + "Client{\n" +
                i + "\tid=" + client.getId() + ",\n" +
                i + "\tsecondName=" + client.getSecondName() + ",\n" +
                i + "\tname=" + client.getName() + ",\n" +
                i + "\tmiddleName=" + client.getMiddleName() + ",\n" +
                i + "\tbirthDay=" + client.getBirthDay() + "\n" +
                i + "}";
    }
}
