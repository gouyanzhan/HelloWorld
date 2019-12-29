package com.siwuxie095.forme.designpattern.category.chapter12th.example5th;

/**
 * @author Jiajing Li
 * @date 2019-11-10 09:20:59
 */
public class Main {

    /**
     * 加入组合模式
     *
     * （12）让我们创建一群鸭子 Quackable。
     * 组合模式允许像对待单个对象那样对待对象集合。没有什么模式比组合模式能更好的
     * 创建一群 Quackable 了。
     *
     * （13）修改模拟器。
     *
     *
     * 在组合模式中，组合对象和个别对象具有一组相同的方法，其中包括了 add() 方法。
     * 就因为有一组相同的方法，所以才能在个别对象上调用不起作用的方法，如 add()。
     * 这么设计的好处是，个别对象和组合对象之间是 "透明的"。客户根本不用关心究竟
     * 是组合对象还是个别对象，客户只是调用两者的同一个方法。
     *
     * 但是在这里，决定把组合对象维护孩子的方法和个别对象分开，即 只让 Flock 具有
     * add() 方法。因为已经知道给一个 Duck 添加某些东西是无意义的。这样的设计比较
     * "安全"，你不会调用无意义的方法，但是透明性比较差。现在客户如果想调用 add()，
     * 得先确定该 Quackable 对象是 Flock 才行。
     *
     * 在 OO 设计中，折衷一直都是免不了的，在创建你自己的组合中，需要考虑这些。
     *
     *
     * 现在又有了一个相反的要求：呱呱叫学家希望能够持续追踪个别鸭子的实时呱呱叫。也
     * 就是说，想要观察个别鸭子的行为。应该怎么办？使用观察者模式。
     */
    public static void main(String[] args) {
        DuckSimulator duckSimulator = new DuckSimulator();
        AbstractDuckFactory duckFactory = new CountingDuckFactory();

        duckSimulator.simulate(duckFactory);
    }

}
