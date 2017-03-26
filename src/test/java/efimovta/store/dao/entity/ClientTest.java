package efimovta.store.dao.entity;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by EFIMOVAT on 26.03.2017.
 */
public class ClientTest {

    static Client client;
    static Client client2;
    static String secondName = "Васильев";
    static String name = "Вася";
    static String middleName = "Васильевич";
    static Date birthDay = new Date();


    @BeforeClass
    public static void setUp() throws Exception {
        Client.Builder clientBuilder = Client.getBuilder();
        assertNotNull(clientBuilder);

        client = clientBuilder
                .setSecondName(secondName)
                .setName(name)
                .setMiddleName(middleName)
                .setBirthDay(birthDay)
                .build();
        assertNotNull(client);

        //client2.id != client.id
        client2 = clientBuilder
                .setSecondName(secondName)
                .setName(name)
                .setMiddleName(middleName)
                .setBirthDay(birthDay)
                .build();
        assertNotNull(client2);
    }


    @Test
    public void clientEquals() throws Exception {
        assertTrue(client.equals(client2));

    }

    @Test
    public void clientHashCode() throws Exception {
        assertTrue(client.hashCode()==client2.hashCode());
    }

    @Test
    public void getId() throws Exception {
        assertNotNull(client.getId());
        assertTrue(client.getId()>0);
    }

    @Test
    public void getSecondName() throws Exception {
        assertEquals(client.getSecondName(), secondName);
    }

    @Test
    public void getName() throws Exception {
        assertEquals(client.getName(), name);

    }

    @Test
    public void getMiddleName() throws Exception {
        assertEquals(client.getMiddleName(), middleName);

    }

    @Test
    public void getBirthDay() throws Exception {
        assertEquals(client.getBirthDay(), birthDay);
    }

    @Test
    public void clientToString() throws Exception {
        assertNotNull(client.toString());
    }

}