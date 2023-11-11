package christmas.domain;

import christmas.domain.menu.Menu;
import java.util.HashSet;
import java.util.List;

public class Order {
    private final List<Menu> order;

    public Order(List<Menu> order) {
        validateUnique(order);
        this.order = order;
    }

    private void validateUnique(List<Menu> order) {
        HashSet<Menu> uniqueOrder = new HashSet<>(order);
        if (order.size() != uniqueOrder.size()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
}
