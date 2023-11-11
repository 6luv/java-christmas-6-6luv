package christmas.domain.menu;

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
}
