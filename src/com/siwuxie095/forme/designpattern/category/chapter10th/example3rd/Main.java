package com.siwuxie095.forme.designpattern.category.chapter10th.example3rd;

/**
 * @author Jiajing Li
 * @date 2019-11-08 12:57:38
 */
public class Main {

    /**
     * 新的设计
     *
     * 应该试着局部化每个状态的行为，这样一来，如果针对某个状态做了改变，
     * 就不会把其他的代码给搞乱了。也就是封装变化。
     *
     * 如果将每个状态的行为都放在各自的类中，那么每个状态只要实现它自己
     * 的动作就可以了。
     *
     * 此时，糖果机就只需要委托给代表当前状态的状态对象。
     *
     *
     * 定义状态接口和类
     *
     * 首先创建一个 State 接口，所有的状态都必须实现这个接口。其中的
     * 方法映射到糖果机上可能发生的动作。然后将设计中的每个状态都封装
     * 成一个类，每个都实现 State 接口。
     *
     * 现在不考虑赢家状态，一共有 4 个状态：
     * （1）NoCoinState 没有投币状态
     * （2）HasCoinState 已经投币状态
     * （3）SoldState 正在出货状态
     * （4）SoldOutState 售罄状态
     *
     * 对应的，也有 4 个动作：
     * （1）insertCoin() 投入硬币
     * （2）ejectCoin() 退回硬币
     * （3）turnCrank() 转动曲柄
     * （4）dispense() 发放糖果
     *
     * 把 GumballMachine 中原来用整数表示的状态改为用状态对象。同
     * 时，GumballMachine 的动作都委托给当前状态对象来处理。
     *
     * 对于每一个状态来说，其中都有一些不太恰当的动作，也就是异常动作。
     * 这时候给出提示即可。
     *
     * 现在，通过从结构上改变实现，已经做到了以下几点：
     * （1）将每个状态的行为局部化到它自己的类中。
     * （2）将容易产生问题的 if 语句删除，以方便日后的维护。
     * （3）让每个状态 "对修改关闭"，让糖果机 "对扩展开放"，因为可以
     * 加入新的状态类。
     */
    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine(5);
        System.out.println(gumballMachine);
        System.out.println();

        gumballMachine.insertCoin();
        gumballMachine.turnCrank();
        System.out.println(gumballMachine);
        System.out.println();

        gumballMachine.insertCoin();
        gumballMachine.ejectCoin();
        gumballMachine.turnCrank();
        System.out.println(gumballMachine);
        System.out.println();

        gumballMachine.insertCoin();
        gumballMachine.turnCrank();
        gumballMachine.insertCoin();
        gumballMachine.turnCrank();
        gumballMachine.ejectCoin();
        System.out.println(gumballMachine);
        System.out.println();

        gumballMachine.insertCoin();
        gumballMachine.insertCoin();
        gumballMachine.turnCrank();
        gumballMachine.insertCoin();
        gumballMachine.turnCrank();
        gumballMachine.insertCoin();
        gumballMachine.turnCrank();
        System.out.println(gumballMachine);
    }

}
