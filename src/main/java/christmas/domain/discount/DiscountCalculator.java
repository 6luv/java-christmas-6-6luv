package christmas.domain.discount;

import java.util.Map;

@FunctionalInterface
interface DiscountCalculator {
    int calculateDiscount(int date, Map<String, String> order);
}
