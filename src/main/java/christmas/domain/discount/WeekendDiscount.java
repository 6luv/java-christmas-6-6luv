package christmas.domain.discount;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeekendDiscount implements DiscountCalculator {
    @Override
    public DiscountInfo calculateDiscount(DiscountContext context) {
        LocalDate localDate = LocalDate.of(2023, 12, context.getDate());
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();

        int discount = 0;

        if (isWeekend(dayOfWeek)) {
            discount = context.getMainDishCount() * 2023;
        }
        return new DiscountInfo("주말 할인", discount);
    }

    private boolean isWeekend(DayOfWeek dayOfWeek) {
        return dayOfWeek.getValue() == DayOfWeek.FRIDAY.getValue()
                || dayOfWeek.getValue() == DayOfWeek.SATURDAY.getValue();
    }
}
