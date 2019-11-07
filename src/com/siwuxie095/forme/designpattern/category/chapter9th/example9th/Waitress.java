package com.siwuxie095.forme.designpattern.category.chapter9th.example9th;

import java.util.Iterator;
import java.util.List;

/**
 * 女招待
 *
 * @author Jiajing Li
 * @date 2019-11-06 10:18:23
 */
class Waitress {

    private List<Menu> menus;

    Waitress(List<Menu> menus) {
        this.menus = menus;
    }

    /**
     * 打印出菜单上的每一项
     */
    void printMenu() {
        Iterator menuIterator = menus.iterator();
        while (menuIterator.hasNext()) {
            Menu menu = (Menu) menuIterator.next();
            printMenu(menu.createIterator());
        }
    }

    private void printMenu(Iterator iterator) {
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * 打印所有的素食菜单项
     */
    void printVegetarianMenu() {
        Iterator menuIterator = menus.iterator();
        while (menuIterator.hasNext()) {
            Menu menu = (Menu) menuIterator.next();
            Iterator menuItemIterator = menu.createIterator();
            while (menuItemIterator.hasNext()) {
                MenuItem menuItem = (MenuItem) menuItemIterator.next();
                if (menuItem.isVegetarian()) {
                    System.out.println(menuItem);
                }
            }
        }
    }

    /**
     * 判断指定项是否是素食
     */
    boolean isItemVegetarian(String name) {
        Iterator menuIterator = menus.iterator();
        while (menuIterator.hasNext()) {
            Menu menu = (Menu) menuIterator.next();
            Iterator menuItemIterator = menu.createIterator();
            while (menuItemIterator.hasNext()) {
                MenuItem menuItem = (MenuItem) menuItemIterator.next();
                if (menuItem.getName().equals(name) && menuItem.isVegetarian()) {
                    return true;
                }
            }
        }
        return false;
    }
}
