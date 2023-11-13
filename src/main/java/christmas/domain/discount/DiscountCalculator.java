package christmas.domain.discount;

public interface DiscountCalculator {
    DiscountInfo calculateDiscount(DiscountContext context);
}