package christmas.domain.discount;

public class DdayDiscount {
    private static final int EVENT_START_DATE = 1;
    private static final int EVENT_END_DATE = 25;
    private static final int INITIAL_DISCOUNT_AMOUNT = 1000;
    private static final int DAILY_DISCOUNT_INCREASE = 100;

    public static int calculateDiscount(int date) {
        if (EVENT_START_DATE <= date && date <= EVENT_END_DATE) {
            return INITIAL_DISCOUNT_AMOUNT + (date - EVENT_START_DATE) * DAILY_DISCOUNT_INCREASE;
        }
        return 0;
    }
}
