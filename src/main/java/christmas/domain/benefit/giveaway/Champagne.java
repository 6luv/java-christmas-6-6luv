package christmas.domain.benefit.giveaway;

import christmas.domain.benefit.BenefitCalculator;
import christmas.domain.benefit.BenefitContext;
import christmas.domain.benefit.BenefitInfo;
import christmas.domain.benefit.BenefitType;
import java.util.stream.Stream;

public class Champagne implements BenefitCalculator {
    private static final String GIVEAWAY_FORMAT = "%s %d개";
    private static final String GIVEAWAY_NAME = "샴페인";
    private static final int GIVEAWAY_THRESHOLD = 120_000;
    private static final int GIVEAWAY_PRICE = 25_000;
    private static final int GIVEAWAY_QUALITY = 1;

    @Override
    public BenefitInfo calculateBenefit(BenefitContext context) {
        int price = 0;
        if (context.getTotalPrice() >= GIVEAWAY_THRESHOLD) {
            price = GIVEAWAY_PRICE;
        }
        return new BenefitInfo(BenefitType.GIVEAWAY, price);
    }

    public static String getGiveaway(int totalPrice) {
        return Stream.of(totalPrice)
                .filter(price -> price >= 120000)
                .map(giveaway -> String.format(GIVEAWAY_FORMAT, GIVEAWAY_NAME, GIVEAWAY_QUALITY))
                .findFirst()
                .orElse("없음");
    }
}