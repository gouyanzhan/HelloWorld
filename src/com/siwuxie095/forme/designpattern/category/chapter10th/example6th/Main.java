package com.siwuxie095.forme.designpattern.category.chapter10th.example6th;

/**
 * @author Jiajing Li
 * @date 2019-11-08 12:57:38
 */
public class Main {

    /**
     * 需要改进的地方
     *
     * （1）在 SoldState 和 WinnerState 中，有许多重复的代码，必须要清理。
     * 可以把 State 设计成抽象类，然后把方法的默认行为放在其中。毕竟很多提示
     * 信息，不会被顾客看到。比如，"You inserted a coin"。所以，所有的
     * "错误响应" 行为都可以写的具有通用性，并放在抽象类中供子类继承。
     *
     * （2）dispense() 方法即使是在 NoCoinState 状态下，曲柄被转动时也总
     * 是会被调用。这个很好修改，可以让 turnCrank() 返回一个布尔值，或者引
     * 入异常。
     *
     * （3）实例化多个 GumballMachine 对象时，需要把状态的实例移动到静态的
     * 实例变量中共享。
     *
     *
     * 模式与描述的配对：
     *
     * （1）状态模式：
     * 封装基于状态的行为，并将行为委托到当前状态。
     *
     * （2）策略模式：
     * 将可以互换的行为封装起来，然后使用委托的方法，决定使用哪一个行为。
     *
     * （3）模板方法模式：
     * 由子类决定如何实现算法中的某些步骤。
     */
    public static void main(String[] args) {
        GumballMachine gumballMachine1 = new GumballMachine(5);
        System.out.println(gumballMachine1);
        System.out.println();

        gumballMachine1.insertCoin();
        gumballMachine1.turnCrank();
        System.out.println(gumballMachine1);
        System.out.println();

        System.out.println();
        System.out.println();
        System.out.println();

        GumballMachine gumballMachine2 = new GumballMachine(5);
        System.out.println(gumballMachine2);
        System.out.println();

        gumballMachine2.insertCoin();
        gumballMachine2.turnCrank();
        System.out.println(gumballMachine2);
        System.out.println();

        System.out.println();
        System.out.println();
        System.out.println();

        GumballMachine gumballMachine3 = new GumballMachine(5);
        System.out.println(gumballMachine3);
        System.out.println();

        gumballMachine3.insertCoin();
        gumballMachine3.turnCrank();
        System.out.println(gumballMachine3);
        System.out.println();
    }

}
