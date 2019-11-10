package com.siwuxie095.forme.designpattern.category.chapter12th.example3rd;

/**
 * @author Jiajing Li
 * @date 2019-11-10 09:20:59
 */
public class Main {

    /**
     * 加入装饰者模式
     *
     * （8）现在让呱呱叫学家满意，让他们知道叫声的次数。
     * 怎么才能办到呢？创建一个装饰者，通过把鸭子包装进装饰者对象，给鸭子一些
     * 新行为（计算次数的行为）。这样，不必修改鸭子的代码。
     *
     * （9）需要更新模拟器，以便创建被装饰的鸭子。
     * 现在，必须将被实例化的每个 Quackable 对象包装在 QuackCounter 装饰者
     * 中。如果不这么做，就无法统计其叫声次数。
     *
     *
     * 现在发现有许多鸭子的叫声没有被统计进来，应该怎么办？
     * 你必须装饰对象来获得被装饰过的行为。也就是说，在包装对象的时候：有包装
     * 才有效果，没包装就没有效果。
     * 所以，应该将创建鸭子的程序集中在一个地方。也就是说，将创建和装饰的部分
     * 包装起来。
     * 即 使用抽象工厂模式。
     */
    public static void main(String[] args) {
        DuckSimulator duckSimulator = new DuckSimulator();
        duckSimulator.simulate();
    }

}
