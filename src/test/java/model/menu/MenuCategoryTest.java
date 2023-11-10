package model.menu;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import christmas.domain.menu.MenuCategory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MenuCategoryTest {
    @ParameterizedTest
    @CsvSource({
            "타파스",
            "해산물파스타",
            "제로콜라"
    })
    @DisplayName("메뉴 이름 유효성 성공 테스트")
    void isMenuValidTest(String menuName) {
        assertTrue(() -> MenuCategory.isMenuValid(menuName));
    }

    @ParameterizedTest
    @CsvSource({
            "치킨",
            "피자",
            "사이다"
    })
    @DisplayName("메뉴 이름 유효성 실패 테스트")
    void isMenuInValidTest(String menuName) {
        assertFalse(MenuCategory.isMenuValid(menuName));
    }
}
