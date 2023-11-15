package model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import christmas.constants.ExceptionType;
import christmas.domain.Date;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DateTest {
    @ParameterizedTest
    @CsvSource({
            "-1",
            "0",
            "32"
    })
    @DisplayName("날짜 범위 실패 테스트")
    void invalidDateTest(int date) {
        assertThatThrownBy(() -> new Date(date))
                .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ExceptionType.INVALID_DATE.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "1",
            "22",
            "31"
    })
    @DisplayName("날짜 범위 성공 테스트")
    void validDateTest(int date) {
        assertDoesNotThrow(() -> new Date(date));
    }
}
