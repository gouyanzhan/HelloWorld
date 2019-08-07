package com.siwuxie095.forme.designpattern.summary.pattern1st.strategy.example1st;

/**
 * @author Jiajing Li
 * @date 2019-08-07 22:14:08
 */
public class Main {

    public static void main(String[] args) {
        Duck mallardDuck = new MallardDuck();
        mallardDuck.performFly();
        mallardDuck.performQuack();
        System.out.println();

        Duck redheadDuck = new RedheadDuck();
        redheadDuck.performFly();
        redheadDuck.performQuack();
        System.out.println();

        Duck rubberDuck = new RubberDuck();
        rubberDuck.performFly();
        rubberDuck.performQuack();
        System.out.println();

        Duck decoyDuck = new DecoyDuck();
        decoyDuck.performFly();
        decoyDuck.performQuack();
        System.out.println();

        Duck modelDuck = new ModelDuck();
        modelDuck.performFly();
        modelDuck.performQuack();
        modelDuck.setFlyBehavior(new FlyRocketPowered());
        modelDuck.performFly();
        modelDuck.setQuackBehavior(new Quack());
        modelDuck.performQuack();
        System.out.println();
    }

}
