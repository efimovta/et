package efimovta.store.entity;

import java.util.Comparator;

public enum SaleComparator implements Comparator<Sale> {
    BY_ID {
        @Override
        public int compare(Sale o1, Sale o2) {
            return IdentifiedComparator.BY_ID.compare(o1, o2);
        }
    },
    BY_CLIENT_ID {
        @Override
        public int compare(Sale o1, Sale o2) {
            return ClientComparator.BY_ID.compare(o1.getClient(), o2.getClient());
        }
    },
    BY_SALE_DATE {
        @Override
        public int compare(Sale o1, Sale o2) {
            return o1.getSaleDate().compareTo(o2.getSaleDate());
        }
    };
}
