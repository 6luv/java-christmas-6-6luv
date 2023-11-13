package christmas.domain.benefit;

public class BenefitInfo {
    private final BenefitType benefitType;
    private final int amount;

    public BenefitInfo(BenefitType benefitType, int amount) {
        this.benefitType = benefitType;
        this.amount = amount;
    }

    public BenefitType getBenefitType() {
        return benefitType;
    }

    public int getAmount() {
        return amount;
    }
}

