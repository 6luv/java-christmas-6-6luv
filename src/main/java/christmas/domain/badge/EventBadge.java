package christmas.domain.badge;

import java.util.Arrays;

public class EventBadge {
    private final BadgeType badgeType;

    private EventBadge(BadgeType badgeType) {
        this.badgeType = badgeType;
    }

    public static EventBadge determineBadgeType(int benefitAmount) {
        BadgeType badge = Arrays.stream(BadgeType.values())
                .filter(type -> type.isEligible(benefitAmount))
                .findFirst()
                .orElse(BadgeType.NO_BADGE);
        return new EventBadge(badge);
    }

    public String getBadge() {
        return badgeType.getBadgeType();
    }
}