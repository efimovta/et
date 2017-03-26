package efimovta.store.entity;

/**
 * Created by EFIMOVAT on 11.03.2017.
 */
public class ClientView {

    private Client client;

    public ClientView(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    @Override
    public String toString() {
        return toStringWithIndentations(0);
    }


    /**
     * Return structured client information with a specified number of indentations
     *
     * @param num number of indentations
     * @return string with structured client information with a specified number of indentations
     */
    public String toStringWithIndentations(int num) {
        String i = String.format("%" + num + "s", "");
        return i + "Client{" +
                i + "\n\tid=" + client.getId() +
                i + ",\n\tsecondName='" + client.getSecondName() + '\'' +
                i + ",\n\tname='" + client.getName() + '\'' +
                i + ",\n\tmiddleName='" + client.getMiddleName() + '\'' +
                i + ",\n\tbirthDay=" + client.getBirthDay() +
                i + "\n}";
    }
}
