package christmas.domain.benefit.giveaway;

import christmas.domain.benefit.BenefitCalculator;
import christmas.domain.benefit.BenefitContext;
import christmas.domain.benefit.BenefitInfo;
import christmas.domain.benefit.BenefitType;

public class Champagne implements BenefitCalculator {
    public static final String GIVEAWAY_NAME = "샴페인";
    public static final int GIVEAWAY_QUALITY = 1;
    private static final int GIVEAWAY_THRESHOLD = 120_000;
    private static final int GIVEAWAY_PRICE = 25_000;

    @Override
    public BenefitInfo calculateBenefit(BenefitContext context) {
        int price = 0;
        if (isGiveaway(context.getTotalPrice())) {
            price = GIVEAWAY_PRICE;
        }
        return new BenefitInfo(BenefitType.GIVEAWAY, price);
    }

    private boolean isGiveaway(int totalPrice) {
        return totalPrice >= GIVEAWAY_THRESHOLD;
    }
}