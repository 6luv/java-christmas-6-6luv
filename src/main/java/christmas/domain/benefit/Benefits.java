package christmas.domain.benefit;

import java.util.List;
import java.util.stream.Collectors;

public class Benefits {
    private static final int EVENT_THRESHOLD = 10_000;

    private final List<BenefitInfo> benefitInfos;

    private Benefits(List<BenefitInfo> benefitInfos) {
        this.benefitInfos = benefitInfos;
    }

    public static Benefits calculateBenefits(BenefitContext context, List<BenefitCalculator> calculators) {
        List<BenefitInfo> benefits = calculators.stream()
                .filter(amount -> context.getTotalAmount() >= EVENT_THRESHOLD)
                .map(calculator -> calculator.calculateBenefit(context))
                .filter(benefitInfo -> benefitInfo.getAmount() != 0)
                .collect(Collectors.toUnmodifiableList());
        return new Benefits(benefits);
    }

    public static int calculateBenefitsAmount(Benefits benefits) {
        return benefits.getBenefits()
                .stream()
                .mapToInt(BenefitInfo::getAmount)
                .sum();
    }

    public List<BenefitInfo> getBenefits() {
        return benefitInfos.stream()
                .map(info -> new BenefitInfo(info.getBenefitType(), info.getAmount()))
                .collect(Collectors.toUnmodifiableList());
    }
}