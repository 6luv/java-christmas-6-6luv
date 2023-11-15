package christmas.domain.benefit.discount;

import static christmas.constants.EventConstants.EVENT_MONTH;
import static christmas.constants.EventConstants.EVENT_YEAR;

import christmas.domain.benefit.BenefitCalculator;
import christmas.domain.benefit.BenefitContext;
import christmas.domain.benefit.BenefitInfo;
import christmas.domain.benefit.BenefitType;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeekendDiscount implements BenefitCalculator {
    @Override
    public BenefitInfo calculateBenefit(BenefitContext context) {
        LocalDate localDate = LocalDate.of(EVENT_YEAR.getValue(), EVENT_MONTH.getValue(), context.getDate());
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();

        int discount = 0;

        if (isWeekend(dayOfWeek)) {
            discount = context.getMainDishCount() * EVENT_YEAR.getValue();
        }
        return new BenefitInfo(BenefitType.WEEKEND, discount);
    }

    private boolean isWeekend(DayOfWeek dayOfWeek) {
        return dayOfWeek.getValue() == DayOfWeek.FRIDAY.getValue()
                || dayOfWeek.getValue() == DayOfWeek.SATURDAY.getValue();
    }
}