package efimovta.store.dao.entity;

import java.util.Date;

/**
 * Created by EFIMOVAT on 11.03.2017.
 */
public class Client implements Identified {//TODO builder(or not?)
    private static long nextId = 1;
    private final long id = nextId++;

    private String secondName;
    private String name;
    private String middleName;
    private Date birthDay;


    private Client() {

    }

    @Override
    public String toString() {
        return "Client{" +
                "\n\tid=" + id +
                ",\n\tsecondName='" + secondName + '\'' +
                ",\n\tname='" + name + '\'' +
                ",\n\tmiddleName='" + middleName + '\'' +
                ",\n\tbirthDay=" + birthDay +
                "\n}";
    }

    public String toStringWithOneTab() {//TODO delete view piece from model
        return "\tClient{" +
                "\n\t\tid=" + id +
                ",\n\t\tsecondName='" + secondName + '\'' +
                ",\n\t\tname='" + name + '\'' +
                ",\n\t\tmiddleName='" + middleName + '\'' +
                ",\n\t\tbirthDay=" + birthDay +
                "\n\t}";
    }

    public long getId() {
        return id;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getFIO() {
        return secondName + ' ' + name + ' ' + middleName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public static Builder getBuilder() {
        return new Client().new Builder();
    }

    public class Builder {
        private Builder() {

        }

        public Client build() {
            return Client.this;
        }

        public Builder setSecondName(String secondName) {
            Client.this.secondName = secondName;
            return this;
        }

        public Builder setName(String name) {
            Client.this.name = name;
            return this;
        }

        public Builder setMiddleName(String middleName) {
            Client.this.middleName = middleName;
            return this;
        }

        public Builder setBirthDay(Date birthDay) {
            Client.this.birthDay = birthDay;
            return this;
        }
    }
}
