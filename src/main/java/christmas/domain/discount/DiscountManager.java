package christmas.domain.discount;

public enum DiscountManager implements DiscountCalculator {
    D_DAY(discountInfo -> new DdayDiscount().calculateDiscount(discountInfo)),
    SPECIAL(discountInfo -> new SpecialDiscount().calculateDiscount(discountInfo)),
    WEEKDAY(discountInfo -> new WeekdayDiscount().calculateDiscount(discountInfo)),
    WEEKEND(discountInfo -> new WeekendDiscount().calculateDiscount(discountInfo));

    private final DiscountCalculator discountCalculator;

    DiscountManager(DiscountCalculator discountCalculator) {
        this.discountCalculator = discountCalculator;
    }

    @Override
    public int calculateDiscount(DiscountInfo discountInfo) {
        return discountCalculator.calculateDiscount(discountInfo);
    }
}
