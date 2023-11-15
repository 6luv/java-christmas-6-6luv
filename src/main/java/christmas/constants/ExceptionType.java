package christmas.constants;

public enum ExceptionType {
    INVALID_ORDER("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    INVALID_DATE("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_ORDER_QUANTITY("메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다."),
    INVALID_BEVERAGE_ONLY_ORDER("음료만 주문 시, 주문할 수 없습니다.");

    private final String message;

    ExceptionType(String message) {
        this.message = "[ERROR] " + message;
    }

    public String getMessage() {
        return message;
    }
}
