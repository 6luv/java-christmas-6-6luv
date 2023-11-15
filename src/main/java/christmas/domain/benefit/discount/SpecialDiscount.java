package christmas.domain.benefit.discount;

import static christmas.constants.EventConstants.CHRISTMAS_DDAY;
import static christmas.constants.EventConstants.EVENT_MONTH;
import static christmas.constants.EventConstants.EVENT_YEAR;

import christmas.domain.benefit.BenefitCalculator;
import christmas.domain.benefit.BenefitContext;
import christmas.domain.benefit.BenefitInfo;
import christmas.domain.benefit.BenefitType;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class SpecialDiscount implements BenefitCalculator {
    private static final int SPECIAL_DISCOUNT_AMOUNT = 1_000;

    @Override
    public BenefitInfo calculateBenefit(BenefitContext context) {
        LocalDate localDate = LocalDate.of(EVENT_YEAR.getValue(), EVENT_MONTH.getValue(), context.getDate());
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();

        int discount = 0;

        if (isSpecial(dayOfWeek) || isChristmas(context.getDate())) {
            discount = SPECIAL_DISCOUNT_AMOUNT;
        }
        return new BenefitInfo(BenefitType.SPECIAL, discount);
    }

    private boolean isSpecial(DayOfWeek dayOfWeek) {
        return dayOfWeek.getValue() == DayOfWeek.SUNDAY.getValue();
    }

    private boolean isChristmas(int date) {
        return date == CHRISTMAS_DDAY.getValue();
    }
}