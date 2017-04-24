package efimovta.store.entity;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by EFIMOVAT on 26.03.2017.
 */
public class ClientTest {

    static Client client;
    static Client client2;
    static int id1 = 1;
    static int id2 = 2;
    static String secondName = "Васильев";
    static String name = "Вася";
    static String middleName = "Васильевич";
    static Date birthDay = new Date();


    @BeforeClass
    public static void setUp() throws Exception {

        client = new Client();
        client.setId(id1);      //different id
        client.setSecondName(secondName);
        client.setFirstName(name);
        client.setMiddleName(middleName);
        client.setBirthday(birthDay);
        assertNotNull(client);

        client2 = new Client();
        client2.setId(id2);
        client2.setSecondName(secondName);
        client2.setFirstName(name);
        client2.setMiddleName(middleName);
        client2.setBirthday(birthDay);
        assertNotNull(client2);
    }


    @Test
    public void clientEquals() throws Exception {
        assertTrue(client.equals(client2));

    }

    @Test
    public void clientHashCode() throws Exception {
        assertTrue(client.hashCode() == client2.hashCode());
    }

    @Test
    public void getId() throws Exception {
        assertTrue(client.getId() == id1);
    }

    @Test
    public void getSecondName() throws Exception {
        assertEquals(client.getSecondName(), secondName);
    }

    @Test
    public void getName() throws Exception {
        assertEquals(client.getFirstName(), name);

    }

    @Test
    public void getMiddleName() throws Exception {
        assertEquals(client.getMiddleName(), middleName);

    }

    @Test
    public void getBirthDay() throws Exception {
        assertEquals(client.getBirthday(), birthDay);
    }

    @Test
    public void clientToString() throws Exception {
        assertNotNull(client.toString());
    }

}