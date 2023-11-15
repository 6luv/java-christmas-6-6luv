package christmas.domain;

import static christmas.constants.Constants.EVENT_END_DATE;
import static christmas.constants.Constants.EVENT_START_DATE;

import christmas.constants.ExceptionType;

public class Date {
    private final int date;

    public Date(int date) {
        validateRange(date);
        this.date = date;
    }

    private void validateRange(int date) {
        if (EVENT_START_DATE > date || date> EVENT_END_DATE) {
            throw new IllegalArgumentException(ExceptionType.INVALID_DATE.getMessage());
        }
    }

    public int getDate() {
        return date;
    }
}
