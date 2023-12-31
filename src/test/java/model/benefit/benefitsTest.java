package model.benefit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.domain.benefit.BenefitCalculator;
import christmas.domain.benefit.BenefitContext;
import christmas.domain.benefit.BenefitInfo;
import christmas.domain.benefit.BenefitType;
import christmas.domain.benefit.Benefits;
import christmas.domain.benefit.discount.DdayDiscount;
import christmas.domain.benefit.discount.SpecialDiscount;
import christmas.domain.benefit.discount.WeekdayDiscount;
import christmas.domain.benefit.discount.WeekendDiscount;
import christmas.domain.benefit.giveaway.Champagne;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class benefitsTest {
    private static List<BenefitCalculator> calculators;

    @BeforeAll
    static void setUpCalculator() {
        calculators = List.of(
                new DdayDiscount(),
                new WeekdayDiscount(),
                new WeekendDiscount(),
                new SpecialDiscount(),
                new Champagne()
        );
    }

    @Test
    @DisplayName("혜택 내역 테스트 (크리스마스 디데이 할인, 평일 할인, 증정 이벤트)")
    void calculateBenefits_2() {
        BenefitContext context = new BenefitContext(25, 2, 2, 150_000);
        List<BenefitInfo> benefits = Benefits.calculateBenefits(context, calculators).getBenefits();

        List<BenefitInfo> expectedBenefits = List.of(
                new BenefitInfo(BenefitType.D_DAY, 3_400),
                new BenefitInfo(BenefitType.WEEKDAY, 4_046),
                new BenefitInfo(BenefitType.SPECIAL, 1_000),
                new BenefitInfo(BenefitType.GIVEAWAY, 25_000)
        );
        assertThat(expectedBenefits).usingRecursiveComparison().isEqualTo(benefits);
    }

    @Test
    @DisplayName("혜택 내역 테스트 (주말 할인)")
    void calculateBenefits() {
        BenefitContext context = new BenefitContext(29, 1, 2, 30_000);
        List<BenefitInfo> benefits = Benefits.calculateBenefits(context, calculators).getBenefits();

        List<BenefitInfo> expectedBenefits = List.of(
                new BenefitInfo(BenefitType.WEEKEND, 4_046)
        );
        assertThat(expectedBenefits).usingRecursiveComparison().isEqualTo(benefits);
    }

    @Test
    @DisplayName("혜택 내역 테스트 (총 주문 금액 10,000원 이하)")
    void calculateBenefitsNoBenefit() {
        BenefitContext context = new BenefitContext(25, 0, 1, 8_500);
        List<BenefitInfo> benefits = Benefits.calculateBenefits(context, calculators).getBenefits();

        List<BenefitInfo> expectedBenefits = List.of();
        assertThat(expectedBenefits).usingRecursiveComparison().isEqualTo(benefits);
    }

    @Test
    @DisplayName("총 혜택 금액 계산 테스트")
    void calculateBenefitAmount() {
        BenefitContext context = new BenefitContext(25, 2, 2, 150_000);
        Benefits benefits = Benefits.calculateBenefits(context, calculators);
        assertEquals(33_446, Benefits.calculateBenefitsAmount(benefits));
    }
}
