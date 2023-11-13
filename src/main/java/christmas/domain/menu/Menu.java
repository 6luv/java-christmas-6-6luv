package christmas.domain.menu;

import java.util.Objects;

public class Menu {
    private final String name;
    private final int quantity;
    private final MenuCategory category;

    public Menu(String name, int quantity, MenuCategory category) {
        validateMenuCount(quantity);
        this.name = name;
        this.quantity = quantity;
        this.category = category;
    }

    public int getMenuPrice() {
        int price = 0;
        for (MenuItem menuItem : category.getMenuClass().getEnumConstants()) {
            if (menuItem.hasMenu(name)) {
                price = menuItem.getPrice() * quantity;
            }
        }
        return price;
    }

    private void validateMenuCount(int menuCount) {
        if (!isMenuCountValidRange(menuCount)) {
            throw new IllegalArgumentException("[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.");
        }
    }

    private boolean isMenuCountValidRange(int menuCount) {
        return 1 <= menuCount && menuCount <= 20;
    }

    public String getMenuName() {
        return name;
    }

    public int getMenuCount() {
        return quantity;
    }

    public MenuCategory getCategory() {
        return category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Menu menu = (Menu) obj;
        return Objects.equals(name, menu.name);
    }
}
