package efimovta.store.dao.impl.sim.wrapper;

import java.util.Date;

/**
 * Created by EFIMOVAT on 02.04.2017.
 */
public class Client {
    private static long nextId = 1;
    private final long id = nextId++;

    private String secondName;
    private String name;
    private String middleName;
    private Date birthday;
}
