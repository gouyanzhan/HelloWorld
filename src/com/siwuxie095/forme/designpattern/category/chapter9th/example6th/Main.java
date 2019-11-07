package com.siwuxie095.forme.designpattern.category.chapter9th.example6th;

/**
 * @author Jiajing Li
 * @date 2019-11-06 08:30:26
 */
public class Main {

    /**
     * 又兼并了一家晚餐餐厅进来，其内部使用 Map 存储菜单项
     *
     * 使用自己的迭代器进行实现
     *
     *
     * 注意：
     * 女招待（客户）的代码也要做修改，以支持新菜单。
     *
     * 另外：
     * 本例中，Map 对于迭代器的支持是 "间接" 的。因为这个
     * 迭代器不是直接从 Map 中取出的，而是从 Map 的 value
     * 取出的。
     * Map 中存储了两组对象 key 和 value，如果要遍历 value，
     * 就要先从 Map 中取出 value，再从 value 中取出迭代器。
     *
     *
     * 对于常见的 List、Set、Vector、Stack、PriorityQueue
     * 等类或接口，其实都是 java Collection Framework
     * 的一部分。
     * Collection 和 Iterator 的好处在于，每个 Collection
     * 都知道如何创建自己的 Iterator。只要调用 List 上的
     * iterator() 方法，就可以返回一个具体的 Iterator，而你
     * 根本不需要知道或关心到底使用了哪个具体类，你只要使用它的
     * Iterator 接口就可以了。
     *
     * PS：Java 5 以及以上版本，提供了新形式的 for 语句，称为
     * for/in，即 for each。这可以让你在一个集合或一个数组中
     * 遍历，而且不需要显式创建迭代器。
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
