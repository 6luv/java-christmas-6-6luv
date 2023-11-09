package christmas.controller;

import christmas.view.OutputView;

public class ChristmasPromotion {
    private final OutputView output;

    public ChristmasPromotion(OutputView output) {
        this.output = output;
    }

    public void run() {
        output.printStart();
    }
}
