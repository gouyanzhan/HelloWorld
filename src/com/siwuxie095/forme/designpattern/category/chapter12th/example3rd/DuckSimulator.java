package com.siwuxie095.forme.designpattern.category.chapter12th.example3rd;

/**
 * 鸭子模拟器
 *
 * @author Jiajing Li
 * @date 2019-11-10 09:31:37
 */
class DuckSimulator {

    void simulate() {
        /*
         * 每创建一个 Quackable 对象，就用一个新的装饰者包装它。
         *
         * 由于这里不想计入鹅的叫声，所以不去装饰鹅。
         */
        Quackable mallardDuck = new QuackCounter(new MallardDuck());
        Quackable redheadDuck = new QuackCounter(new RedheadDuck());
        Quackable duckCall = new QuackCounter(new DuckCall());
        Quackable rubberDuck = new QuackCounter(new RubberDuck());
        Quackable gooseDuck = new GooseAdapter(new Goose());

        System.out.println("Duck Simulator");
        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseDuck);

        System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times");
    }

    private void simulate(Quackable duck) {
        duck.quack();
    }

}
