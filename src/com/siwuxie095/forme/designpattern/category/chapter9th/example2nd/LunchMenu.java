package com.siwuxie095.forme.designpattern.category.chapter9th.example2nd;

/**
 * 午餐菜单
 *
 * @author Jiajing Li
 * @date 2019-11-06 08:28:54
 */
class LunchMenu {

    /**
     * 最大菜单项数目
     */
    private static final int MAX_ITEMS = 3;

    /**
     * 当前已有菜单项数目
     */
    private int numberOfItems = 0;

    /**
     * 菜单项
     */
    private MenuItem[] menuItems;

    LunchMenu() {
        menuItems = new MenuItem[MAX_ITEMS];

        addItem("午餐 A", "午餐 A：...", true, 15.99);
        addItem("午餐 B", "午餐 B：...", false, 16.99);
        addItem("午餐 C", "午餐 C：...", true, 17.99);
    }

    void addItem(String name,
                 String description,
                 boolean vegetarian,
                 double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        if (numberOfItems >= MAX_ITEMS) {
            System.err.println("Sorry, menu is full! Can't add item to menu");
        } else {
            menuItems[numberOfItems] = menuItem;
            numberOfItems = numberOfItems + 1;
        }
    }

    Iterator createIterator() {
        return new LunchMenuIterator(menuItems);
    }

}
