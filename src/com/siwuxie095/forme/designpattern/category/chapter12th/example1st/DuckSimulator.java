package com.siwuxie095.forme.designpattern.category.chapter12th.example1st;

/**
 * 鸭子模拟器
 *
 * @author Jiajing Li
 * @date 2019-11-10 09:31:37
 */
class DuckSimulator {

    void simulate() {
        Quackable mallardDuck = new MallardDuck();
        Quackable redheadDuck = new RedheadDuck();
        Quackable duckCall = new DuckCall();
        Quackable rubberDuck = new RubberDuck();

        System.out.println("Duck Simulator");
        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
    }

    private void simulate(Quackable duck) {
        duck.quack();
    }

}
