package christmas.domain.menu;

import java.util.Arrays;

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
                .anyMatch(menuItem -> menuItem.getName().equals(menuName));
    }
}
