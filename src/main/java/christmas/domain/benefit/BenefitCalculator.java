package christmas.domain.benefit;

public interface BenefitCalculator {
    BenefitInfo calculateBenefit(BenefitContext context);
}