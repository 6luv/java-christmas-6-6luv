package christmas.domain.discount;

import christmas.domain.menu.Dessert;
import java.util.Arrays;
import java.util.Map;

public class WeekdayDiscount implements DiscountCalculator {
    @Override
    public int calculateDiscount(DiscountInfo discountInfo) {
        int date = discountInfo.date();
        Map<String, String> order = discountInfo.order();

        if (!isWeekday(date)) {
            return 0;
        }
        int dessertCount = order.entrySet()
                .stream()
                .filter(entry -> Arrays.stream(Dessert.values())
                        .anyMatch(dessert -> dessert.hasMenu(entry.getKey())))
                .mapToInt(entry -> Integer.parseInt(entry.getValue()))
                .findFirst()
                .orElse(0);

        return dessertCount * 2023;
    }
}
