package christmas.domain;

import static christmas.constants.EventConstants.EVENT_START_DATE;

import christmas.constants.EventConstants;
import christmas.constants.ExceptionType;

public class Date {
    private final int date;

    public Date(int date) {
        validateRange(date);
        this.date = date;
    }

    private void validateRange(int date) {
        if (EVENT_START_DATE.getValue() > date || date> EventConstants.EVENT_END_DATE.getValue()) {
            throw new IllegalArgumentException(ExceptionType.INVALID_DATE.getMessage());
        }
    }

    public int getDate() {
        return date;
    }
}