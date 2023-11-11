package christmas.domain.discount;

import java.time.DayOfWeek;
import java.time.LocalDate;

@FunctionalInterface
interface DiscountCalculator {
    int calculateDiscount(DiscountInfo discountInfo);

    default boolean isWeekday(int date) {
        DayOfWeek dayOfWeek = convertDayOfWeek(date);
        return dayOfWeek.getValue() >= DayOfWeek.SUNDAY.getValue()
                || dayOfWeek.getValue() <= DayOfWeek.THURSDAY.getValue();
    }

    default boolean isWeekend(int date) {
        DayOfWeek dayOfWeek = convertDayOfWeek(date);
        return dayOfWeek.getValue() == DayOfWeek.FRIDAY.getValue()
                || dayOfWeek.getValue() == DayOfWeek.SATURDAY.getValue();
    }

    default boolean isSpecial(int date) {
        DayOfWeek dayOfWeek = convertDayOfWeek(date);
        return dayOfWeek.getValue() == DayOfWeek.SUNDAY.getValue()
                || date == 25;
    }

    private DayOfWeek convertDayOfWeek(int date) {
        LocalDate localDate = LocalDate.of(2023, 12, date);
        return localDate.getDayOfWeek();
    }
}
