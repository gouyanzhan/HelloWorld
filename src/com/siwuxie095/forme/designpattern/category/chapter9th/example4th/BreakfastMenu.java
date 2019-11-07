package com.siwuxie095.forme.designpattern.category.chapter9th.example4th;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 早餐菜单
 *
 * @author Jiajing Li
 * @date 2019-11-06 08:28:43
 */
class BreakfastMenu implements Menu {

    /**
     * 菜单项
     */
    private List<MenuItem> menuItems;

    BreakfastMenu() {
        menuItems = new ArrayList<>();

        addItem("早餐 A", "早餐 A：...", true, 3.99);
        addItem("早餐 B", "早餐 B：...", false, 4.99);
        addItem("早餐 C", "早餐 C：...", true, 5.99);
    }

    void addItem(String name,
                 String description,
                 boolean vegetarian,
                 double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.add(menuItem);
    }

    /**
     * 不创建 BreakfastMenu 自己的迭代器，而是使用 List
     * 自带的 iterator() 方法
     */
    @Override
    public Iterator createIterator() {
        return menuItems.iterator();
    }

}
