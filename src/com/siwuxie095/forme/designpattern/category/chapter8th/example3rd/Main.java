package com.siwuxie095.forme.designpattern.category.chapter8th.example3rd;

/**
 * @author Jiajing Li
 * @date 2019-11-05 14:19:31
 */
public class Main {

    /**
     * 更进一步的设计
     *
     * 不难发现，两份冲泡法其实都采用了相同的算法：
     * （1）把水煮沸
     * （2）用热水泡咖啡或茶
     * （3）把饮料倒进杯子
     * （4）在饮料中加入适当的调料
     *
     * 对于（2）（4）而言，也应该被抽出来，因为它们是一样的，只是应用在不
     * 同的饮料上。
     *
     * 也就是说可以把 prepareRecipe() 抽象化（泛化）。
     *
     * 对于（2）来说，咖啡是 brewCoffeeGrinds()，茶是 steepTeaBag()。
     * 显然，冲泡（brew）和浸泡（steep）差异不大，所以可以起一个新的方法
     * 名称 brew()。
     *
     * 对于（4）来说，咖啡是 addSugarAndMilk()，茶是 addLemon()。加糖
     * 和牛奶也和加柠檬很相似：都是在饮料中加入调料，所以也可以起一个新的方
     * 法名称 addCondiments()。
     *
     * 现在基类 CaffeineBeverage 中就有了新的 prepareRecipe() 方法。
     * 且被声明为 final，因为不希望子类覆盖这个方法。
     *
     * 因为咖啡和茶对于 brew() 和 addCondiments() 的处理方式不同，所以
     * 必须被声明为抽象，剩余的东西留给子类去操心。
     *
     *
     * 我们做了什么？
     * 已知两种冲泡法是基本相同的，只是一些步骤需要不同的实现。所以泛化了
     * 冲泡法 prepareRecipe()，把它放在基类中。
     *
     * 咖啡因饮料：
     * （1）把水煮沸
     * （2）冲泡
     * （3）把饮料倒进杯子
     * （4）加调料
     *
     * 咖啡因饮料了解和控制冲泡法的步骤，亲自执行步骤（1）和步骤（3），但
     * 依赖咖啡和茶来完成步骤（2）和步骤（4）。
     *
     *
     * 认识模板方法
     *
     * 基本上，这种实现就是模板方法模式。在咖啡因饮料 CaffeineBeverage
     * 的结构中，包含了实际的 "模板方法" prepareRecipe()。
     *
     * 因为：
     * （1）它是一个方法。
     * （2）它用作一个算法的模板。在本例中，算法是用来制作咖啡因饮料的。
     *
     * 在这个模板中，算法内的每一个步骤都被一个方法代表了。某些方法是由基
     * 类处理的，某些方法则是由子类处理的。需要由子类提供的方法，必须在基
     * 类中被声明为抽象。
     *
     * 模板方法定义了一个算法的步骤，并允许子类为一个或多个步骤提供实现。
     *
     *
     * 以茶的制作为例来追踪模板方法是如何工作的：
     *
     * 首先需要一个茶对象：
     * CaffeineBeverage tea = new Tea();
     *
     * 然后调用模板方法：
     * tea.prepareRecipe();
     * 它会依照算法来制作咖啡因饮料。
     *
     * 把水煮沸：
     * boilWater();
     * 这件事是在基类中进行的。
     *
     * 泡茶：
     * brew();
     * 这件事情只有子类才知道要怎么作。
     *
     * 把茶倒进杯子中：
     * pourInCup();
     * 所有的饮料做法都一样，所以这件事情发生在基类中。
     *
     * 加柠檬：
     * addCondiments();
     * 由于调料是各个饮料独有的，所以这件事情由子类来实现。
     *
     * 即 prepareRecipe() 方法控制了算法，没有人能够改变它。这个方法也
     * 会依赖子类来提供某些或所有步骤的实现。
     *
     *
     * 模板方法带给我们什么？
     * 在 example1st 和 example2nd 中，Coffee 和 Tea 主导一切，它们
     * 控制了算法。Coffee 和 Tea 之间存在重复的代码。对于算法所做的代码
     * 改变，需要打开子类修改许多地方。由于类的组织方式不具有弹性，所以加
     * 入新种类的咖啡因饮料需要做许多工作。算法的知识和它的实现也会分散在
     * 许多类中。
     * 在 example3rd 中（本例），由 CaffeineBeverage 类主导一切，它
     * 拥有算法，而且保护这个算法。对子类来说，CaffeineBeverage 类的存
     * 在，可以将代码的复用最大化。算法只存在于一个地方，所以容易修改。这
     * 个模板方法提供了一个框架，可以让其他的咖啡因饮料插进来。新的咖啡因
     * 饮料只需要实现自己的方法就可以了。CaffeineBeverage 类专注在算法
     * 本身，而由子类提供完整的实现。
     */
    public static void main(String[] args) {
        CaffeineBeverage coffee = new Coffee();
        coffee.prepareRecipe();

        System.out.println();

        CaffeineBeverage tea = new Tea();
        tea.prepareRecipe();
    }

}
