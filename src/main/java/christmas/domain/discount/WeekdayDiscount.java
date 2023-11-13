package christmas.domain.discount;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeekdayDiscount implements DiscountCalculator {
    @Override
    public DiscountInfo calculateDiscount(DiscountContext context) {
        LocalDate localDate = LocalDate.of(2012, 12, context.getDate());
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();

        int discount = 0;

        if (isWeekday(dayOfWeek)) {
            discount = context.getDessertCount() * 2023;
        }
        return new DiscountInfo("평일 할인", discount);
    }

    private static boolean isWeekday(DayOfWeek dayOfWeek) {
        return dayOfWeek.getValue() >= DayOfWeek.SUNDAY.getValue()
                || dayOfWeek.getValue() <= DayOfWeek.THURSDAY.getValue();
    }
}
