package model.benefit.discount;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.domain.benefit.BenefitContext;
import christmas.domain.benefit.BenefitInfo;
import christmas.domain.benefit.discount.WeekdayDiscount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WeekdayDiscountTest {
    @ParameterizedTest
    @CsvSource({
            "3, 3, 6069",
            "5, 2, 4046",
            "7, 1, 2023",
            "8, 1, 0"
    })
    @DisplayName("평일 할인 테스트")
    void calculateBenefitTest(int date, int dessertCount, int expectedDiscount) {
        BenefitContext context = new BenefitContext(date, dessertCount, 0, 0);
        WeekdayDiscount weekdayDiscount = new WeekdayDiscount();

        BenefitInfo info = weekdayDiscount.calculateBenefit(context);
        assertEquals(expectedDiscount, info.getAmount());
    }
}
