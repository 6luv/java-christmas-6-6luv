package model.benefit.discount;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.domain.benefit.BenefitContext;
import christmas.domain.benefit.BenefitInfo;
import christmas.domain.benefit.discount.WeekendDiscount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WeekendDiscountTest {
    @ParameterizedTest
    @CsvSource({
            "1, 3, 6_069",
            "2, 2, 4_046",
            "3, 1, 0"
    })
    @DisplayName("주말 할인 테스트")
    void calculateBenefitTest(int date, int mainDishCount, int expectedDiscount) {
        BenefitContext context = new BenefitContext(date, 0, mainDishCount, 0);
        WeekendDiscount weekendDiscount = new WeekendDiscount();

        BenefitInfo info = weekendDiscount.calculateBenefit(context);
        assertEquals(expectedDiscount, info.getAmount());
    }
}
