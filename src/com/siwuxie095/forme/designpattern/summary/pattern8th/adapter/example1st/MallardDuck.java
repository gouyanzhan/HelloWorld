package com.siwuxie095.forme.designpattern.summary.pattern8th.adapter.example1st;

/**
 * 绿头鸭
 *
 * @author Jiajing Li
 * @date 2019-11-04 15:27:30
 */
class MallardDuck implements Duck {

    @Override
    public void quack() {
        System.out.println("Quack");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying");
    }
}
