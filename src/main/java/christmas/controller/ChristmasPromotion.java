package christmas.controller;

import christmas.domain.Date;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.awt.Menu;
import java.util.LinkedHashMap;
import java.util.Map;
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
        Map<String, String> menu = getOrder(input.readOrder());
        output.printOrder(menu);
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

    private Map<String, String> getOrder(String order) {
        Map<String, String> menu = new LinkedHashMap<>();
        for (String menuItem : order.split(",")) {
            String[] singleMenu = menuItem.split("-");
            menu.put(singleMenu[0], singleMenu[1]);
        }
        return menu;
    }
}
