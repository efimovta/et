package efimovta.store.entity;

import efimovta.store.NotAllFieldsAreFilledException;

import java.util.Date;

/**
 * Immutable Client entity. Creation occurs through the builder.
 */
public class Client implements Identified {
    private static long nextId = 1;
    private final long id = nextId++;

    private String secondName;
    private String name;
    private String middleName;
    private Date birthday;

    /**
     * Use the builder to create instances
     *
     * @see Client#getBuilder()
     * @see Builder
     */
    private Client() {

    }

    /**
     * @return a new builder instance
     * @see Builder
     */
    public static Builder getBuilder() {
        return new Builder();
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

    /**
     * Class is used to instantiate clients.<br/> Contains a temporary instance
     * of the client, which is filled with information through the setters.
     * <br/>Creation of new client instances is performed by calling
     * a {@link Builder#build()} method.
     * <br/>One instance of the builder can be used multiple times,
     * the constructed instances are independent
     *
     * @see Client#getBuilder()
     */
    public static class Builder {
        Client tmp = new Client();

        private Builder() {

        }

        /**
         * Verifies that all fields have been filled in and
         * creates a new instance of the client.
         * @return new client instance
         * @throws NotAllFieldsAreFilledException
         */
        public Client build() throws NotAllFieldsAreFilledException {
            checkFields();
            Client newClient = tmp;
            tmp = new Client();
            return newClient;
        }

        public Builder setSecondName(String secondName) {
            tmp.secondName = secondName;
            return this;
        }

        public Builder setName(String name) {
            tmp.name = name;
            return this;
        }

        public Builder setMiddleName(String middleName) {
            tmp.middleName = middleName;
            return this;
        }

        public Builder setBirthDay(Date birthDay) {
            tmp.birthday = (Date) birthDay.clone();
            return this;
        }

        private void checkFields() throws NotAllFieldsAreFilledException {
            if( tmp.middleName == null
                    || tmp.name == null
                    || tmp.secondName == null
                    || tmp.birthday == null){
            throw new NotAllFieldsAreFilledException();}
        }
    }
}
