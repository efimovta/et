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


    public Client(String secondName, String name, String middleName, Date birthDay) {
        this.secondName = secondName;
        this.name = name;
        this.middleName = middleName;
        this.birthDay = birthDay;
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
}
