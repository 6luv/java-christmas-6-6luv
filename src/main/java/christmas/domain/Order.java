package christmas.domain;

import static christmas.constants.Constants.MAX_ORDER_QUANTITY;

import christmas.constants.ExceptionType;
import christmas.domain.menu.Beverage;
import christmas.domain.menu.Menu;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
    private final List<Menu> order;

    public Order(List<Menu> order) {
        validateUnique(order);
        validateOrderCount(order);
        validateAllOrdersBeverage(order);
        this.order = order;
    }

    private void validateUnique(List<Menu> order) {
        HashSet<Menu> uniqueOrder = new HashSet<>(order);
        if (order.size() != uniqueOrder.size()) {
            throw new IllegalArgumentException(ExceptionType.INVALID_ORDER.getMessage());
        }
    }

    private void validateAllOrdersBeverage(List<Menu> order) {
        if (Beverage.isEveryMenuBeverage(order)) {
            throw new IllegalArgumentException(ExceptionType.INVALID_BEVERAGE_ONLY_ORDER.getMessage());
        }
    }

    private void validateOrderCount(List<Menu> order) {
        int menuCount = order.stream()
                .mapToInt(Menu::getMenuCount)
                .sum();

        if (menuCount > MAX_ORDER_QUANTITY) {
            throw new IllegalArgumentException(ExceptionType.INVALID_ORDER_QUANTITY.getMessage());
        }
    }

    public int getTotalPrice() {
        return order.stream()
                .mapToInt(Menu::getMenuPrice)
                .sum();
    }

    public List<Menu> getOrder() {
        return order.stream()
                .map(menu -> new Menu(menu.getMenuName(), menu.getMenuCount(), menu.getCategory()))
                .collect(Collectors.toUnmodifiableList());
    }
}