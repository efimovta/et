package efimovta.store.dao.entity.enums;

/**
 * Created by EFIMOVAT on 11.03.2017.
 */
public enum DeviceType {
    PHONE {
        @Override
        public String toString() {
            return "Телефон";
        }
    },
    PLAYER {
        @Override
        public String toString() {
            return "Плеер";
        }
    },
    LAPTOP {
        @Override
        public String toString() {
            return "Ноутбук";
        }
    },
    TAB {
        @Override
        public String toString() {
            return "Планшет";
        }
    }
}