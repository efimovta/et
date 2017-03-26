package efimovta.store.util.comparator;

import efimovta.store.entity.Identified;

import java.util.Comparator;

public enum IdentifiedeComparators implements Comparator<Identified> {
        BY_ID {
            @Override
            public int compare(Identified o1, Identified o2) {
                return 0;
            }
        }
    }
