package com.siwuxie095.forme.designpattern.category.chapter9th.example4th;

/**
 * @author Jiajing Li
 * @date 2019-11-06 08:30:26
 */
public class Main {

    /**
     * 使用 Java 自带的迭代器 Iterator
     *
     *
     * 由于 List 自带有创建迭代器的方法 iterator()，所以 BreakfastMenu
     * 就不再需要单独的迭代器了。
     *
     * 而数组并没有创建迭代器的方法，所以仍然需要为 LunchMenu 实现一个迭代
     * 器。
     *
     * 注意：Java 自带的迭代器 Iterator 比自己实现的迭代器 Iterator 多了
     * 一个 remove() 方法。
     *
     *
     * 疑问与解答：
     *
     * 问：
     * 如果我不想让客户具备删除的能力，该怎么办？
     * 答：
     * remove() 方法其实是可有可无的，不一定要提供删除的功能。但是，很明显
     * 的，你需要提供这样的方法，因为毕竟它被声明在 Iterator 接口中。如果你
     * 不允许 remove() 的话，可以抛出一个 UnsupportedOperationException
     * 运行时异常。
     * Iterator 的 API 文件提到可以让 remove() 抛出这样的异常，而任何良好
     * 的客户程序只要调用了 remove() 方法，就应该检查是否会发生这个异常。
     *
     * 问：
     * 在多线程的情况下，可能会有多个迭代器引用同一个对象集合。remove() 会
     * 造成怎样的影响？
     * 答：
     * 后果并没有指明，所以很难预料。当你的程序在多线程的代码中使用到迭代器
     * 时，必须特别小心。
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
