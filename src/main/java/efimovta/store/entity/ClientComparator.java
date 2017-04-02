package efimovta.store.entity;

import java.util.Comparator;

/**
 * Client comparator instances listing
 */
public enum ClientComparator implements Comparator<Client> {
    //todo http://stackoverflow.com/questions/1421322/how-do-i-sort-a-list-by-different-parameters-at-different-timed/1421537#1421537
    BY_ID {
        @Override
        public int compare(Client o1, Client o2) {
            return IdentifiedComparator.BY_ID.compare(o1, o2);
        }
    },
    BY_FIO {
        @Override
        public int compare(Client o1, Client o2) {
            return o1.getFIO().compareTo(o2.getFIO());
        }
    },
    BY_SECOND_NAME {
        @Override
        public int compare(Client o1, Client o2) {
            return o1.getSecondName().compareTo(o2.getSecondName());
        }
    },
    BY_NAME {
        @Override
        public int compare(Client o1, Client o2) {
            return o1.getName().compareTo(o2.getName());
        }
    },
    BY_MIDDLE_NAME {
        @Override
        public int compare(Client o1, Client o2) {
            return o1.getMiddleName().compareTo(o2.getMiddleName());
        }
    }
}


