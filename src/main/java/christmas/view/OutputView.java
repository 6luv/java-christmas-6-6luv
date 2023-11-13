package christmas.view;

import christmas.domain.Date;
import christmas.domain.benefit.BenefitInfo;
import christmas.domain.menu.Menu;
import java.util.List;

public class OutputView {
    public void printStart() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void printDate(Date date) {
        System.out.printf("12월 %d월에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n", date.getDay());
    }

    public void printOrder(List<Menu> order) {
        System.out.println("<주문 메뉴>");
        for (Menu menu : order) {
            System.out.printf("%s %d개\n", menu.getMenuName(), menu.getMenuCount());
        }
    }

    public void printTotalPrice(int totalPrice) {
        System.out.println("\n<할인 전 총주문 금액>");
        System.out.printf("%,d원\n", totalPrice);
    }

    public void printBenefits(List<BenefitInfo> benefits) {
        System.out.println("<혜택 내역>");
        for (BenefitInfo info : benefits) {
            System.out.printf("%s: -%,d원\n", info.getBenefitType(), info.getAmount());
        }
    }
}