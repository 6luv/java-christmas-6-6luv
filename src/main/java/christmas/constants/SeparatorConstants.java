package christmas.constants;

public enum SeparatorConstants {
    MENU_ITEM_SEPARATOR(","),
    MENU_QUANTITY_SEPARATOR("-");

    private final String value;

    SeparatorConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
