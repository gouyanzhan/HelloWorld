package com.siwuxie095.forme.designpattern.category.chapter1st.example4th;

/**
 * @author Jiajing Li
 * @date 2019-08-06 22:26:23
 */
public class Main {

    /**
     * 九个 OO 原则之第三个设计原则：
     * 多用组合，少用继承。
     *
     *
     * 这样的设计，可以让飞行和呱呱叫的动作被其他的对象复用，
     * 因为这些行为已经与鸭子类无关了。
     * 同时也可以新增一些行为，不会影响到既有的行为类，也不会
     * 影响 "使用" 到飞行行为/呱呱叫行为的鸭子类。
     *
     * 关键在于，鸭子现在会将飞行和呱呱叫的动作 "委托"（delegate）
     * 别人处理，而不是使用定义在 Duck 类（或子类）内的呱呱叫
     * 和飞行方法。
     * 委托之后，Duck 对象只要叫 flyBehavior 对象去飞行就可
     * 以了，并不在乎 flyBehavior 接口的对象到底是什么，只关
     * 心该对象知道如何飞行就够了。
     * quackBehavior 对象同理。
     *
     * 不难发现，这里的飞行行为（呱呱叫行为）其实是一组行为，可以
     * 看成是一族算法。
     *
     * 这里，类之间的关系有：
     * （1）是一个（IS-A）（继承）
     * （2）有一个（HAS-A）（组合）
     * （3）实现（IMPLEMENTS）
     *
     * "有一个" 可能比 "是一个" 更好。
     *
     * 这里，有一个的关系即：每一个鸭子都有一个 FlyBehavior 和
     * 一个 QuackBehavior，好将飞行和呱呱叫委托给它们代为处理。
     *
     * 当你将两个类结合起来使用，这就是组合（composition）。
     *
     * 这种做法和继承不同的地方在于，鸭子的行为不是 "继承" 来的，
     * 而是和适当的行为对象 "组合" 来的。
     *
     * 使用组合建立系统具有很大的弹性，不仅可将算法族封装成类，更
     * 可以 "在运行时动态的改变行为"，只要组合的行为对象符合正确
     * 的接口标准即可。
     * 组合在许多设计模式中都有使用。
     *
     */
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
        System.out.println();
    }

}
