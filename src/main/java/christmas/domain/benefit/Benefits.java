package christmas.domain.benefit;

import christmas.domain.benefit.discount.DdayDiscount;
import christmas.domain.benefit.discount.SpecialDiscount;
import christmas.domain.benefit.discount.WeekdayDiscount;
import christmas.domain.benefit.discount.WeekendDiscount;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Benefits {
    private final List<BenefitInfo> benefitInfos;

    public Benefits(List<BenefitInfo> discountInfos) {
        this.benefitInfos = discountInfos;
    }

    public static Benefits calculateDiscounts(BenefitContext context) {
        List<BenefitInfo> calculatedDiscounts = new ArrayList<>();

        DdayDiscount ddayDiscount = new DdayDiscount();
        WeekdayDiscount weekdayDiscount = new WeekdayDiscount();
        WeekendDiscount weekendDiscount = new WeekendDiscount();
        SpecialDiscount specialDiscount = new SpecialDiscount();

        calculatedDiscounts.add(ddayDiscount.calculateBenefit(context));
        calculatedDiscounts.add(weekdayDiscount.calculateBenefit(context));
        calculatedDiscounts.add(weekendDiscount.calculateBenefit(context));
        calculatedDiscounts.add(specialDiscount.calculateBenefit(context));
        return new Benefits(calculatedDiscounts);
    }

    public List<BenefitInfo> getDiscounts() {
        return benefitInfos.stream()
                .map(discount -> new BenefitInfo(discount.getBenefitType(), discount.getAmount()))
                .collect(Collectors.toUnmodifiableList());
    }
}
