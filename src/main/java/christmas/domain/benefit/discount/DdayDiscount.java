package christmas.domain.benefit.discount;

import static christmas.constants.Constants.CHRISTMAS_DDAY;
import static christmas.constants.Constants.EVENT_START_DATE;

import christmas.domain.benefit.BenefitCalculator;
import christmas.domain.benefit.BenefitContext;
import christmas.domain.benefit.BenefitInfo;
import christmas.domain.benefit.BenefitType;

public class DdayDiscount implements BenefitCalculator {
    private static final int INITIAL_AMOUNT = 1_000;
    private static final int DAILY_INCREASE = 100;

    @Override
    public BenefitInfo calculateBenefit(BenefitContext context) {
        int date = context.getDate();
        int discount = 0;
        if (EVENT_START_DATE <= date && date <= CHRISTMAS_DDAY) {
            discount = (date - EVENT_START_DATE) * DAILY_INCREASE + INITIAL_AMOUNT;
        }
        return new BenefitInfo(BenefitType.D_DAY, discount);
    }
}
