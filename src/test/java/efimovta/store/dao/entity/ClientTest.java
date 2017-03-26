package efimovta.store.dao.entity;

import org.junit.BeforeClass;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;

import static org.junit.Assert.assertEquals;

/**
 * Created by jcd on 26.03.2017.
 */
public class ClientTest {



    Client client = Client.getBuilder()
            .setSecondName("Васильев")
            .setName("Вася")
            .setMiddleName("Васильевич")
            .setBirthDay(DateFormat.getDateInstance().parse("11.11.1994"))
            .build();

    public ClientTest() throws ParseException {
    }

    @BeforeClass
    public static void name() throws Exception {

    }

    @Test
    public void clientToString() throws Exception {
        assertEquals(client.getSecondName(),"Васильев");

    }

    @Test
    public void toStringWithOneTab() throws Exception {

    }

    @Test
    public void getId() throws Exception {

    }

    @Test
    public void getSecondName() throws Exception {

    }

    @Test
    public void getName() throws Exception {

    }

    @Test
    public void getMiddleName() throws Exception {

    }

    @Test
    public void getFIO() throws Exception {

    }

    @Test
    public void getBirthDay() throws Exception {

    }

    @Test
    public void getBuilder() throws Exception {

    }

}