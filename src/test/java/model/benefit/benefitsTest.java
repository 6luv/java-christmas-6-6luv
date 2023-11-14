package model.benefit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import christmas.domain.benefit.BenefitContext;
import christmas.domain.benefit.BenefitInfo;
import christmas.domain.benefit.BenefitType;
import christmas.domain.benefit.Benefits;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class benefitsTest {
    @Test
    @DisplayName("혜택 내역 테스트 (크리스마스 디데이 할인, 평일 할인, 증정 이벤트)")
    void calculateBenefits_2() {
        BenefitContext context = new BenefitContext(25, 2, 2, 150000);
        List<BenefitInfo> benefits = Benefits.calculateBenefits(context).getBenefits();

        List<BenefitInfo> expectedBenefits = List.of(
                new BenefitInfo(BenefitType.D_DAY, 3400),
                new BenefitInfo(BenefitType.WEEKDAY, 4046),
                new BenefitInfo(BenefitType.SPECIAL, 1000),
                new BenefitInfo(BenefitType.GIVEAWAY, 25000)
        );
        assertThat(expectedBenefits).usingRecursiveComparison().isEqualTo(benefits);
    }

    @Test
    @DisplayName("혜택 내역 테스트 (주말 할인)")
    void calculateBenefits() {
        BenefitContext context = new BenefitContext(29, 1, 2, 30000);
        List<BenefitInfo> benefits = Benefits.calculateBenefits(context).getBenefits();

        List<BenefitInfo> expectedBenefits = List.of(
                new BenefitInfo(BenefitType.WEEKEND, 4046)
        );
        assertThat(expectedBenefits).usingRecursiveComparison().isEqualTo(benefits);
    }

    @Test
    @DisplayName("혜택 내역 테스트 (총 주문 금액 10,000원 이하)")
    void calculateBenefitsNoBenefit() {
        BenefitContext context = new BenefitContext(25, 0, 1, 8500);
        List<BenefitInfo> benefits = Benefits.calculateBenefits(context).getBenefits();

        List<BenefitInfo> expectedBenefits = List.of();
        assertThat(expectedBenefits).usingRecursiveComparison().isEqualTo(benefits);
    }
}
