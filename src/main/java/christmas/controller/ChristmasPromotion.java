package christmas.controller;

import christmas.domain.Date;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.Optional;

public class ChristmasPromotion {
    private final InputView input;
    private final OutputView output;

    public ChristmasPromotion(InputView input, OutputView output) {
        this.input = input;
        this.output = output;
    }

    public void run() {
        output.printStart();
        Date date = getDate();
    }

    private Date getDate() {
        Optional<Date> date;
        do {
            date = checkDate();
        } while(date.isEmpty());
        return date.get();
    }

    private Optional<Date> checkDate() {
        try {
            return Optional.of(new Date(input.readDate()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }
}
