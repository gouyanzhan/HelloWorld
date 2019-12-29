package com.siwuxie095.forme.designpattern.category.chapter9th.example3rd;

/**
 * @author Jiajing Li
 * @date 2019-11-06 08:30:26
 */
public class Main {

    /**
     * 做一些改良
     *
     * 给菜单一个共同的接口 Menu，目前里面只有一个创建菜单迭代器的
     * 方法 createIterator()。由于目前还是想让厨师来控制菜单，所
     * 以暂时没有把 addItem() 放进该接口。
     *
     * 然后再微调女招待代码，将对具体菜单的引用改为对共同接口 Menu
     * 的引用。
     *
     *
     * 带来的好处
     *
     * 早餐菜单和午餐菜单的类，都实现了 Menu 接口，女招待可以利用接口
     * （而不是具体类）引用每一个菜单对象。这样，通过 "针对接口编程，
     * 而不是针对实现编程"，就可以减少女招待和具体类之间的依赖。
     *
     * 从此，女招待只需关心菜单和迭代器这两个接口。
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
