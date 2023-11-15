package christmas.constants;

public enum CommonConstants {
    NONE("없음");

    private final String value;

    CommonConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}