package com.siwuxie095.forme.designpattern.category.chapter12th.example2nd;

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
        // 通过把 Goose 包装进 GooseAdapter，就可以让鹅像鸭子一样。
        Quackable gooseDuck = new GooseAdapter(new Goose());

        System.out.println("Duck Simulator");
        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        // 一旦鹅被包装起来，就可以把它当作其他鸭子的 Quackable 对象。
        simulate(gooseDuck);
    }

    private void simulate(Quackable duck) {
        duck.quack();
    }

}
