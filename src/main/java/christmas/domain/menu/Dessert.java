package christmas.domain.menu;

import christmas.domain.Order;

public enum Dessert implements MenuItem {
    CHOCOLATE_CAKE("초코케이크", 15_000, MenuCategory.DESSERT),
    ICE_CREAM("아이스크림", 5_000, MenuCategory.DESSERT);

    private final String name;
    private final int price;
    private final MenuCategory category;

    Dessert(String name, int price, MenuCategory category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public static int calculateDessertCount(Order order) {
        return order.getOrder()
                .stream()
                .filter(menu -> menu.getCategory() == MenuCategory.DESSERT)
                .mapToInt(Menu::getMenuCount)
                .sum();
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