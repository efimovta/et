package efimovta.store.entity;

/**
 * Device types listing
 */
public enum DeviceType {
    PHONE {//todo delete view from
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