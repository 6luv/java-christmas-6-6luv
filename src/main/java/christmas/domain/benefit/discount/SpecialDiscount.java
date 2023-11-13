package christmas.domain.benefit.discount;

import christmas.domain.benefit.BenefitCalculator;
import christmas.domain.benefit.BenefitContext;
import christmas.domain.benefit.BenefitInfo;
import christmas.domain.benefit.BenefitType;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class SpecialDiscount implements BenefitCalculator {
    @Override
    public BenefitInfo calculateBenefit(BenefitContext context) {
        LocalDate localDate = LocalDate.of(2023, 12, context.getDate());
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();

        int discount = 0;

        if (isSpecial(dayOfWeek) || isChristmas(context.getDate())) {
            discount = 1000;
        }
        return new BenefitInfo(BenefitType.SPECIAL, discount);
    }

    private boolean isSpecial(DayOfWeek dayOfWeek) {
        return dayOfWeek.getValue() == DayOfWeek.SUNDAY.getValue();
    }

    private boolean isChristmas(int date) {
        return date == 25;
    }
}
