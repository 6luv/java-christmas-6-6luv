package christmas.view;

import static christmas.constants.Constants.EVENT_MONTH;
import static christmas.constants.Constants.MENU_ITEM_SEPARATOR;

import camp.nextstep.edu.missionutils.Console;
import christmas.constants.ExceptionType;

public class InputView {
    private static final String ORDER_FORMAT_PATTERN = "[가-힣a-zA-Z]+-\\d+";
    private static final String DATE_NUMERIC_PATTERN = "^[0-9]+$";

    public int readDate() {
        System.out.printf("%d월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)\n", EVENT_MONTH);
        String date = Console.readLine();
        validateDate(date);
        return Integer.parseInt(date);
    }

    private void validateDate(String date) {
        if (isInputBlank(date)) {
            throw new IllegalArgumentException(ExceptionType.INVALID_DATE.getMessage());
        }
        if (!isDateNumeric(date)) {
            throw new IllegalArgumentException(ExceptionType.INVALID_DATE.getMessage());
        }
    }

    private boolean isInputBlank(String input) {
        return input.trim().isBlank();
    }

    private boolean isDateNumeric(String date) {
        return date.matches(DATE_NUMERIC_PATTERN);
    }

    public String readOrder() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        String order = Console.readLine();
        validateOrder(order);
        return order;
    }

    private void validateOrder(String order) {
        if (isInputBlank(order)) {
            throw new IllegalArgumentException(ExceptionType.INVALID_ORDER.getMessage());
        }
        if (!isValidOrderFormat(order)) {
            throw new IllegalArgumentException(ExceptionType.INVALID_ORDER.getMessage());
        }
    }

    private boolean isValidOrderFormat(String order) {
        for (String menu : order.split(MENU_ITEM_SEPARATOR)) {
            if (!menu.matches(ORDER_FORMAT_PATTERN)) {
                return false;
            }
        }
        return true;
    }
}
