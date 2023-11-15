package christmas.domain.menu;

import christmas.constants.ExceptionType;
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

    public Class<? extends MenuItem> getMenuClass() {
        return menuClass;
    }

    public static MenuCategory determineMenuCategory(String menuName) {
        return Arrays.stream(MenuCategory.values())
                .filter(category -> Arrays.stream(category.getMenuClass().getEnumConstants())
                        .anyMatch(menuItem -> menuItem.hasMenu(menuName)))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionType.INVALID_ORDER.getMessage()));
    }
}
