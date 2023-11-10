package christmas.domain.discount;

import christmas.domain.menu.Dessert;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;

public class WeekdayDiscount {
    public static int calculateDiscount(int date, Map<String, String> order) {
        if (isWeekly(date)) {
            return 0;
        }
        int dessertCount = order.entrySet()
                .stream()
                .filter(entry -> Arrays.stream(Dessert.values())
                        .anyMatch(menu -> menu.hasMenu(entry.getKey())))
                .mapToInt(entry -> Integer.parseInt(entry.getValue()))
                .sum();
        return dessertCount * 2023;
    }

    private static boolean isWeekly(int date) {
        return date >= Calendar.SUNDAY && date <= Calendar.THURSDAY;
    }
}
