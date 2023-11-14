package christmas.controller;

import static christmas.constants.Constants.MENU_ITEM_SEPARATOR;
import static christmas.constants.Constants.QUANTITY_SEPARATOR;

import christmas.domain.Date;
import christmas.domain.Order;
import christmas.domain.badge.EventBadge;
import christmas.domain.benefit.BenefitContext;
import christmas.domain.benefit.Benefits;
import christmas.domain.benefit.giveaway.Champagne;
import christmas.domain.menu.Dessert;
import christmas.domain.menu.MainDish;
import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuCategory;
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
        Date date = processDate();
        Order order = processOrder();

        int totalPrice = order.getTotalPrice();
        output.printTotalPrice(totalPrice);
        output.printGiveaway(Champagne.getGiveaway(totalPrice));

        BenefitContext context = generateContext(order, date.getDay(), totalPrice);
        int benefitsAmount = processBenefit(context);
        int giveawayAmount = processGiveaway(context);
        int estimatedAmount = totalPrice - (benefitsAmount - giveawayAmount);
        output.printEstimatedAmount(estimatedAmount);

        String eventBadge = EventBadge.determineBadgeType(benefitsAmount).getBadge();
        output.printEventBadge(eventBadge);
    }

    private Date processDate() {
        Date date = getDate();
        output.printDate(date);
        return date;
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

    private Order processOrder() {
        Order order = getOrder();
        output.printOrder(order.getOrder());
        return order;
    }

    private Order getOrder() {
        while (true) {
            try {
                String readOrder = input.readOrder();
                return new Order(parseOrder(readOrder));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Menu> parseOrder(String order) {
        return Arrays.stream(order.split(MENU_ITEM_SEPARATOR))
                .map(menuItem -> menuItem.split(QUANTITY_SEPARATOR))
                .map(menu -> new Menu(menu[0], Integer.parseInt(menu[1]), MenuCategory.determineMenuCategory(menu[0])))
                .toList();
    }

    private BenefitContext generateContext(Order order, int date, int totalPrice) {
        int dessertCount = Dessert.calculateDessertCount(order);
        int mainDishCount = MainDish.calculateMainDishCount(order);
        return new BenefitContext(date, dessertCount, mainDishCount, totalPrice);
    }

    private int processBenefit(BenefitContext context) {
        Benefits benefits = Benefits.calculateBenefits(context);
        output.printBenefits(benefits.getBenefits());

        int benefitsAmount = Benefits.calculateBenefitAmount(benefits);
        output.printBenefitAmount(benefitsAmount);
        return benefitsAmount;
    }

    private int processGiveaway(BenefitContext context) {
        Champagne champagne = new Champagne();
        return champagne.calculateBenefit(context).getAmount();
    }
}
