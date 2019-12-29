package com.siwuxie095.forme.designpattern.category.chapter12th.example4th;

/**
 * @author Jiajing Li
 * @date 2019-11-10 09:20:59
 */
public class Main {

    /**
     * 加入抽象工厂模式
     *
     * （10）需要用工厂产生鸭子。
     * 现在需要一些质量确保鸭子一定是被包装起来的。所以要建造一个工厂，创建装饰过的鸭子。
     * 此工厂应该生产各种不同类型的鸭子的产品家族，所以要用抽象工厂模式。
     *
     * 分别创建两个具体工厂：
     * 一个创建没有装饰过的鸭子 DuckFactory，一个创建装饰过的鸭子 CountingDuckFactory。
     *
     * （11）设置模拟器来使用这个工厂。
     * 创建一个多态的方法，此方法需要用来创建对象的工厂。通过传入不同的工厂，就会得到不
     * 同的产品家族。
     *
     *
     * 现在想要分别管理这些鸭子变得有些困难了，希望能够作为一个整体来管理这些鸭子，甚至
     * 希望只管理几个想持续追踪的鸭子家族。也就是说，想要管理一群鸭子，应该怎么办？
     *
     * 需要将鸭子视为一个集合，甚至是子集合（subcollection），如果下一次命令，就能让整
     * 个集合或某子集合的鸭子听命行事，那就好了。使用什么模式呢？组合模式。
     */
    public static void main(String[] args) {
        DuckSimulator duckSimulator = new DuckSimulator();
        AbstractDuckFactory duckFactory = new CountingDuckFactory();

        duckSimulator.simulate(duckFactory);
    }

}
