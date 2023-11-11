package christmas.domain.discount;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class SpecialDiscount implements DiscountCalculator {
    @Override
    public int calculateDiscount(DiscountInfo discountInfo) {
        int date = discountInfo.date();
        LocalDate localDate = LocalDate.of(2023, 12, discountInfo.date());
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();

        if (isSpecial(dayOfWeek, date)) {
            return 1000;
        }
        return 0;
    }

    private boolean isSpecial(DayOfWeek dayOfWeek, int date) {
        return dayOfWeek.getValue() == DayOfWeek.SUNDAY.getValue()
                || date == 25;
    }
}
