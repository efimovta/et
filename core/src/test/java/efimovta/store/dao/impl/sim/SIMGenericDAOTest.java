package efimovta.store.dao.impl.sim;

import efimovta.store.entity.Client;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by EFIMOVAT on 26.03.2017.
 */
public class SIMGenericDAOTest {
    static SIMGenericDAO<Client> SIMGenericDAO;
    static Client client;
    static Client client2;
    static ArrayList<Client> source;

    @BeforeClass
    public static void setUp() throws Exception {
        client = new Client()
                .setSecondName("Васильев")
                .setFirtsName("Вася")
                .setMiddleName("Васильевич")
                .setBirthday(DateFormat.getDateInstance().parse("11.11.1994"))
                ;

        client2 = new Client()
                .setSecondName("Васильев2")
                .setFirtsName("Вася2")
                .setMiddleName("Васильевич2")
                .setBirthday(DateFormat.getDateInstance().parse("22.22.2994"))
                ;

        source = new ArrayList<>();
        source.add(client);
        source.add(client2);

        SIMGenericDAO = new SIMClientDAO(source);
    }

    @Test
    public void add() throws Exception {
        Client client3 = new Client()
                .setSecondName("Васильев3")
                .setFirtsName("Вася3")
                .setMiddleName("Васильевич3")
                .setBirthday(DateFormat.getDateInstance().parse("33.33.3994"))
                ;
        SIMGenericDAO.add(client3);

        assertTrue(source.contains(client3));
    }

    @Test
    public void findById() throws Exception {
        Client c = SIMGenericDAO.findById(client.getId());
        assertEquals(c,client);

        Client c2 = SIMGenericDAO.findById(client2.getId());
        assertEquals(c2,client2);

    }

    @Test
    public void getAll() throws Exception {
        List<Client> list = SIMGenericDAO.getAll();
        assertTrue(list.size()>0);
        assertTrue(list.contains(client));
        assertTrue(list.contains(client2));
    }

}