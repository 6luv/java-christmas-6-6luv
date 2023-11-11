package christmas.domain.discount;

import christmas.domain.menu.MainDish;
import java.util.Arrays;
import java.util.Map;

public class WeekendDiscount implements DiscountCalculator {
    @Override
    public int calculateDiscount(DiscountInfo discountInfo) {
        int date = discountInfo.date();
        Map<String, String> order = discountInfo.order();

        if (!isWeekend(date)) {
            return 0;
        }
        int mainDishCount = order.entrySet()
                .stream()
                .filter(entry -> Arrays.stream(MainDish.values())
                        .anyMatch(mainDish -> mainDish.hasMenu(entry.getKey())))
                .mapToInt(entry -> Integer.parseInt(entry.getValue()))
                .findFirst()
                .orElse(0);

        return mainDishCount * 2023;
    }
}
