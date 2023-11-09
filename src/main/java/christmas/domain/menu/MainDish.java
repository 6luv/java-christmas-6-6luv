package christmas.domain.menu;

public enum MainDish implements MenuItem {
    T_BONE_STEAK("티본스테이크", 55_000, MenuCategory.MAIN),
    BARBECUE_RIB("바비큐립", 54_000, MenuCategory.MAIN),
    SEAFOOD_PASTA("해산물파스타", 35_000, MenuCategory.MAIN),
    CHRISTMAS_PASTA("크리스마스파스타", 25_000, MenuCategory.MAIN);

    private final String name;
    private final int price;
    private final MenuCategory category;

    MainDish(String name, int price, MenuCategory category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public MenuCategory getCategory() {
        return category;
    }
}