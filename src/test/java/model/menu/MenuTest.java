package model.menu;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import christmas.domain.menu.Menu;
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
    @DisplayName("메뉴 이름 유효성 성공 테스트")
    void validMenuNameTest(String menuName, int menuCount) {
        assertDoesNotThrow(() -> new Menu(menuName, menuCount));
    }

    @ParameterizedTest
    @CsvSource({
            "치킨, 1",
            "피자, 1",
            "사이다, 1"
    })
    @DisplayName("메뉴 이름 유효성 실패 테스트")
    void invalidMenuNameTest(String menuName, int menuCount) {
        assertThrows(IllegalArgumentException.class,
                () -> new Menu(menuName, menuCount));
    }

    @ParameterizedTest
    @CsvSource({
            "제로콜라, 0",
            "타파스, 21",
            "해산물파스타, 30"
    })
    @DisplayName("메뉴 개수 검증 실패 테스트")
    void invalidMenuCountTest(String menuName, int menuCount) {
        assertThrows(IllegalArgumentException.class,
                () -> new Menu(menuName, menuCount));
    }
}