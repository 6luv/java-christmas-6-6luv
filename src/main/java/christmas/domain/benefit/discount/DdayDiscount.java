package christmas.domain.benefit.discount;

import christmas.domain.benefit.BenefitCalculator;
import christmas.domain.benefit.BenefitContext;
import christmas.domain.benefit.BenefitInfo;
import christmas.domain.benefit.BenefitType;

public class DdayDiscount implements BenefitCalculator {
    @Override
    public BenefitInfo calculateBenefit(BenefitContext context) {
        int date = context.getDate();
        int discount = 0;
        if (1 <= date && date <= 25) {
            discount = (date - 1) * 100 + 1000;
        }
        return new BenefitInfo(BenefitType.D_DAY, discount);
    }
}
