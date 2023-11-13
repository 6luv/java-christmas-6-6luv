package christmas.domain.benefit.discount;

import christmas.domain.benefit.BenefitCalculator;
import christmas.domain.benefit.BenefitContext;
import christmas.domain.benefit.BenefitInfo;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeekdayDiscount implements BenefitCalculator {
    @Override
    public BenefitInfo calculateBenefit(BenefitContext context) {
        LocalDate localDate = LocalDate.of(2012, 12, context.getDate());
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();

        int discount = 0;

        if (isWeekday(dayOfWeek)) {
            discount = context.getDessertCount() * 2023;
        }
        return new BenefitInfo("평일 할인", discount);
    }

    private boolean isWeekday(DayOfWeek dayOfWeek) {
        return dayOfWeek.getValue() >= DayOfWeek.SUNDAY.getValue()
                || dayOfWeek.getValue() <= DayOfWeek.THURSDAY.getValue();
    }
}
