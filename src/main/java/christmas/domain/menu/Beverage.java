package christmas.domain.menu;

import java.util.Arrays;
import java.util.List;

public enum Beverage implements MenuItem {
    ZERO_COLA("제로콜라", 3_000, MenuCategory.BEVERAGE),
    RED_WINE("레드와인", 60_000, MenuCategory.BEVERAGE),
    CHAMPAGNE("샴페인", 25_000, MenuCategory.BEVERAGE);

    private final String name;
    private final int price;
    private final MenuCategory category;

    Beverage(String name, int price, MenuCategory category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public static boolean isEveryMenuBeverage(List<Menu> order) {
        return order.stream()
                .allMatch(menu -> Arrays.stream(Beverage.values())
                        .anyMatch(beverage -> beverage.name.equals(menu.getMenuName())));
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
