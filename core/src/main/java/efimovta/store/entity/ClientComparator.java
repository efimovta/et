package efimovta.store.entity;

import java.util.Comparator;

/**
 * Client comparator instances listing
 */
public enum ClientComparator implements Comparator<Client> {
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
            return o1.getFirstName().compareTo(o2.getFirstName());
        }
    },
    BY_MIDDLE_NAME {
        @Override
        public int compare(Client o1, Client o2) {
            return o1.getMiddleName().compareTo(o2.getMiddleName());
        }
    },
    BY_BIRTHDAY {
        @Override
        public int compare(Client o1, Client o2) {
            return o1.getBirthday().compareTo(o2.getBirthday());
        }
    }
}


