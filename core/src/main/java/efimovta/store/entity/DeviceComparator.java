package efimovta.store.entity;

import java.util.Comparator;

/**
 * Device comparator instances listing
 */
public enum DeviceComparator implements Comparator<Device> {
    BY_ID {
        @Override
        public int compare(Device o1, Device o2) {
            return IdentifiedComparator.BY_ID.compare(o1, o2);
        }
    },
    BY_RELEASE_DATE {
        @Override
        public int compare(Device o1, Device o2) {
            return o1.getReleaseDate().compareTo(o2.getReleaseDate());
        }
    },
    BY_TYPE {
        @Override
        public int compare(Device o1, Device o2) {
            return o1.getType().compareTo(o2.getType());
        }
    },
    BY_BRAND {
        @Override
        public int compare(Device o1, Device o2) {
            return o1.getBrand().compareTo(o2.getBrand());
        }
    },
    BY_MODEL {
        @Override
        public int compare(Device o1, Device o2) {
            return o1.getModel().compareTo(o2.getModel());
        }
    };
}
