package model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import christmas.domain.Order;
import christmas.domain.menu.Menu;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderTest {
    @Test
    @DisplayName("메뉴 중복 실패 테스트")
    void invalidOrderUniqueTest() {
        List<Menu> order = new ArrayList<>();
        order.add(new Menu("제로콜라", 1));
        order.add(new Menu("제로콜라", 3));
        assertThrows(IllegalArgumentException.class,
                () -> new Order(order));
    }

    @Test
    @DisplayName("메뉴 중복 성공 테스트")
    void validOrderUniqueTest() {
        List<Menu> order = new ArrayList<>();
        order.add(new Menu("제로콜라", 1));
        order.add(new Menu("해산물파스타", 2));
        assertDoesNotThrow(() -> new Order(order));
    }
}
