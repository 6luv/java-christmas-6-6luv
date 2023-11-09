package christmas.domain;

public class Date {
    private static final int MIN_DATE = 1;
    private static final int MAX_DATE = 31;

    private final int day;

    public Date(int day) {
        validateRange(day);
        this.day = day;
    }

    private void validateRange(int day) {
        if (MIN_DATE > day || day> MAX_DATE) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public int getDay() {
        return day;
    }
}
