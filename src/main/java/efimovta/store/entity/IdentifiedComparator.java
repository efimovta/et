package efimovta.store.entity;

import java.util.Comparator;

public enum IdentifiedComparator implements Comparator<Identified> {
        BY_ID {
            @Override
            public int compare(Identified o1, Identified o2) {
                return (int)(o1.getId()-o2.getId());
            }
        }
    }
