package christmas.domain.menu;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
        Set<String> beverageNames = Arrays.stream(Beverage.values())
                .map(Beverage::getMenuName)
                .collect(Collectors.toSet());

        return order.stream()
                .allMatch(menu -> beverageNames.contains(menu.getMenuName()));
    }

    public String getMenuName() {
        return name;
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
