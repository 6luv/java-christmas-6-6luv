package christmas.view;

import java.util.Map;

public class OutputView {
    public void printStart() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printOrder(Map<String, String> order) {
        System.out.println("<주문 메뉴>");
        for (String menuItem : order.keySet()) {
            System.out.printf("%s %s개\n", menuItem, order.get(menuItem));
        }
    }
}
