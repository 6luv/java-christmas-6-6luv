package christmas.domain.menu;

public enum Appetizer implements MenuItem {
    MUSHROOM_SOUP("양송이수프", 6_000, MenuCategory.APPETIZER),
    TAPAS("타파스", 5_500, MenuCategory.APPETIZER),
    CAESAR_SALAD("시저샐러드", 8_000, MenuCategory.APPETIZER);

    private final String name;
    private final int price;
    private final MenuCategory category;

    Appetizer(String name, int price, MenuCategory category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean hasMenu(String menuName) {
        return name.contains(menuName);
    }
}
