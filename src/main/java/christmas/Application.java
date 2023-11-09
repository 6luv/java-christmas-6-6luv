package christmas;

import christmas.controller.ChristmasPromotion;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView input = new InputView();
        OutputView output = new OutputView();
        ChristmasPromotion christmasPromotion = new ChristmasPromotion(input, output);
        christmasPromotion.run();
    }
}
