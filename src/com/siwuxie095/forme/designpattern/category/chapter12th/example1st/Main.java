package com.siwuxie095.forme.designpattern.category.chapter12th.example1st;

/**
 * @author Jiajing Li
 * @date 2019-11-10 09:20:59
 */
public class Main {

    /**
     * 复合模式：模式的模式
     *
     * 在设计中携手合作征服许多问题的模式，就叫做 复合模式（Compound Pattern），
     * 也就是由模式所构成的模式。
     *
     * 这里将以鸭子模拟器为例，来进行介绍复合模式。通过它来学习模式如何携手合作来
     * 解决同一件事。但是，将某些模式结合使用，并不代表这些模式就够资格称为复合模
     * 式。复合模式必须够一般性，适合解决许多问题才行。所以后面会介绍一个真正的复
     * 合模式，也就是大名鼎鼎的 MVC（Model-View-Controller）。
     *
     *
     * 小结：
     * （1）模式通常被一起使用，并被组合在同一个设计方案中。
     * （2）复合模式在一个解决方案中结合两个或多个模式，以解决一般或重复发生的问题。
     * （3）复合模式不是二十三种设计模式中的一个。
     *
     *
     * 开始设计鸭子模拟器
     *
     * （1）创建一个 Quackable 接口。
     *
     * （2）某些鸭子实现 Quackable 接口。
     * 比如：MallardDuck 绿头鸭、RedheadDuck 红头鸭、DuckCall 鸭鸣器、RubberDuck 橡皮鸭。
     *
     * （3）有了鸭子还需要一个鸭子模拟器 DuckSimulator。
     *
     * （4）当鸭子出现在这里时，鹅应该也在附近。
     * 现在想要在所有使用鸭子的地方使用鹅，毕竟鹅会飞、会叫、会游，和鸭子差不多。
     *
     *
     * 应该怎么办？使用适配器模式。
     */
    public static void main(String[] args) {
        DuckSimulator duckSimulator = new DuckSimulator();
        duckSimulator.simulate();
    }

}
