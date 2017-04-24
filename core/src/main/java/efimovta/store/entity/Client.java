package efimovta.store.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Client entity.
 */
public class Client implements Identified, Serializable, CloneReady<Client> {
    private long id;
    private String secondName;
    private String firstName;
    private String middleName;
    private Date birthday;

    /**
     * default constructor
     */
    public Client() {
        //default constructor
    }

    /**
     * Create copy of client. All fields will be copied.
     *
     * @param client to copy
     */
    public Client(Client client) {
        id = client.getId();
        secondName = client.getSecondName();
        firstName = client.getFirstName();
        middleName = client.getMiddleName();
        birthday = client.getBirthday();
    }

    /**
     * @return client id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id id for set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return second firstName of this client
     */
    public String getSecondName() {
        return secondName;
    }

    /**
     * @param secondName second name for set
     */
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    /**
     * @return first firstName of this client
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName first name for set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return middle firstName of this client
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * @param middleName middle name for set
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * @return Full Name of this client
     */
    public String getFIO() {
        return secondName + ' ' + firstName + ' ' + middleName;
    }

    /**
     * @return clone instance of client birthday
     */
    public Date getBirthday() {
        return (Date) birthday.clone();
    }

    /**
     * Set copy of birthday
     *
     * @param birthday birthday for set
     */
    public void setBirthday(Date birthday) {
        this.birthday = (Date) birthday.clone();
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
                    && getFirstName().equals(client.getFirstName())
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
        int result = secondName.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + middleName.hashCode();
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
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    /**
     * Creates and returns a copy of this object.
     * Uses the copy constructor.
     *
     * @return copy of this object
     */
    @Override
    public Client getClone() {
        return new Client(this);
    }
}
