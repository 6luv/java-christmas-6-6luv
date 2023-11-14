package christmas.domain.benefit.discount;

import static christmas.constants.Constants.EVENT_MONTH;
import static christmas.constants.Constants.EVENT_YEAR;

import christmas.domain.benefit.BenefitCalculator;
import christmas.domain.benefit.BenefitContext;
import christmas.domain.benefit.BenefitInfo;
import christmas.domain.benefit.BenefitType;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeekdayDiscount implements BenefitCalculator {
    @Override
    public BenefitInfo calculateBenefit(BenefitContext context) {
        LocalDate localDate = LocalDate.of(EVENT_YEAR, EVENT_MONTH, context.getDate());
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();

        int discount = 0;

        if (isWeekday(dayOfWeek)) {
            discount = context.getDessertCount() * EVENT_YEAR;
        }
        return new BenefitInfo(BenefitType.WEEKDAY, discount);
    }

    private boolean isWeekday(DayOfWeek dayOfWeek) {
        return dayOfWeek.getValue() >= DayOfWeek.SUNDAY.getValue()
                || dayOfWeek.getValue() <= DayOfWeek.THURSDAY.getValue();
    }
}
