package efimovta.store.entity;

import java.util.Date;

/**
 * Created by EFIMOVAT on 11.03.2017.
 */
public class Client {
    private static int nextId = 1;
    private final int id = nextId++;
    public int getId() {
        return id;
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

    public Client(String secondName, String name, String middleName, Date birthDay) {
        this.secondName = secondName;
        this.name = name;
        this.middleName = middleName;
        this.birthDay = birthDay;
    }


    public static int getNextId() {
        return nextId;
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
        return secondName+' '+name+' '+middleName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    String secondName;
    String name;
    String middleName;
    Date birthDay;
}
