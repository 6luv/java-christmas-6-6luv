package christmas.domain.discount;

import java.util.Map;

public enum DiscountManager {
    D_DAY((date, order) -> new DdayDiscount().calculateDiscount(date)),
    SPECIAL((date, order) -> new SpecialDiscount().calculateDiscount(date)),
    WEEKDAY((date, order) -> new WeekdayDiscount().calculateDiscount(date, order)),
    WEEKEND((date, order) -> new WeekendDiscount().calculateDiscount(date, order));

    private final DiscountCalculator discountCalculator;

    DiscountManager(DiscountCalculator discountCalculator) {
        this.discountCalculator = discountCalculator;
    }

    public int calculateDiscount(int date, Map<String, String> order) {
        return discountCalculator.calculateDiscount(date, order);
    }
}
