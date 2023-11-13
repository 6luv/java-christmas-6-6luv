package christmas.domain.benefit.discount;

import christmas.domain.benefit.BenefitCalculator;
import christmas.domain.benefit.BenefitContext;
import christmas.domain.benefit.BenefitInfo;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeekendDiscount implements BenefitCalculator {
    @Override
    public BenefitInfo calculateBenefit(BenefitContext context) {
        LocalDate localDate = LocalDate.of(2023, 12, context.getDate());
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();

        int discount = 0;

        if (isWeekend(dayOfWeek)) {
            discount = context.getMainDishCount() * 2023;
        }
        return new BenefitInfo("주말 할인", discount);
    }

    private boolean isWeekend(DayOfWeek dayOfWeek) {
        return dayOfWeek.getValue() == DayOfWeek.FRIDAY.getValue()
                || dayOfWeek.getValue() == DayOfWeek.SATURDAY.getValue();
    }
}