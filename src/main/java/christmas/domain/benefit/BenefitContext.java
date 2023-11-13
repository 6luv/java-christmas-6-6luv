package christmas.domain.benefit;

public class BenefitContext {
    private final int date;
    private final int dessertCount;
    private final int mainDishCount;

    public BenefitContext(int date, int dessertCount, int mainDishCount) {
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