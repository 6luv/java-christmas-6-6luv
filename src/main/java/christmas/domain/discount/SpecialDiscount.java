package christmas.domain.discount;

public class SpecialDiscount implements DiscountCalculator {
    @Override
    public int calculateDiscount(DiscountInfo discountInfo) {
        int date = discountInfo.date();

        if (isSpecial(date)) {
            return 1000;
        }
        return 0;
    }
}
