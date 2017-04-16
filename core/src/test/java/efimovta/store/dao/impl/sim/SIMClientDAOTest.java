package efimovta.store.dao.impl.sim;

import efimovta.store.entity.Client;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.DateFormat;
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

    @BeforeClass
    public static void setUp() throws Exception {
        simClientDAO = new SIMClientDAO();

        client = new Client()
                .setSecondName("Васильев")
                .setFirtsName("Вася")
                .setMiddleName("Васильевич")
                .setBirthday(DateFormat.getDateInstance().parse("11.11.1994"));

        client2 = new Client()
                .setSecondName("Васильев2")
                .setFirtsName("Вася2")
                .setMiddleName("Васильевич2")
                .setBirthday(DateFormat.getDateInstance().parse("22.22.2994"));

        simClientDAO.add(client);
        simClientDAO.add(client2);

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

    public void findByFIOFail() throws Exception {
        List<Client> list = simClientDAO.findByFIO("Васильев Вася");
        assertTrue(list.isEmpty());

    }

}