package christmas.domain.benefit.giveaway;

import christmas.domain.benefit.BenefitCalculator;
import christmas.domain.benefit.BenefitContext;
import christmas.domain.benefit.BenefitInfo;
import christmas.domain.benefit.BenefitType;

public class Champagne implements BenefitCalculator {
    private static final String GIVEAWAY_NAME = "샴페인";
    private static final int GIVEAWAY_QUALITY = 1;

    @Override
    public BenefitInfo calculateBenefit(BenefitContext context) {
        int price = 0;
        if (context.getTotalPrice() >= 120000) {
            price = 25000;
        }
        return new BenefitInfo(BenefitType.GIVEAWAY, price);
    }
}