package com.siwuxie095.forme.designpattern.category.chapter3rd.example4th;

/**
 * @author Jiajing Li
 * @date 2019-10-10 13:48:40
 */
public class Main {

    /**
     * 饮料 Beverage 相当于组件 Component，而四种具体饮料 HouseBlend、DarkRoast、Decaf、Espresso
     * 则相当于四个具体组件 ConcreteComponent。调料 Condiment 相当于装饰者 Decorator，而四种具体调料
     * SteamedMilk、Soy、Mocha、Whip 则相当于四个具体装饰者 ConcreteDecorator。
     *
     *
     * 在继承与组合之间，观念有一些混淆，值得梳理一下：
     *
     * 问：
     * 原以为在这个模式中不会使用继承，而是要利用组合取代继承。但是现在 Condiment 却扩展自 Beverage，这
     * 用到了继承。
     * 答：
     * 的确如此，但这么做的重点在于，装饰者和被装饰者必须是一样的类型，也就是有共同的超类，这是相当关键的地
     * 方。在这里，利用继承达到 "类型匹配"，而不是利用继承获得 "行为"。
     *
     * 问：
     * 知道了为什么装饰者需要和被装饰者（被包装的组件）有相同的 "接口"，因为装饰者必须能取代被装饰者。但是行
     * 为从哪里来？
     * 答：
     * 当将装饰者和组件组合时，就是在加入新的行为。所得到的新行为，并不是继承自超类，而是由组合对象得来的。即
     * 继承 Beverage 抽象类，是为了有正确的类型，而不是继承它的行为，行为来自装饰者与组件，或者与其他装饰者
     * 之间的组合关系。
     * 而且因为使用对象组合，可以把所有饮料和调料更有弹性地加以混合与匹配，非常方便。如果依赖继承，那么类的行
     * 为只能在编译时静态决定。换句话说，行为如果不是来自超类，就是子类覆盖后的版本。反之，利用组合，可以把装
     * 饰者混合着用，而且是在运行时。
     *
     * 问：
     * 这里需要继承的是组件类型，为什么不把 Beverage 类设计成一个接口，而是设计成一个抽象类？
     * 答：
     * 通常来说，装饰者模式是采用抽象类，但是在 Java 中可以使用接口。即 组件和装饰者都可以替换成接口的形式。
     *
     *
     * 除了混淆之外，还有一些其他的疑问：
     *
     * 问：
     * 如果将代码针对特定种类的具体组件（如：HouseBlend），做一些特殊的事情（如：打折），担心这样的设计是
     * 否恰当。因为一旦用装饰者包装 HouseBlend 就会造成类型改变。
     * 答：
     * 的确是这样。如果把代码写成依赖具体的组件类型，那么装饰者就会导致程序出问题，只要在针对抽象组件类型
     * 编程时，才不会因为装饰者受到影响。但是，如果的确针对特定的具体组件编程，就应该重新思考你的应用架构，
     * 以及装饰者是否适合。
     *
     * 问：
     * 对于使用到饮料的某些客户来说，会不会不容易使用最外圈的装饰者呢？比如，如果有深焙咖啡，以摩卡、豆浆、
     * 奶泡来装饰，引用到豆浆而不是奶泡，代码会好写一些，这意味着订单里没有奶泡了（人为因素）。
     * 答：
     * 当然是可以争辩说，使用装饰者模式必须管理更多的对象，所以犯下你所说的编码错误的机会会增加。但是装饰
     * 者通常是用其他类似于工厂或生成器这样的模式创建的。这时，对于具体的组件以及装饰者的创建过程，会被封
     * 装的很好，所以不会有这种问题。
     *
     * 问：
     * 装饰者知道这一连串装饰链条中其他装饰者的存在吗？比如，想要让 getDescription() 列出 "Whip, Double
     * Mocha"，而不是列出 "Mocha, Whip, Mocha"，这需要最外圈的装饰者知道有哪些装饰者牵涉其中了。
     * 答：
     * 装饰者该做的事，就是增加行为到被包装对象上。当需要窥视装饰者链中的每一个装饰者时，这就超出他们的天赋了。
     * 但是并不是做不到，可以写一个 CondimentPrettyPrint 装饰者，解析出最后的描述字符串，然后把 "Mocha,
     * Whip, Mocha" 变成 "Whip, Double Mocha"。如果能把 getDescription() 返回值变成 ArrayList 类型，
     * 让每个调料名称独立开，那么 CondimentPrettyPrint 会更容易编写。
     * （CondimentPrettyPrint 即 调料美化打印，选好饮料和调料后，最后再用它包装一下即可）
     */
    public static void main(String[] args) {
        {
            Beverage houseBlend = new HouseBlend();
            System.out.println(houseBlend.getDescription() + " $" + houseBlend.cost());

            houseBlend = new Mocha(houseBlend);
            System.out.println(houseBlend.getDescription() + " $" + houseBlend.cost());

            houseBlend = new Mocha(houseBlend);
            System.out.println(houseBlend.getDescription() + " $" + houseBlend.cost());

            houseBlend = new Whip(houseBlend);
            System.out.println(houseBlend.getDescription() + " $" + houseBlend.cost());
        }

        System.out.println();

        {
            Beverage darkRoast = new DarkRoast();
            System.out.println(darkRoast.getDescription() + " $" + darkRoast.cost());

            darkRoast = new SteamedMilk(darkRoast);
            darkRoast = new Soy(darkRoast);
            darkRoast = new Mocha(darkRoast);
            darkRoast = new Whip(darkRoast);
            System.out.println(darkRoast.getDescription() + " $" + darkRoast.cost());
        }

    }

}
