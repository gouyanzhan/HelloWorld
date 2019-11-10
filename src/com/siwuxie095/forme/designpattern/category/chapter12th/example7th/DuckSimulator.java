package com.siwuxie095.forme.designpattern.category.chapter12th.example7th;

/**
 * 鸭子模拟器
 *
 * @author Jiajing Li
 * @date 2019-11-10 09:31:37
 */
class DuckSimulator {

    void simulate(AbstractDuckFactory duckFactory) {
        // 创建一个个 Quackable 对象
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable gooseDuck = duckFactory.createGooseDuck();

        System.out.println("Duck Simulator: With Composite - Flocks");

        // 创建一个鸭子主群
        Flock flockOfDucks = new Flock();
        // 将一个个 Quackable 对象加入鸭子主群
        flockOfDucks.add(redheadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(gooseDuck);

        // 创建一个绿头鸭群
        Flock flockOfMallards = new Flock();
        // 创建一个个绿头鸭
        Quackable mallard1st = duckFactory.createMallardDuck();
        Quackable mallard2nd = duckFactory.createMallardDuck();
        Quackable mallard3rd = duckFactory.createMallardDuck();
        Quackable mallard4th = duckFactory.createMallardDuck();
        // 将一个个绿头鸭加入绿头鸭群
        flockOfMallards.add(mallard1st);
        flockOfMallards.add(mallard2nd);
        flockOfMallards.add(mallard3rd);
        flockOfMallards.add(mallard4th);

        // 也将绿头鸭群加入鸭子主群
        flockOfDucks.add(flockOfMallards);

        // 创建一个呱呱叫学家，将它注册成为鸭子主群的观察者。
        Quackologist quackologist = new Quackologist();
        flockOfDucks.registerObserver(quackologist);

        // 测试鸭子主群
        System.out.println("Duck Simulator: Whole Flock Simulation");
        simulate(flockOfDucks);


        System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times");
    }

    private void simulate(Quackable duck) {
        duck.quack();
    }

}
