package christmas.domain.discount;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class SpecialDiscount implements DiscountCalculator {
    @Override
    public DiscountInfo calculateDiscount(DiscountContext context) {
        LocalDate localDate = LocalDate.of(2023, 12, context.getDate());
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();

        int discount = 0;

        if (isSpecial(dayOfWeek) || isChristmas(context.getDate())) {
            discount = 1000;
        }
        return new DiscountInfo("특별 할인", discount);
    }

    private boolean isSpecial(DayOfWeek dayOfWeek) {
        return dayOfWeek.getValue() == DayOfWeek.SUNDAY.getValue();
    }

    private boolean isChristmas(int date) {
        return date == 25;
    }
}
