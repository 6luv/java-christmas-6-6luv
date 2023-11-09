package christmas;

import christmas.controller.ChristmasPromotion;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView output = new OutputView();
        ChristmasPromotion christmasPromotion = new ChristmasPromotion(output);
        christmasPromotion.run();
    }
}
