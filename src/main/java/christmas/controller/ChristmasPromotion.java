package christmas.controller;

import christmas.domain.Date;
import christmas.domain.Order;
import christmas.domain.menu.Menu;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.Arrays;
import java.util.List;

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
        Order order = new Order(getOrder(input.readOrder()));
        output.printDate(date);
    }

    private Date getDate() {
        while (true) {
            try {
                return new Date(input.readDate());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Menu> getOrder(String order) {
        return Arrays.stream(order.split(","))
                .map(menuItem -> menuItem.split("-"))
                .map(menu -> new Menu(menu[0], Integer.parseInt(menu[1])))
                .toList();
    }
}
