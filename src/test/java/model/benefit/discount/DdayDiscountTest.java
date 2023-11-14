package model.benefit.discount;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.domain.benefit.BenefitContext;
import christmas.domain.benefit.BenefitInfo;
import christmas.domain.benefit.discount.DdayDiscount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DdayDiscountTest {
    @ParameterizedTest
    @CsvSource({
            "1, 1000",
            "10, 1900",
            "25, 3400",
            "26, 0"
    })
    @DisplayName("크리스마스 디데이 할인 테스트")
    void calculateBenefitTest(int date, int expectedDiscount) {
        BenefitContext context = new BenefitContext(date, 0, 0, 0);
        DdayDiscount ddayDiscount = new DdayDiscount();

        BenefitInfo info = ddayDiscount.calculateBenefit(context);
        assertEquals(expectedDiscount, info.getAmount());
    }
}
