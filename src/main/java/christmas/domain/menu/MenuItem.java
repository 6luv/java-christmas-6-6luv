package christmas.domain.menu;

public interface MenuItem {
//    String getName();
//    int getPrice();
    MenuCategory getCategory();
    boolean hasMenu(String menuName);
    int calculatePrice(String quantity);
}
