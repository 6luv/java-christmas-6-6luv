package christmas.domain.discount;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Discounts {
    private final List<DiscountInfo> discountInfos;

    public Discounts(List<DiscountInfo> discountInfos) {
        this.discountInfos = discountInfos;
    }

    public static Discounts calculateDiscounts(DiscountContext context) {
        List<DiscountInfo> calculatedDiscounts = new ArrayList<>();

        DdayDiscount ddayDiscount = new DdayDiscount();
        WeekdayDiscount weekdayDiscount = new WeekdayDiscount();
        WeekendDiscount weekendDiscount = new WeekendDiscount();
        SpecialDiscount specialDiscount = new SpecialDiscount();

        calculatedDiscounts.add(ddayDiscount.calculateDiscount(context));
        calculatedDiscounts.add(weekdayDiscount.calculateDiscount(context));
        calculatedDiscounts.add(weekendDiscount.calculateDiscount(context));
        calculatedDiscounts.add(specialDiscount.calculateDiscount(context));
        return new Discounts(calculatedDiscounts);
    }

    public List<DiscountInfo> getDiscounts() {
        return discountInfos.stream()
                .map(discount -> new DiscountInfo(discount.getDiscountType(), discount.getAmount()))
                .collect(Collectors.toUnmodifiableList());
    }
}
