package christmas.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String ORDER_PATTERN = "[가-힣a-zA-Z]+-\\d+";

    public int readDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String input = Console.readLine();
        validateBlank(input);
        validateNumeric(input);
        return Integer.parseInt(input);
    }

    public String readOrder() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        String input = Console.readLine();
        validateBlank(input);
        validateOrderFormat(input);
        return input;
    }

    private void validateBlank(String input) {
        if (input.trim().isBlank()) {
            throw new IllegalArgumentException("[ERROR] 공백은 입력할 수 없습니다.");
        }
    }

    private void validateOrderFormat(String input) {
        for (String menu : input.split(",")) {
            if (!menu.matches(ORDER_PATTERN)) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }

    private void validateNumeric(String input) {
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력할 수 있습니다.");
        }
    }
}
