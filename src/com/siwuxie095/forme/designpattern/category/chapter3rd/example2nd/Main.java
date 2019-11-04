package com.siwuxie095.forme.designpattern.category.chapter3rd.example2nd;

/**
 * @author Jiajing Li
 * @date 2019-10-09 20:44:01
 */
public class Main {

    /**
     * 利用实例变量和继承来追踪所有的调料。
     *
     * Beverage 不再是抽象类，而是一个普通的父类，负责维护所有调料的价格，以及计算要
     * 加入的各种调料的价格。
     *
     * 子类仍覆盖父类的 cost() 方法，计算出各种饮料加上调料的价格。
     *
     * 此时，一共只需要五个类即可。
     *
     * 但这种做法依然会有如下潜在的问题：
     * （1）调料价格的改变会使现有代码发生更改。
     * （2）一旦出现新的调料，就需要加上新的变量和方法，并改变父类中的 cost() 方法。
     * （3）以后可能会开发出新饮料，对这些饮料而言（如：茶），某些调料可能并不适合，
     * 但是在这个设计方式中，Tea 子类仍将继承那些不适合的方法，如：setWhip()（即
     * 加奶泡）。
     * （4）万一顾客想要双倍摩卡，怎么办？显然在这种做法下是不能实现的。
     *
     *
     * 所以，尽管继承威力强大，但它并不总是能够实现最有弹性和最好维护的
     * 设计。
     * 而利用组合（composition）和委托（delegation）可以在运行时具有
     * 继承行为的效果。
     * 利用继承设计子类的行为，是在编译时静态决定的，而且所有的子类都会
     * 继承到相同的行为，然而如果能够利用组合的做法扩展对象的行为，就可
     * 以在运行时动态的进行扩展。可以利用此技巧把多个新职责，甚至是设计
     * 超类时还没有想到的职责加在对象上。而且，不用修改原来的代码。
     * 通过动态的组合对象，可以写新的代码添加新功能，而无须修改现有代码。
     * 既然没有修改现有代码，那么引进 bug 或产生意外副作用的机会将大幅
     * 度减少。
     * 即 代码应该如同晚霞中的莲花一样关闭（免于改变），如同晨曦中的莲
     * 花一样地开放（能够扩展）。
     *
     * 运行时扩展，远比编译时期的继承威力大。
     *
     *
     * 九个 OO 原则之第五个设计原则：
     * 类应该对扩展开放，对修改关闭。
     *
     * 目标是允许类容易扩展，在不修改现有代码的情况下，就可搭配新的行为。如能实现这样
     * 的目标，有什么好处呢？这样的设计具有弹性可以应对改变，可以接受新的功能来应对改
     * 变的需求。
     *
     * 问：
     * 对扩展开放，对修改关闭。听起来很矛盾。设计如何兼顾两者？
     * 答：
     * 乍听之下，的确感到矛盾。毕竟越难修改的事物，就越难以扩展。但是有一些OO技巧，
     * 允许系统在不修改代码的情况下，进行功能扩展。比如：观察者模式。通过加入新的
     * 观察者 Observer，可以在任何时候扩展主题 Subject，而且不需要向主题中添加
     * 代码。
     *
     * 问：
     * 如何将某件东西设计成可以扩展，又禁止修改？
     * 答：
     * 许多模式经过长期经验的实证，可通过提供扩展的方法来保护代码免于被修改。比如：
     * 装饰者模式，完全遵循开放-关闭原则。
     *
     * 问：
     * 如何让设计的每个部分都遵循开放-关闭原则？
     * 答：
     * 通常，这是办不到的。要让OO设计同时具备开放性和关闭性，又不修改现有的代码，需要
     * 花费许多时间和努力。一般来说，实在没有闲工夫把设计的每个部分都这么设计（而且就算
     * 做得到，也可能只是一种浪费）。遵循开放-关闭原则，通常会引入新的抽象层次，增加代
     * 码的复杂度。你只需要把注意力集中在设计中最有可能改变的地方，然后应用开放-关闭原则。
     *
     * 问：
     * 怎么知道哪些地方的改变是更重要呢？
     * 答：
     * 这牵涉到设计OO系统的经验，和你对工作领域的了解。多看多学多做，就能辨别设计中的
     * 变化区。
     *
     * 总结：
     * 虽然似乎有些矛盾，但是的确有一些技术可以允许在不直接修改代码的情况下对其进行扩
     * 展。
     * 在选择需要被扩展的代码部分时要小心。每个地方都采用开放关闭原则，是一种浪费，也
     * 没必要，还会导致代码变得复杂且难以理解。
     */
    public static void main(String[] args) {
        Beverage houseBlend = new HouseBlend();
        System.out.println("House Blend Cost: " + houseBlend.cost());

        houseBlend.setMocha(true);
        System.out.println("House Blend With Mocha Cost: " + houseBlend.cost());
    }

}