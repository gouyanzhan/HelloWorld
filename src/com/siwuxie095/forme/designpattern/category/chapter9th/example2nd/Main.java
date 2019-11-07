package com.siwuxie095.forme.designpattern.category.chapter9th.example2nd;

/**
 * @author Jiajing Li
 * @date 2019-11-06 08:30:26
 */
public class Main {

    /**
     * 封装遍历
     *
     * 显然，应该要封装变化的部分。很明显，这里发生的变化是：由不同的
     * 集合（collection）类型所造成的遍历。
     *
     * 对于早餐菜单来说，遍历需要使用到 List 的 size() 和 get()。
     * 对于午餐菜单来说，遍历需要使用到数组的 length 和 中括号 []。
     *
     * 现在，创建一个对象，将它称为迭代器（Iterator），利用它来封装
     * "遍历集合内的每个对象的过程"。
     * 此时，再遍历就只需要使用到迭代器的 hasNext() 和 next()。而
     * 迭代器会暗中使用 size()/get() 或 length/[]。而这正是迭代器
     * 模式。
     *
     * 对于迭代器模式，首先要知道就是它依赖一个名为迭代器的接口。现在
     * 有了这个接口，就可以为各种对象集合实现迭代器：数组、列表、散列
     * 表 ...
     *
     * PS：当提到集合（collection）时，指的是一群对象，其存储方式可
     * 以是各种各样的数据结构，无论用什么方式存储，一律可以视为是集合，
     * 有时候也被称为聚合（aggregate）。
     *
     * 定义好迭代器接口之后，就可以实现各自的具体迭代器，以用来遍历：
     * （1）早餐菜单迭代器：BreakfastMenuIterator
     * （2）午餐菜单迭代器：LunchMenuIterator
     *
     * 然后在各自的菜单代码中，删除原来的 getMenuItems() 方法，因为
     * 它会暴露菜单的内部实现（即 菜单项是如何存储的）。新增一个创建对
     * 应迭代器的方法 createIterator()。返回一个迭代器，客户不需要
     * 知道菜单是如何维护菜单项的，也不需要知道迭代器是如何实现的。客
     * 户只需直接使用这个迭代器遍历菜单项即可。
     *
     *
     * 现在的情况
     *
     * 现在既能让各自的菜单保持自己的实现，又可以摆平遍历上的差别。只要
     * 给分别给二者一个具体迭代器，再加入一个 createIterator() 方法，
     * 就大功告成了。同时，女招待也将更容易维护和扩展。
     *
     * 在 example1st 中，菜单封装的不好，对于菜单项，一个使用 List，
     * 一个使用数组，需要两个循环来遍历菜单项。女招待捆绑于具体的类，即
     * List<MenuItem> 和 MenuItem[]，同时也捆绑于两个不同的具体菜单
     * 类，即 BreakfastMenu 和 LunchMenu。
     *
     * 在 example2nd 中（本例），菜单的实现已经被封装起来了。女招待不
     * 知道菜单是如何存储菜单项集合的。只要实现迭代器，只需要一个循环就
     * 可以处理任何项的集合。同时，女招待现在只使用一个接口，即 迭代器。
     * 虽然现在菜单的接口完全一样，但是，还是没有一个共同的接口，也就是
     * 说女招待仍然捆绑于两个具体的菜单类。
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
