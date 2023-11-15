package christmas.domain.benefit;

public class BenefitContext {
    private final int date;
    private final int dessertCount;
    private final int mainDishCount;
    private final int totalAmount;

    public BenefitContext(int date, int dessertCount, int mainDishCount, int totalAmount) {
        this.date = date;
        this.dessertCount = dessertCount;
        this.mainDishCount = mainDishCount;
        this.totalAmount = totalAmount;
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

    public int getTotalAmount() {
        return totalAmount;
    }
}