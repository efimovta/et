package efimovta.store.util.comparator;

import efimovta.store.entity.Client;

import java.util.Comparator;

/**
 * Created by EFIMOVAT on 26.03.2017.
 */


    public enum ClientComparators implements Comparator<Client>{
        BY_ID{
            @Override
            public int compare(Client o1, Client o2) {
                return IdentifiedeComparators.BY_ID.compare(o1,o2);
            }
        },
        BY_FIO{
            @Override
            public int compare(Client o1, Client o2) {
                return o1.getFIO().compareTo(o2.getFIO());
            }
        },
        BY_SECOND_NAME{
            @Override
            public int compare(Client o1, Client o2) {
                return o1.getSecondName().compareTo(o2.getSecondName());
            }
        },
        BY_NAME{
            @Override
            public int compare(Client o1, Client o2) {
                return o1.getName().compareTo(o2.getName());
            }
        },
        BY_MIDDLE_NAME{
            @Override
            public int compare(Client o1, Client o2) {
                return o1.getMiddleName().compareTo(o2.getMiddleName());
            }
        }
    }


