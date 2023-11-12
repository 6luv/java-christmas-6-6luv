package christmas.domain.menu;

public enum MainDish implements MenuItem {
    T_BONE_STEAK("티본스테이크", 55_000, MenuCategory.MAIN_DISH),
    BARBECUE_RIB("바비큐립", 54_000, MenuCategory.MAIN_DISH),
    SEAFOOD_PASTA("해산물파스타", 35_000, MenuCategory.MAIN_DISH),
    CHRISTMAS_PASTA("크리스마스파스타", 25_000, MenuCategory.MAIN_DISH);

    private final String name;
    private final int price;
    private final MenuCategory category;

    MainDish(String name, int price, MenuCategory category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public MenuCategory getCategory() {
        return category;
    }

    @Override
    public boolean hasMenu(String menuName) {
        return name.contains(menuName);
    }
}
