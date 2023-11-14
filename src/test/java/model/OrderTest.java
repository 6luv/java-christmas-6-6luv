package model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
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

    @Test
    @DisplayName("모든 메뉴가 음료인지 확인 테스트")
    void validateAllOrdersBeverageTest() {
        List<Menu> order = List.of(
                new Menu("제로콜라", 1, MenuCategory.BEVERAGE),
                new Menu("레드와인", 2, MenuCategory.BEVERAGE)
        );

        assertThatThrownBy(() -> new Order(order))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 음료만 주문 시, 주문할 수 없습니다.");
    }

    @Test
    @DisplayName("총 메뉴 개수가 20개 이상인 경우 테스트")
    void validateOrderCountTest() {
        List<Menu> order = List.of(
                new Menu("양송이수프", 10, MenuCategory.APPETIZER),
                new Menu("크리스마스파스타", 10, MenuCategory.MAIN_DISH),
                new Menu("아이스크림", 1, MenuCategory.DESSERT)
        );

        assertThatThrownBy(() -> new Order(order))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.");
    }
}