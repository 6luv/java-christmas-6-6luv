package christmas;

import christmas.controller.ChristmasPromotion;
import christmas.domain.benefit.BenefitCalculator;
import christmas.domain.benefit.discount.DdayDiscount;
import christmas.domain.benefit.discount.SpecialDiscount;
import christmas.domain.benefit.discount.WeekdayDiscount;
import christmas.domain.benefit.discount.WeekendDiscount;
import christmas.domain.benefit.giveaway.Champagne;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView input = new InputView();
        OutputView output = new OutputView();
        List<BenefitCalculator> calculators = List.of(
                new DdayDiscount(),
                new WeekdayDiscount(),
                new WeekendDiscount(),
                new SpecialDiscount(),
                new Champagne()
        );

        ChristmasPromotion christmasPromotion = new ChristmasPromotion(input, output, calculators);
        christmasPromotion.executeChristmasPromotion();
    }
}
