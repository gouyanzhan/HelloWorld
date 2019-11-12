package com.siwuxie095.forme.designpattern.summary.pattern19th.interpreter.example1st;

/**
 * @author Jiajing Li
 * @date 2019-11-11 18:54:55
 */
public class Main {

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
