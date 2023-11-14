package christmas.domain;

import static christmas.constants.Constants.EVENT_END_DATE;
import static christmas.constants.Constants.EVENT_START_DATE;

public class Date {
    private final int day;

    public Date(int day) {
        validateRange(day);
        this.day = day;
    }

    private void validateRange(int day) {
        if (EVENT_START_DATE > day || day> EVENT_END_DATE) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public int getDay() {
        return day;
    }
}
