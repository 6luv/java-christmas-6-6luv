package christmas.domain.menu;

public interface MenuItem {
    MenuCategory getCategory();
    boolean hasMenu(String menuName);
}
