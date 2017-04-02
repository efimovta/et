package efimovta.store.entity;

import java.util.Date;

/**
 * Created by EFIMOVAT on 11.03.2017.
 */
public class Client implements Identified, Cloneable {
    private static long nextId = 1;
    private final long id = nextId++;

    private String secondName;
    private String name;
    private String middleName;
    private Date birthDay;

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

    @Override
    protected Client clone() {
        Client c = null;
        try {
            c = (Client) super.clone();
        } catch (CloneNotSupportedException e) {
        } // Won't happen
        return c;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

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

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", secondName='" + secondName + '\'' +
                ", name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", birthDay=" + birthDay +
                '}';
    }

    public static class Builder {
        Client tmp = new Client();

        private Builder() {

        }

        public Client build() {
            return tmp.clone();
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
            tmp.birthDay = birthDay;
            return this;
        }
    }
}
