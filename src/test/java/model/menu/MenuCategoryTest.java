package model.menu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.constants.ExceptionType;
import christmas.domain.menu.MenuCategory;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class MenuCategoryTest {
    @ParameterizedTest
    @MethodSource("validMenuNamesAndCategories")
    @DisplayName("메뉴 카테고리 반환 성공 테스트")
    void determineCategoryTest(String menuName, MenuCategory expectedCategory) {
        MenuCategory actualCategory = MenuCategory.determineMenuCategory(menuName);
        assertEquals(expectedCategory, actualCategory);
    }

    private static Stream<Arguments> validMenuNamesAndCategories() {
        return Stream.of(
                Arguments.of("타파스", MenuCategory.APPETIZER),
                Arguments.of("티본스테이크", MenuCategory.MAIN_DISH),
                Arguments.of("아이스크림", MenuCategory.DESSERT),
                Arguments.of("레드와인", MenuCategory.BEVERAGE)
        );
    }

    @ParameterizedTest
    @CsvSource({
            "치킨",
            "피자",
            "사이다"
    })
    @DisplayName("메뉴 카테고리 반환 실패 테스트")
    void determineCategoryTest(String menuName) {
        assertThatThrownBy(() -> MenuCategory.determineMenuCategory(menuName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.INVALID_ORDER.getMessage());
    }
}