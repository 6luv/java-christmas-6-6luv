package christmas.constants;

public enum OrderConstants {
    MIN_QUANTITY(1),
    MAX_QUANTITY(20);

    private final int value;

    OrderConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
