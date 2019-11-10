package com.siwuxie095.forme.designpattern.category.chapter12th.example2nd;

/**
 * @author Jiajing Li
 * @date 2019-11-10 09:20:59
 */
public class Main {

    /**
     * 加入适配器模式
     *
     * （5）需要鹅适配器。
     * 既然鹅不会呱呱叫。可以利用适配器将鹅适配成鸭子。
     *
     * （6）现在，模拟器中也应该可以使用鹅了。
     * 创建 Goose 对象，将它包装进适配器，以便实现 Quackable。
     *
     * （7）测试一下
     * 看看结果中是否会出现鹅的咯咯叫。
     *
     *
     * 现在呱呱叫学家想要知道在一群鸭子中，会有多少呱呱叫声？所以，要如何在不变化
     * 鸭子类的情况下，计算呱呱叫的次数呢？使用装饰者模式。
     *
     *
     */
    public static void main(String[] args) {
        DuckSimulator duckSimulator = new DuckSimulator();
        duckSimulator.simulate();
    }

}
