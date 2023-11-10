package christmas.domain.discount;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class SpecialDiscount {
    public static int calculateDiscount(int date) {
        LocalDate localDate = LocalDate.of(2023, 12, date);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();

        if (isSpecial(dayOfWeek, date)) {
            return 1000;
        }
        return 0;
    }

    private static boolean isSpecial(DayOfWeek dayOfWeek, int date) {
        return dayOfWeek.getValue() == DayOfWeek.SUNDAY.getValue()
                || date == 25;
    }
}
