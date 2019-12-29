package com.siwuxie095.forme.designpattern.category.chapter9th.example1st;

import java.util.List;

/**
 * 女招待
 *
 * @author Jiajing Li
 * @date 2019-11-05 22:27:51
 */
class Waitress {

    /**
     * 打印出菜单上的每一项
     */
    void printMenu() {
        BreakfastMenu breakfastMenu = new BreakfastMenu();
        List<MenuItem> breakfastItems = breakfastMenu.getMenuItems();
        for (int i = 0; i < breakfastItems.size(); i++) {
            System.out.println(breakfastItems.get(i));
        }

        LunchMenu lunchMenu = new LunchMenu();
        MenuItem[] lunchItems = lunchMenu.getMenuItems();
        for (int i = 0; i < lunchItems.length; i++) {
            System.out.println(lunchItems[i]);
        }
    }

    /**
     * 只打印早餐项
     */
    void printBreakfastMenu() {
        BreakfastMenu breakfastMenu = new BreakfastMenu();
        List<MenuItem> menuItems = breakfastMenu.getMenuItems();
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(menuItems.get(i));
        }
    }

    /**
     * 只打印午餐项
     */
    void printLunchMenu() {
        LunchMenu lunchMenu = new LunchMenu();
        MenuItem[] menuItems = lunchMenu.getMenuItems();
        for (int i = 0; i < menuItems.length; i++) {
            System.out.println(menuItems[i]);
        }
    }

    /**
     * 打印所有的素食菜单项
     */
    void printVegetarianMenu() {
        BreakfastMenu breakfastMenu = new BreakfastMenu();
        List<MenuItem> breakfastItems = breakfastMenu.getMenuItems();
        for (int i = 0; i < breakfastItems.size(); i++) {
            if (breakfastItems.get(i).isVegetarian()) {
                System.out.println(breakfastItems.get(i));
            }
        }

        LunchMenu lunchMenu = new LunchMenu();
        MenuItem[] lunchItems = lunchMenu.getMenuItems();
        for (int i = 0; i < lunchItems.length; i++) {
            if (lunchItems[i].isVegetarian()) {
                System.out.println(lunchItems[i]);
            }
        }
    }

    /**
     * 判断指定项是否是素食
     */
    boolean isItemVegetarian(String name) {
        BreakfastMenu breakfastMenu = new BreakfastMenu();
        List<MenuItem> breakfastItems = breakfastMenu.getMenuItems();
        for (int i = 0; i < breakfastItems.size(); i++) {
            MenuItem menuItem = breakfastItems.get(i);
            if (menuItem.getName().equals(name) && menuItem.isVegetarian()) {
                return true;
            }
        }

        LunchMenu lunchMenu = new LunchMenu();
        MenuItem[] lunchItems = lunchMenu.getMenuItems();
        for (int i = 0; i < lunchItems.length; i++) {
            MenuItem menuItem = lunchItems[i];
            if (menuItem.getName().equals(name) && menuItem.isVegetarian()) {
                return true;
            }
        }
        return false;
    }

}
