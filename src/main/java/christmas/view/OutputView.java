package christmas.view;

import static christmas.constants.Constants.EVENT_MONTH;
import static christmas.constants.Constants.LINE_SEPARATOR;

import christmas.domain.Date;
import christmas.domain.benefit.BenefitInfo;
import christmas.domain.menu.Menu;
import java.util.List;

public class OutputView {
    private static final String ITEM_TYPE_FORMAT = "%s";
    private static final String QUANTITY_FORMAT = " %d개" + LINE_SEPARATOR;
    private static final String BENEFIT_TYPE_PRICE_SEPARATOR = ": ";
    private static final String DISCOUNT_PRICE_PREFIX = "-";
    private static final String PRICE_FORMAT = "%,d원" + LINE_SEPARATOR;

    public void printStart() {
        System.out.printf("안녕하세요! 우테코 식당 %d월 이벤트 플래너입니다." + LINE_SEPARATOR, EVENT_MONTH);
    }

    public void printDate(Date date) {
        System.out.printf("%d월 %d월에 우테코 식당에서 받을 이벤트 혜택 미리 보기!" + LINE_SEPARATOR, EVENT_MONTH, date.getDay());
    }

    public void printOrder(List<Menu> order) {
        System.out.println("<주문 메뉴>");
        for (Menu menu : order) {
            System.out.printf(ITEM_TYPE_FORMAT, menu.getMenuName());
            System.out.printf(QUANTITY_FORMAT, menu.getMenuCount());
        }
    }

    public void printTotalPrice(int totalPrice) {
        System.out.println("\n<할인 전 총주문 금액>");
        System.out.printf(PRICE_FORMAT, totalPrice);
    }

    public void printGiveaway(String giveaway) {
        System.out.println("<증정 메뉴>");
        System.out.println(giveaway);
    }

    public void printBenefits(List<BenefitInfo> benefits) {
        System.out.println("<혜택 내역>");

        if (benefits.isEmpty()) {
            System.out.println("없음");
        }

        for (BenefitInfo info : benefits) {
            System.out.printf(ITEM_TYPE_FORMAT, info.getBenefitType());
            System.out.printf(BENEFIT_TYPE_PRICE_SEPARATOR + DISCOUNT_PRICE_PREFIX);
            System.out.printf(PRICE_FORMAT, info.getAmount());
        }
    }

    public void printBenefitAmount(int benefitsAmount) {
        System.out.println("<총혜택 금액>");
        System.out.printf(PRICE_FORMAT, benefitsAmount);
    }

    public void printEstimatedAmount(int estimatedAmount) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.printf(PRICE_FORMAT, estimatedAmount);
    }

    public void printEventBadge(String eventBadge) {
        System.out.printf("<%d월 이벤트 배지>\n", EVENT_MONTH);
        System.out.println(eventBadge);
    }
}