package model.menu;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import christmas.constants.ExceptionType;
import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuCategory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MenuTest {
    @ParameterizedTest
    @CsvSource({
            "타파스, 1",
            "해산물파스타, 1",
            "제로콜라, 1"
    })
    @DisplayName("메뉴 객체 생성 성공 테스트")
    void validMenuNameTest(String menuName, int menuCount) {
        MenuCategory category = MenuCategory.determineMenuCategory(menuName);
        assertDoesNotThrow(() -> new Menu(menuName, menuCount, category));
    }

    @ParameterizedTest
    @CsvSource({
            "치킨, 1",
            "피자, 1",
            "사이다, 1"
    })
    @DisplayName("메뉴 객체 생성 실패 테스트")
    void invalidMenuNameTest(String menuName, int menuCount) {
        assertThatThrownBy(() -> new Menu(menuName, menuCount, MenuCategory.determineMenuCategory(menuName)))
                .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ExceptionType.INVALID_ORDER.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "제로콜라, 0",
            "타파스, 21",
            "해산물파스타, 30"
    })
    @DisplayName("메뉴 개수 검증 실패 테스트")
    void invalidMenuCountTest(String menuName, int menuCount) {
        MenuCategory category = MenuCategory.determineMenuCategory(menuName);
        assertThatThrownBy(() -> new Menu(menuName, menuCount, category))
                .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ExceptionType.INVALID_ORDER_QUANTITY.getMessage());
    }
}