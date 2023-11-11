package christmas.domain.discount;

@FunctionalInterface
interface DiscountCalculator {
    int calculateDiscount(DiscountInfo discountInfo);
}
