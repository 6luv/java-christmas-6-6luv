package christmas.domain.benefit;

public class BenefitContext {
    private final int date;
    private final int dessertCount;
    private final int mainDishCount;
    private final int totalPrice;

    public BenefitContext(int date, int dessertCount, int mainDishCount, int totalPrice) {
        this.date = date;
        this.dessertCount = dessertCount;
        this.mainDishCount = mainDishCount;
        this.totalPrice = totalPrice;
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

    public int getTotalPrice() {
        return totalPrice;
    }
}