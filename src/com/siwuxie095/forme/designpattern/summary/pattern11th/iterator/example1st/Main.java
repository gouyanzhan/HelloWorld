package com.siwuxie095.forme.designpattern.summary.pattern11th.iterator.example1st;

/**
 * @author Jiajing Li
 * @date 2019-11-06 08:30:26
 */
public class Main {

    /**
     * 使用自己的迭代器
     */
    public static void main(String[] args) {
        BreakfastMenu breakfastMenu = new BreakfastMenu();
        LunchMenu lunchMenu = new LunchMenu();

        Waitress waitress = new Waitress(breakfastMenu, lunchMenu);
        waitress.printMenu();
        System.out.println();
        waitress.printVegetarianMenu();
    }

}
