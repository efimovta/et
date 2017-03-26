package efimovta.store.dao.impl.sim;

import efimovta.store.dao.entity.Client;
import efimovta.store.dao.exeption.RecordNotFoundException;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by EFIMOVAT on 26.03.2017.
 */
public class SIMClientDAOTest {
    static SIMClientDAO simClientDAO;
    static Client client;
    static Client client2;
    static ArrayList<Client> source;

    @BeforeClass
    public static void setUp() throws Exception {
        client = Client.getBuilder()
                .setSecondName("Васильев")
                .setName("Вася")
                .setMiddleName("Васильевич")
                .setBirthDay(DateFormat.getDateInstance().parse("11.11.1994"))
                .build();

        client2 = Client.getBuilder()
                .setSecondName("Васильев2")
                .setName("Вася2")
                .setMiddleName("Васильевич2")
                .setBirthDay(DateFormat.getDateInstance().parse("22.22.2994"))
                .build();

        source = new ArrayList<>();
        source.add(client);
        source.add(client2);

        simClientDAO = new SIMClientDAO(source);
    }

    @Test
    public void findByFIO() throws Exception {
        List<Client> list = simClientDAO.findByFIO("Васильев Вася Васильевич");
        assertTrue(list.size()==1);
        assertEquals(list.get(0),client);

        List<Client> list2 = simClientDAO.findByFIO("Васильев2 Вася2 Васильевич2");
        assertTrue(list2.size()==1);
        assertEquals(list2.get(0),client2);
    }

    @Test(expected = RecordNotFoundException.class)
    public void findByFIOFail() throws Exception {
        List<Client> list = simClientDAO.findByFIO("Васильев Вася");
    }

}