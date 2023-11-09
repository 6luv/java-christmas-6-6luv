package christmas.controller;

import christmas.domain.Date;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasPromotion {
    private final InputView input;
    private final OutputView output;

    public ChristmasPromotion(InputView input, OutputView output) {
        this.input = input;
        this.output = output;
    }

    public void run() {
        output.printStart();
        Date date = new Date(input.readDate());
    }
}
