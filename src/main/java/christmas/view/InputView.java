package christmas.view;

import static christmas.constants.EventConstants.EVENT_MONTH;
import static christmas.constants.SeparatorConstants.MENU_ITEM_SEPARATOR;

import camp.nextstep.edu.missionutils.Console;
import christmas.constants.ExceptionType;
import java.util.function.Supplier;

public class InputView {
    private static final String ORDER_FORMAT_PATTERN = "[가-힣a-zA-Z]+-\\d+";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    public int readDate() {
        System.out.printf("%d월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)" + LINE_SEPARATOR, EVENT_MONTH.getValue());
        String date = Console.readLine();
        validateDate(date);
        return parseInt(date);
    }

    private void validateDate(String date) {
        if (isInputBlank(date)) {
            throw new IllegalArgumentException(ExceptionType.INVALID_DATE.getMessage());
        }
    }

    private boolean isInputBlank(String input) {
        return input.trim().isBlank();
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionType.INVALID_DATE.getMessage());
        }
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
        for (String menu : order.split(MENU_ITEM_SEPARATOR.getValue())) {
            if (!menu.matches(ORDER_FORMAT_PATTERN)) {
                return false;
            }
        }
        return true;
    }

    public <T> T getFromInput(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}