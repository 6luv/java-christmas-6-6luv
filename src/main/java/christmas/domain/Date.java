package christmas.domain;

import static christmas.constants.Constants.EVENT_END_DATE;
import static christmas.constants.Constants.EVENT_START_DATE;

public class Date {
    private final int date;

    public Date(int date) {
        validateRange(date);
        this.date = date;
    }

    private void validateRange(int date) {
        if (EVENT_START_DATE > date || date> EVENT_END_DATE) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public int getDate() {
        return date;
    }
}
