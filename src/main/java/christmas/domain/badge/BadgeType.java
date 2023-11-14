package christmas.domain.badge;

public enum BadgeType {
    SANTA("산타", 20_000),
    TREE("트리", 10_000),
    STAR("별", 5_000),
    NO_BADGE("없음", 0);

    private final String badgeType;
    private final int benefitAmount;

    BadgeType(String badgeType, int benefitAmount) {
        this.badgeType = badgeType;
        this.benefitAmount = benefitAmount;
    }

    public String getBadgeType() {
        return badgeType;
    }

    public boolean isEligible(int benefitAmount) {
        return benefitAmount >= this.benefitAmount;
    }
}