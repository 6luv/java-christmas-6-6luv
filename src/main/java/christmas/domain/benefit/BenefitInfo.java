package christmas.domain.benefit;

public class BenefitInfo {
    private final String benefitType;
    private final int amount;

    public BenefitInfo(String benefitType, int amount) {
        this.benefitType = benefitType;
        this.amount = amount;
    }

    public String getBenefitType() {
        return benefitType;
    }

    public int getAmount() {
        return amount;
    }
}

