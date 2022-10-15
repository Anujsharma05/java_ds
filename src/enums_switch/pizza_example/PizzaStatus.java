package enums_switch.pizza_example;

public enum PizzaStatus {
    ORDERED(5) {

        int testVal;

        @Override
        public boolean isOrdered() {
            return true;
        }
    },
    READY(2),
    DELIVERED(0);

    private int timeToDelivery;

    PizzaStatus(int timeToDelivery) {
        this.timeToDelivery = timeToDelivery;
    }
    public boolean isOrdered() {
        return false;
    }
}
