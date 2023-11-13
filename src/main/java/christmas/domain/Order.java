package christmas.domain;

import christmas.domain.menu.Beverage;
import christmas.domain.menu.Menu;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
    private final List<Menu> order;

    public Order(List<Menu> order) {
        validateUnique(order);
        validateAllOrdersAreBeverage(order);
        this.order = order;
    }

    private void validateUnique(List<Menu> order) {
        HashSet<Menu> uniqueOrder = new HashSet<>(order);
        if (order.size() != uniqueOrder.size()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private void validateAllOrdersAreBeverage(List<Menu> order) {
        if (Beverage.isEveryMenuBeverage(order)) {
            throw new IllegalArgumentException("[ERROR] 음료만 주문 시, 주문할 수 없습니다.");
        }
    }

    public List<Menu> getOrder() {
        return order.stream()
                .map(menu -> new Menu(menu.getMenuName(), menu.getMenuCount(), menu.getCategory()))
                .collect(Collectors.toUnmodifiableList());
    }
}
