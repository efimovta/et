package efimovta.store.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Immutable Client entity. Creation occurs through the builder.
 */
public class Client implements Identified, Serializable {
    private static long nextId = 1;
    private final long id;

    private String secondName;
    private String name;
    private String middleName;
    private Date birthday;

    public Client() {
        id = nextId++;
    }

    public Client(Client client) {
        id = client.getId();
        secondName = client.getSecondName();
        name = client.getName();
        middleName = client.getMiddleName();
        birthday = client.getBirthday();
    }

    /**
     * Return unique identifier of this client.
     * For first instance it is 1.
     *
     * @return Unique identifier of this client
     */
    public long getId() {
        return id;
    }

    /**
     * @return second name of this client
     */
    public String getSecondName() {
        return secondName;
    }

    /**
     * @return first name of this client
     */
    public String getName() {
        return name;
    }

    /**
     * @return middle name of this client
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * @return Full Name of this client
     */
    public String getFIO() {
        return secondName + ' ' + name + ' ' + middleName;
    }

    /**
     * @return clone instance of client birthday
     */
    public Date getBirthday() {
        return (Date) birthday.clone();
    }

    public Client setSecondName(String secondName) {
        this.secondName = secondName;
        return this;
    }

    public Client setName(String name) {
        this.name = name;
        return this;
    }

    public Client setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public Client setBirthday(Date birthday) {
        this.birthday = (Date) birthday.clone();
        return this;
    }

    /**
     * Compares this client to the specified object.
     * The identifier is not taken into comparing.
     *
     * @param o The object to compare this Client against
     * @return true if the given object represents a Client equivalent
     * to this client, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        boolean otv = false;

        if (this == o) {
            otv = true;
        } else if (o != null && getClass() == o.getClass()) {
            Client client = (Client) o;
            if (getSecondName().equals(client.getSecondName())
                    && getName().equals(client.getName())
                    && getMiddleName().equals(client.getMiddleName())
                    && getBirthday().equals(client.getBirthday())) {
                otv = true;
            }
        }
        return otv;
    }

    /**
     * Returns a hash code for this client.
     * The identifier is not taken into calculation.
     *
     * @return a hash code for this client.
     */
    @Override
    public int hashCode() {
        int result = getSecondName().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getMiddleName().hashCode();
        result = 31 * result + getBirthday().hashCode();
        return result;
    }

    /**
     * @return a string representation of the client.
     */
    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", secondName='" + secondName + '\'' +
                ", name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
