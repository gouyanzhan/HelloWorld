package com.siwuxie095.forme.designpattern.category.chapter9th.example8th;

/**
 * @author Jiajing Li
 * @date 2019-11-06 08:30:26
 */
public class Main {

    /**
     * 厨师决定午餐菜单的菜单项能交替进行改变，即 周一、周三、
     * 周五、周日提供一些菜单项，然后在周二、周四、周六提供另
     * 一些菜单项。且午餐菜单不支持删除菜单项。
     *
     * 注意：本例是使用 Java 自带的迭代器。
     */
    public static void main(String[] args) {
        BreakfastMenu breakfastMenu = new BreakfastMenu();
        LunchMenu lunchMenu = new LunchMenu();
        DinnerMenu dinnerMenu = new DinnerMenu();

        Waitress waitress = new Waitress(breakfastMenu, lunchMenu, dinnerMenu);
        waitress.printMenu();
        System.out.println();
        waitress.printVegetarianMenu();
    }

}
