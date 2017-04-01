package efimovta.store.entity;

import java.util.Map;

/**
 * The class contains overloaded methods for displaying
 * device, client and sale entities in a structured form
 * with spaces on the left
 */
public class Viewer {

    /**
     * Return structured client information
     *
     * @param client client to view
     * @return structured client information
     * @see Viewer#toStringWithLeftSpaces(int, Client)
     */
    public static String toString(Client client) {
        return toStringWithLeftSpaces(0, client);
    }

    /**
     * Return structured device information
     *
     * @param device client to view
     * @return structured device information
     * @see Viewer#toStringWithLeftSpaces(int, Device)
     */
    public static String toString(Device device) {
        return toStringWithLeftSpaces(0, device);
    }

    /**
     * Return structured sale information
     *
     * @param sale client to view
     * @return structured sale information
     * @see Viewer#toStringWithLeftSpaces(int, Sale)
     */
    public static String toString(Sale sale) {
        return toStringWithLeftSpaces(0, sale);
    }

    /**
     * Return structured client information with a specified number
     * of left spaces
     *
     * @param num number of left spaces
     * @param c   client to view
     * @return structured client information with a specified number
     * of left spaces
     */
    public static String toStringWithLeftSpaces(int num, Client c) {
        String spaces = getSpaces(num);
        StringBuilder sb = new StringBuilder()
                .append(spaces)
                .append("Client{\n")
                .append(spaces)
                .append("\tid=").append(c.getId()).append(",\n")
                .append(spaces)
                .append("\tsecondName=").append(c.getSecondName()).append(",\n")
                .append(spaces)
                .append("\tname=").append(c.getName()).append(",\n")
                .append(spaces)
                .append("\tmiddleName=").append(c.getMiddleName()).append(",\n")
                .append(spaces)
                .append("\tbirthDay=").append(c.getBirthDay()).append("\n")
                .append(spaces)
                .append("}");
        return sb.toString();
    }

    /**
     * Return structured device information with a specified number of
     * left spaces
     *
     * @param num number of left spaces
     * @param d   client to view
     * @return structured device information string with a specified number of
     * left spaces
     */
    public static String toStringWithLeftSpaces(int num, Device d) {
        String spaces = getSpaces(num);
        StringBuilder sb = new StringBuilder()
                .append(spaces)
                .append("Device{\n")
                .append(spaces)
                .append("\tid=").append(d.getId()).append(",\n")
                .append(spaces)
                .append("\tmodel=").append(d.getModel()).append(",\n")
                .append(spaces)
                .append("\ttype=").append(d.getType()).append(",\n")
                .append(spaces)
                .append("\tbrand=").append(d.getBrand()).append(",\n")
                .append(spaces)
                .append("\tcolor=").append(d.getColor()).append(",\n")
                .append(spaces)
                .append("\treleaseDate=").append(d.getReleaseDate())
                .append(",\n")
                .append(spaces)
                .append("\tprice=").append(d.getPrice()).append("\n")
                .append(spaces)
                .append("}");
        return sb.toString();
    }

    /**
     * Return structured sale information with a specified number of
     * left spaces
     *
     * @param num number of left spaces
     * @param s   client to view
     * @return structured sale information with a specified number of
     * left spaces
     */
    public static String toStringWithLeftSpaces(int num, Sale s) {
        String spaces = getSpaces(num);
        int innerSpacesNum = num + 10;
        StringBuilder sb = new StringBuilder()
                .append(spaces).append("Sale{\n")
                .append(spaces).append("\tid=").append(s.getId()).append(",\n")
                .append(spaces).append("\tsaleDate=").append(s.getSaleDate())
                .append(",\n")
                .append(spaces).append("\tclient=\n")
                .append(toStringWithLeftSpaces(innerSpacesNum, s.getClient()))
                .append(",\n")
                .append(spaces).append("\tdevices=\n");


        for (Map.Entry<Device, Integer> entry : s.getDevices().entrySet()) {
            sb
                    .append(toStringWithLeftSpaces(innerSpacesNum, entry.getKey()))
                    .append("---Number of this devices: ").append(entry.getValue())
                    .append('\n');
        }

        sb.append("\n}");
        return sb.toString();
    }

    public static String getSpaces(int num) {
        String spaces;
        if (num == 0) {
            spaces = "";
        } else {
            spaces = String.format("%" + num + "s", "");
        }
        return spaces;
    }

}
