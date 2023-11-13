package christmas.domain.discount;

public class DdayDiscount implements DiscountCalculator {
    @Override
    public DiscountInfo calculateDiscount(DiscountContext context) {
        int date = context.getDate();
        int discount = 0;
        if (1 <= date && date <= 25) {
            discount = (date - 1) * 100 + 1000;
        }
        return new DiscountInfo("크리스마스 디데이 할인", discount);
    }
}
