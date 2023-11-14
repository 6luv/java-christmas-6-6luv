package model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import christmas.domain.Order;
import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuCategory;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderTest {
    @Test
    @DisplayName("메뉴가 중복된 경우 테스트")
    void invalidOrderUniqueTest() {
        List<Menu> order = new ArrayList<>();
        order.add(new Menu("제로콜라", 1, MenuCategory.BEVERAGE));
        order.add(new Menu("제로콜라", 3, MenuCategory.BEVERAGE));
        assertThrows(IllegalArgumentException.class,
                () -> new Order(order));
    }

    @Test
    @DisplayName("메뉴가 중복되지 않은 테스트")
    void validOrderUniqueTest() {
        List<Menu> order = new ArrayList<>();
        order.add(new Menu("제로콜라", 1, MenuCategory.BEVERAGE));
        order.add(new Menu("해산물파스타", 2, MenuCategory.MAIN_DISH));
        assertDoesNotThrow(() -> new Order(order));
    }
}
