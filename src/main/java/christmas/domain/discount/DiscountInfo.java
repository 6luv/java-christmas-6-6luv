package christmas.domain.discount;

public class DiscountInfo {
    private final String discountType;
    private final int amount;

    public DiscountInfo(String discountType, int amount) {
        this.discountType = discountType;
        this.amount = amount;
    }

    public String getDiscountType() {
        return discountType;
    }

    public int getAmount() {
        return amount;
    }
}

