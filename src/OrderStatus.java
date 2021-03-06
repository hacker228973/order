import java.util.Objects;

public enum OrderStatus {
    NEW {
        @Override
        public String toString() {
            return "New";
        }

    },
    IN_PROGRESS {
        @Override
        public String toString() {
            return "In Progress";
        }

    },
    FINISHED {
        @Override
        public String toString() {
            return "Finished";
        }

    },
    FAILED {
        @Override
        public String toString() {
            return "Failed";
        }

    };
    public static int getValue(OrderStatus e){
        switch (e){
            case IN_PROGRESS:
                return 2;
            case FINISHED:
                return 3;
            case FAILED:
                return 4;
            default:
                return 1;
        }
    }
    public static String getName(OrderStatus e) {
        return e.toString();
    }

    public static OrderStatus getStatus(String name) {
        for (OrderStatus e : OrderStatus.values()) {
            if (Objects.equals(getName(e), name)) {
                return e;
            }
        }
        return OrderStatus.NEW;
    }




}
