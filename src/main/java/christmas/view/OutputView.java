package christmas.view;

import christmas.domain.Date;
import java.util.Map;

public class OutputView {
    public void printStart() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printDate(Date date) {
        System.out.printf("12월 %d월에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n", date.getDay());
    }

    public void printOrder(Map<String, String> order) {
        System.out.println("<주문 메뉴>");
        for (String menuItem : order.keySet()) {
            System.out.printf("%s %s개\n", menuItem, order.get(menuItem));
        }
    }

    public void printOriginalOrderAmount(int originalOrderAmount) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.printf("%,d원\n", originalOrderAmount);
    }
}
