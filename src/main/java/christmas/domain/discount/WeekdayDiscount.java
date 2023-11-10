package christmas.domain.discount;

import christmas.domain.menu.Dessert;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Map;

public class WeekdayDiscount {
    public static int calculateDiscount(int date, Map<String, String> order) {
        LocalDate localDate = LocalDate.of(2023, 12, date);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();

        if (!isWeekday(dayOfWeek)) {
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

    private static boolean isWeekday(DayOfWeek dayOfWeek) {
        return dayOfWeek.getValue() >= DayOfWeek.SUNDAY.getValue()
                || dayOfWeek.getValue() <= DayOfWeek.THURSDAY.getValue();
    }
}
