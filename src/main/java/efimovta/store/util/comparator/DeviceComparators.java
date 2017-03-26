package efimovta.store.util.comparator;

import efimovta.store.entity.Device;

import java.util.Comparator;

public enum DeviceComparators implements Comparator<Device> {
     BY_ID {
         @Override
         public int compare(Device o1, Device o2) {
             return IdentifiedeComparators.BY_ID.compare(o1,o2);
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
     };
 }
