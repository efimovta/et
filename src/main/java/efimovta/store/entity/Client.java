package efimovta.store.entity;

import java.util.Date;

/**
 * Created by EFIMOVAT on 11.03.2017.
 */
public class Client implements Identified {
    private static long nextId = 1;
    private final long id = nextId++;

    private String secondName;
    private String name;
    private String middleName;
    private Date birthDay;

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
                    && getBirthDay().equals(client.getBirthDay())) {
                otv = true;
            }
        }
        return otv;
    }

    @Override
    public int hashCode() {
        int result = getSecondName().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getMiddleName().hashCode();
        result = 31 * result + getBirthDay().hashCode();
        return result;
    }

    private Client() {

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
