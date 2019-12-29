package com.siwuxie095.forme.designpattern.category.chapter9th.example9th;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 晚餐菜单
 *
 * @author Jiajing Li
 * @date 2019-11-06 18:11:23
 */
class DinnerMenu implements Menu {

    /**
     * 菜单项
     */
    private Map<String, MenuItem> menuItems;

    DinnerMenu() {
        menuItems = new HashMap<>();

        addItem("晚餐 A", "晚餐 A：...", true, 23.99);
        addItem("晚餐 B", "晚餐 B：...", false, 24.99);
        addItem("晚餐 C", "晚餐 C：...", true, 25.99);
    }

    void addItem(String name,
                 String description,
                 boolean vegetarian,
                 double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.put(name, menuItem);
    }

    @Override
    public Iterator createIterator() {
        return menuItems.values().iterator();
    }
}
