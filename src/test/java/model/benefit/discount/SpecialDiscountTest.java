package model.benefit.discount;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.domain.benefit.BenefitContext;
import christmas.domain.benefit.BenefitInfo;
import christmas.domain.benefit.discount.SpecialDiscount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SpecialDiscountTest {
    @ParameterizedTest
    @CsvSource({
            "1, 0",
            "3, 1_000",
            "10, 1_000",
            "24, 1_000",
            "25, 1_000",
            "26, 0"
    })
    @DisplayName("특별 할인 테스트")
    void calculateBenefit(int date, int expectedDiscount) {
        BenefitContext context = new BenefitContext(date, 0, 0, 0);
        SpecialDiscount specialDiscount = new SpecialDiscount();

        BenefitInfo info = specialDiscount.calculateBenefit(context);
        assertEquals(expectedDiscount, info.getAmount());
    }
}