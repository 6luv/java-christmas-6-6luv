package christmas.controller;

import christmas.domain.Date;
import christmas.domain.discount.DdayDiscount;
import christmas.domain.discount.WeekdayDiscount;
import christmas.domain.discount.WeekendDiscount;
import christmas.domain.menu.MenuCategory;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class ChristmasPromotion {
    private final InputView input;
    private final OutputView output;

    public ChristmasPromotion(InputView input, OutputView output) {
        this.input = input;
        this.output = output;
    }

    public void run() {
        output.printStart();
        Date date = getDate();
        Map<String, String> order = getOrder(input.readOrder());
        output.printDate(date);
        output.printOrder(order);
        checkValidMenu(order);
        int originalOrderAmount = MenuCategory.calculatePrice(order);
        output.printOriginalOrderAmount(originalOrderAmount);

        DdayDiscount.calculateDiscount(date.getDay());
        WeekdayDiscount.calculateDiscount(date.getDay(), order);
        WeekendDiscount.calculateDiscount(date.getDay(), order);
    }

    private Date getDate() {
        Optional<Date> date;
        do {
            date = checkDate();
        } while(date.isEmpty());
        return date.get();
    }

    private Optional<Date> checkDate() {
        try {
            return Optional.of(new Date(input.readDate()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    private Map<String, String> getOrder(String order) {
        Map<String, String> menu = new LinkedHashMap<>();
        for (String menuItem : order.split(",")) {
            String[] singleMenu = menuItem.split("-");
            menu.put(singleMenu[0], singleMenu[1]);
        }
        return menu;
    }

    private void checkValidMenu(Map<String, String> order) {
        for (String menu : order.keySet()) {
            if (!MenuCategory.isMenuValid(menu)) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }
}
