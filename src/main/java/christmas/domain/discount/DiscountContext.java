package christmas.domain.discount;

public class DiscountContext {
    private final int date;
    private final int dessertCount;
    private final int mainDishCount;

    public DiscountContext(int date, int dessertCount, int mainDishCount) {
        this.date = date;
        this.dessertCount = dessertCount;
        this.mainDishCount = mainDishCount;
    }

    public int getDate() {
        return date;
    }

    public int getDessertCount() {
        return dessertCount;
    }

    public int getMainDishCount() {
        return mainDishCount;
    }
}