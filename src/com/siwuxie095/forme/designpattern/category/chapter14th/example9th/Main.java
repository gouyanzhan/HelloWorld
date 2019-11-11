package com.siwuxie095.forme.designpattern.category.chapter14th.example9th;

import javax.sound.midi.Soundbank;

/**
 * @author Jiajing Li
 * @date 2019-11-11 18:54:55
 */
public class Main {

    /**
     * 解释器模式
     *
     * 为语言创建解释器。
     *
     * 当需要实现一个简单的语言时，就使用解释器模式定义语法的类，
     * 并用一个解释器解释句子。每个语法规则都用一个类代表。即 类
     * 直接映射到语法。
     *
     * 要想解释这种语言，就调用每个表达式类型的 interpret() 方
     * 法。此方法需要传入一个上下文（Context），也就是正在解析的
     * 语言字符串输入流，然后进行比对并采取适当的动作。
     *
     * 现在要用语言来控制鸭子，让它们：向右转、呱呱叫和飞行。
     *
     *
     * 解释器的优点：
     * （1）将每一个语法规则表示成一个类，方便于实现语言。
     * （2）因为语法有许多类表示，所以可以轻易地改变或扩展此语言。
     * （3）通过在类结构中加入新的方法，可以在解释的同时增加新的
     * 行为，例如：打印格式的美化或者进行复杂的程序验证。
     *
     * 解释器的用途和缺点：
     * （1）当需要实现一个简单的语言时，使用解释器。
     * （2）当你有一个简单的语法，而且简单比效率更重要时，使用解
     * 释器。
     * （3）可以处理脚本语言和编程语言。
     * （4）当语法规则的数目太大时，这个模式可能会变得非常繁杂。
     * 在这种情况下，使用解析器/编译器的产生器可能更合适。
     */
    public static void main(String[] args) {
        Expression rightExpression = new RightExpression();
        boolean res1 = rightExpression.interpret("right");
        System.out.println(res1);

        Expression quackExpression = new QuackExpression();
        boolean res2 = quackExpression.interpret("quack");
        System.out.println(res2);

        Expression flyExpression = new FlyExpression();
        boolean res3 = flyExpression.interpret("fly");
        System.out.println(res3);
    }

}
