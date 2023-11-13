package christmas.domain.menu;

public interface MenuItem {
    int getPrice();
    MenuCategory getCategory();
    boolean hasMenu(String menuName);
}
