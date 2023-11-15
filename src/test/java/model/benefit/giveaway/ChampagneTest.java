package model.benefit.giveaway;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.domain.benefit.BenefitContext;
import christmas.domain.benefit.BenefitInfo;
import christmas.domain.benefit.giveaway.Champagne;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ChampagneTest {
    @ParameterizedTest
    @CsvSource({
            "120_000, 25_000",
            "100_000, 0"
    })
    @DisplayName("샴페인 증정 이벤트 테스트")
    void calculateBenefitTest(int totalPrice, int expectedPrice) {
        BenefitContext context = new BenefitContext(1, 0, 0, totalPrice);
        Champagne champagne = new Champagne();

        BenefitInfo info = champagne.calculateBenefit(context);
        assertEquals(expectedPrice, info.getAmount());
    }
}
