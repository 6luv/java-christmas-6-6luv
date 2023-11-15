package christmas.controller;

import static christmas.constants.Constants.MENU_ITEM_SEPARATOR;
import static christmas.constants.Constants.MENU_QUANTITY_SEPARATOR;

import christmas.constants.ExceptionType;
import christmas.domain.Date;
import christmas.domain.Order;
import christmas.domain.badge.EventBadge;
import christmas.domain.benefit.BenefitContext;
import christmas.domain.benefit.BenefitInfo;
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
import java.util.function.Supplier;

public class ChristmasPromotion {
    private final InputView input;
    private final OutputView output;

    public ChristmasPromotion(InputView input, OutputView output) {
        this.input = input;
        this.output = output;
    }

    public void executeChristmasPromotion() {
        output.printStart();
        Date date = getDate();
        Order order = getOrder();
        output.printDate(date.getDate());
        output.printOrder(order.getOrder());

        int totalPrice = processTotalPrice(order);
        BenefitContext context = generateContext(order, date.getDate(), totalPrice);
        int giveawayPrice = processGiveaway(context);
        int benefitsAmount = processBenefits(context);

        processEstimatedAmount(totalPrice, benefitsAmount, giveawayPrice);
        processEventBadge(benefitsAmount);
    }

    private Date getDate() {
        return getFromInput(() -> new Date(input.readDate()));
    }

    private Order getOrder() {
        return getFromInput(() -> new Order(parseOrder(input.readOrder())));
    }

    private List<Menu> parseOrder(String order) {
        return Arrays.stream(order.split(MENU_ITEM_SEPARATOR))
                .map(this::parseMenuItem)
                .toList();
    }

    private Menu parseMenuItem(String menuItem) {
        String[] menuComponents = menuItem.split(MENU_QUANTITY_SEPARATOR);
        if (menuComponents.length != 2) {
            throw new IllegalArgumentException(ExceptionType.INVALID_ORDER.getMessage());
        }

        String menuName = menuComponents[0];
        int quantity = Integer.parseInt(menuComponents[1]);
        MenuCategory category = MenuCategory.determineMenuCategory(menuName);
        return new Menu(menuName, quantity, category);
    }

    private int processTotalPrice(Order order) {
        int totalPrice = order.getTotalPrice();
        output.printTotalPrice(totalPrice);
        return totalPrice;
    }

    private int processGiveaway(BenefitContext context) {
        Champagne champagne = new Champagne();
        BenefitInfo giveaway = champagne.calculateBenefit(context);
        int giveawayPrice = giveaway.getAmount();
        output.printGiveaway(giveawayPrice);
        return giveawayPrice;
    }

    private BenefitContext generateContext(Order order, int date, int totalPrice) {
        int dessertCount = Dessert.calculateDessertCount(order);
        int mainDishCount = MainDish.calculateMainDishCount(order);
        return new BenefitContext(date, dessertCount, mainDishCount, totalPrice);
    }

    private int processBenefits(BenefitContext context) {
        Benefits benefits = Benefits.calculateBenefits(context);
        output.printBenefits(benefits.getBenefits());

        int benefitsAmount = Benefits.calculateBenefitAmount(benefits);
        output.printBenefitAmount(benefitsAmount);
        return benefitsAmount;
    }

    private void processEstimatedAmount(int totalPrice, int benefitsAmount, int giveawayPrice) {
        int estimatedAmount = totalPrice - (benefitsAmount - giveawayPrice);
        output.printEstimatedAmount(estimatedAmount);
    }

    private void processEventBadge(int benefitsAmount) {
        EventBadge eventBadge = EventBadge.determineBadgeType(benefitsAmount);
        output.printEventBadge(eventBadge.getBadge());
    }

    private <T> T getFromInput(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}