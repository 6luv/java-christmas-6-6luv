package christmas.domain.menu;

import java.util.Arrays;
import java.util.Map;

public enum MenuCategory {
    APPETIZER(Appetizer.class),
    MAIN_DISH(MainDish.class),
    DESSERT(Dessert.class),
    BEVERAGE(Beverage.class);

    private final Class<? extends MenuItem> menuClass;

    MenuCategory(Class<? extends MenuItem> menuClass) {
        this.menuClass = menuClass;
    }

    public static boolean isMenuValid(String menuName) {
        return Arrays.stream(MenuCategory.values())
                .anyMatch(category -> category.isMenuInCategory(menuName));
    }

    private boolean isMenuInCategory(String menuName) {
        return Arrays.stream(menuClass.getEnumConstants())
                .anyMatch(menuItem -> menuItem.hasMenu(menuName));
    }

    public static int calculatePrice(Map<String, String> order) {
        return order.entrySet()
                .stream()
                .mapToInt(entry -> calculateSingleMenuPrice(entry.getKey(), entry.getValue()))
                .sum();
    }

    private static int calculateSingleMenuPrice(String menu, String quantity) {
        return Arrays.stream(MenuCategory.values())
                .flatMap(category -> Arrays.stream(category.menuClass.getEnumConstants()))
                .filter(menuItem -> menuItem.hasMenu(menu))
                .mapToInt(menuItem -> menuItem.calculatePrice(quantity))
                .sum();
    }
}
