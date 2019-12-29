package com.siwuxie095.forme.designpattern.category.chapter12th.example7th;

/**
 * @author Jiajing Li
 * @date 2019-11-10 09:20:59
 */
public class Main {

    /**
     * （19）最后将这只孤零零的鹅，也改为由抽象鸭子工厂进行生产。
     *
     * （20）修改模拟器。
     *
     * 疑问与解答：
     *
     * 问：
     * 这就是复合模式？
     * 答：
     * 不，这只是一群模式携手合作。所谓的复合模式，是指一群模式被结合起来
     * 使用，以解决一般性问题。接下来就会说 Model-View-Controller（模
     * 型-视图-控制器）复合模式。它是由数个模式结合起来而形成的新模式，一
     * 再被用来解决许多设计问题。
     *
     * 问：
     * 所以，设计模式真正漂亮的地方在于，遇到问题时，可以拿模式逐一地解决
     * 问题，直到所有的问题都被解决。我这样说对吗？
     * 答：
     * 错。在鸭子的例子中，之所以这么做，主要目的是展示许多模式可以合作。
     * 在真实的设计过程中，你不会想要这么做的。事实上，鸭子模拟器的许多部
     * 分都可以用模式解决，只是有一点 "杀鸡焉用宰牛刀" 的感觉。有时候，用
     * 好的 OO 设计原则就可以解决问题，这样其实就够了。
     * 采用模式时必须要考虑这么做是否有意义。绝对不能为了使用模式而使用模
     * 式。有了这样的概念，鸭子模拟器的设计看起来就显得做作。但是，这个例
     * 子有趣，而且过程中可以体会到多个模式是如何携手解决一个问题的。
     *
     *
     * 总的来说
     *
     * （1）从一大堆的 Quackable 开始...
     *
     * （2）有一只鹅出现了，它希望自己像一个 Quackable。
     * 所以利用适配器模式，将鹅适配成 Quackable，现在就可以调用鹅适配器
     * 的 quack() 方法来让鹅咯咯叫。
     *
     * （3）然后呱呱叫学家决定要计算呱呱叫的次数。
     * 所以使用装饰者模式，添加了一个名为 QuackCounter 的装饰者。它用来
     * 追踪 quack() 被调用的次数，并将调用委托给它所装饰的Quackable 对
     * 象。
     *
     * （4）但是呱呱叫学家担心他们忘了加上 QuackCounter 装饰者。
     * 所以使用抽象工厂模式，创建鸭子。从此之后，当需要鸭子时，就直接跟工
     * 厂要，工厂会给他们装饰过的鸭子。当然，如果想要没有装饰的鸭子，用另
     * 一个工厂就可以。
     *
     * （5）又是鸭子，又是鹅，又是 Quackable 的... 有了管理上的困扰。
     * 所以使用组合模式，将许多 Quackable 集结成一个群。这个模式也允许
     * 群中有群，以便让呱呱叫学家来管理鸭子家族。在实现中通过使用 List
     * 中的 java.util.Iterator 而使用了迭代器模式。
     *
     * （6）当任何呱呱声响起时，呱呱叫学家都希望能被告知。
     * 所以使用观察者模式，让呱呱叫学家注册成为观察者。现在，当呱呱叫声响
     * 起时，呱呱叫学家就会被通知了。在这个实现中，再度使用到迭代器。呱呱
     * 叫学家不仅可以当某个鸭子的观察者，甚至可以当一整群鸭子的观察者。
     */
    public static void main(String[] args) {
        DuckSimulator duckSimulator = new DuckSimulator();
        AbstractDuckFactory duckFactory = new CountingDuckFactory();

        duckSimulator.simulate(duckFactory);
    }

}
