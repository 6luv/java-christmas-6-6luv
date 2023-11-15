package christmas.constants;

public enum EventConstants {
    EVENT_YEAR(2023),
    EVENT_MONTH(12),
    EVENT_START_DATE(1),
    EVENT_END_DATE(31),
    CHRISTMAS_DDAY(25);

    private final int value;

    EventConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
