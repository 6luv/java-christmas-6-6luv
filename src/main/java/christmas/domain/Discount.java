package christmas.domain;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Discount {
    private final String title;
    private final int amount;

    private Discount(String title, int amount) {
        this.title = title;
        this.amount = amount;
    }

    private Discount calculateDdayDiscount(Date date) {
        int discount = 0;
        if (1 <= date.getDay() && date.getDay() <= 25) {
            discount = (date.getDay() - 1) * 100;
        }
        return new Discount("크리스마스 디데이 할인", discount);
    }

    private Discount calculateWeekdayDiscount(Date date, int dessertCount) {
        LocalDate localDate = LocalDate.of(2012, 12, date.getDay());
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();

        int discount = 0;

        if (isWeekday(dayOfWeek)) {
            discount = dessertCount * 2023;
        }
        return new Discount("평일 할인", discount);
    }

    private Discount calculateWeekendDiscount(Date date, int mainDishCount) {
        LocalDate localDate = LocalDate.of(2023, 12, date.getDay());
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();

        int discount = 0;

        if (isWeekend(dayOfWeek)) {
            discount = mainDishCount * 2023;
        }
        return new Discount("주말 할인", discount);
    }

    private Discount calculateSpecialDiscount(Date date) {
        LocalDate localDate = LocalDate.of(2023, 12, date.getDay());
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();

        int discount = 0;

        if (isSpecial(dayOfWeek, date.getDay())) {
            discount = 1000;
        }

        return new Discount("특별 할인", discount);
    }

    private boolean isWeekday(DayOfWeek dayOfWeek) {
        return dayOfWeek.getValue() >= DayOfWeek.SUNDAY.getValue()
                || dayOfWeek.getValue() <= DayOfWeek.THURSDAY.getValue();
    }

    private boolean isWeekend(DayOfWeek dayOfWeek) {
        return dayOfWeek.getValue() == DayOfWeek.FRIDAY.getValue()
                || dayOfWeek.getValue() == DayOfWeek.SATURDAY.getValue();
    }

    private boolean isSpecial(DayOfWeek dayOfWeek, int date) {
        return dayOfWeek.getValue() == DayOfWeek.SUNDAY.getValue()
                || date == 25;
    }
}
