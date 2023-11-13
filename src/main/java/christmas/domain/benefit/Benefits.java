package christmas.domain.benefit;

import christmas.domain.benefit.discount.DdayDiscount;
import christmas.domain.benefit.discount.SpecialDiscount;
import christmas.domain.benefit.discount.WeekdayDiscount;
import christmas.domain.benefit.discount.WeekendDiscount;
import christmas.domain.benefit.giveaway.Champagne;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Benefits {
    private final List<BenefitInfo> benefitInfos;

    private Benefits(List<BenefitInfo> benefitInfos) {
        this.benefitInfos = benefitInfos;
    }

    public static Benefits calculateBenefits(BenefitContext context) {
        List<BenefitCalculator> calculators = initCalculators();
        List<BenefitInfo> benefits = calculators.stream()
                .map(calculator -> calculator.calculateBenefit(context))
                .filter(benefitInfo -> benefitInfo.getAmount() != 0)
                .collect(Collectors.toUnmodifiableList());
        return new Benefits(benefits);
    }

    private static List<BenefitCalculator> initCalculators() {
        return new ArrayList<>(List.of(
                new DdayDiscount(),
                new WeekdayDiscount(),
                new WeekendDiscount(),
                new SpecialDiscount(),
                new Champagne()
        ));
    }

    public List<BenefitInfo> getBenefits() {
        return benefitInfos.stream()
                .map(info -> new BenefitInfo(info.getBenefitType(), info.getAmount()))
                .collect(Collectors.toUnmodifiableList());
    }
}