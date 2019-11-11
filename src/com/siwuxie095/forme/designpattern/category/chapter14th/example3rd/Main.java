package com.siwuxie095.forme.designpattern.category.chapter14th.example3rd;

/**
 * @author Jiajing Li
 * @date 2019-11-11 15:36:57
 */
public class Main {

    /**
     * 生成器模式
     *
     * 封装一个产品的构造过程，并允许按步骤构造。
     *
     *
     * 现在假期临近，需要提前安排假期计划表，第一天干什么，第二天干什么...
     * 每一天的计划可能都不一样，比如有的天数不需要住旅馆，有的天数没有特殊
     * 活动，有的天数去的地方不需要门票。
     * 所以，需要有一个弹性的数据结构，来代表你的假期计划，以及所有的变化。
     * 也需要遵照一系列潜在的复杂顺序，创建这样的假期计划。那么要如何才能提
     * 供这样一种方式来创建这个复杂的结构，而不会和创建它的步骤混在一起呢？
     *
     * 使用生成器模式，将假期计划的创建过程，封装到一个对象中（称此对象为生
     * 成器），然后让客户调用生成器创建假期计划。
     *
     *
     * 生成器的优点：
     * （1）将一个复杂对象的创建过程封装起来。
     * （2）允许对象通过多个步骤来创建，并且可以改变过程。
     * （3）向客户隐藏产品内部的表现。
     * （4）产品的实现可以被替换，因为客户只看到一个抽象的接口。
     *
     * 生成器的用途和缺点：
     * （1）经常被用来创建组合结构。
     * （2）与工厂模式相比，采用生成器模式创建对象的客户，需要
     * 具备更多的领域知识。
     *
     * PS：生成器模式也被称为建造者模式。
     */
    public static void main(String[] args) {
        AbstractBuilder builder = new ConcreteBuilder();
        Client client = new Client(builder);
        VacationPlanner planner = client.constructVacationPlanner();
        System.out.println(planner);
    }

}
