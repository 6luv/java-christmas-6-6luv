package christmas.domain.menu;

import java.util.Objects;

public class Menu {
    private final String menuName;
    private final int menuCount;
    private final MenuCategory menuCategory;

    public Menu(String menuName, int menuCount, MenuCategory menuCategory) {
        validateMenuCount(menuCount);
        this.menuName = menuName;
        this.menuCount = menuCount;
        this.menuCategory = menuCategory;
    }

    private void validateMenuCount(int menuCount) {
        if (!isMenuCountValidRange(menuCount)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    private boolean isMenuCountValidRange(int menuCount) {
        return 1 <= menuCount && menuCount <= 20;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getMenuCount() {
        return menuCount;
    }

    public MenuCategory getCategory() {
        return menuCategory;
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuName);
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
        return Objects.equals(menuName, menu.menuName);
    }
}
