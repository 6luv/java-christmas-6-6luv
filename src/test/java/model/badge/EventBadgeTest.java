package model.badge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import christmas.domain.badge.EventBadge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class EventBadgeTest {
    @ParameterizedTest
    @CsvSource({
            "0, 없음",
            "5100, 별",
            "19999, 트리",
            "100000, 산타"
    })
    @DisplayName("이벤트 배지 부여 테스트")
    void determineBadgeTypeTest(int benefitAmount, String expectedBadgeType) {
        EventBadge eventBadge = EventBadge.determineBadgeType(benefitAmount);
        assertThat(expectedBadgeType).isEqualTo(eventBadge.getBadge());
    }
}
