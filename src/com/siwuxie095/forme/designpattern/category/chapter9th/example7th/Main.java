package com.siwuxie095.forme.designpattern.category.chapter9th.example7th;

/**
 * @author Jiajing Li
 * @date 2019-11-06 08:30:26
 */
public class Main {

    /**
     * 又兼并了一家晚餐餐厅进来，其内部使用 Map 存储菜单项
     *
     * 使用 Java 自带的迭代器进行实现
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
