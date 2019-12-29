package com.siwuxie095.forme.designpattern.category.chapter12th.example6th;

/**
 * @author Jiajing Li
 * @date 2019-11-10 09:20:59
 */
public class Main {

    /**
     * 加入观察者模式
     *
     * （14）首先，需要一个 Observable 接口。
     * 所谓的 Observable 就是被观察者的对象。Observable 需要注册、移除和通知观察者的方法。
     * 任何只要实现了 Observer 接口的对象都可以监听呱呱叫。创建一个 Observer 接口。然后需
     * 要确定所有的 Quackable 都实现此接口，所以直接让 Quackable 来扩展此接口。
     *
     * （15）现在必须确定所有实现 Quackable 的具体类都能扮演 Observable 的角色。
     * 原本需要在每一个具体类中实现注册、移除和通知，但这里要用稍微不一样的方法：在另一个被称
     * 为 QuackObservable 的类中封装注册、移除和通知的代码，然后将它和 Observable 组合在
     * 一起，这样，只需要一份代码即可，Observable 所有的调用都委托给 QuackObservable 辅助
     * 类。
     *
     * （16）整合 QuackObservable 辅助类和 Quackable 类。
     * 这里只要确定 Quackable 类是和 QuackObservable 类组合在一起的，并且它们知道怎样来委
     * 托工作。
     *
     * （17）几乎大功告成了！还需要把模式的 Observer 端完成。
     * 创建一个 Observer 接口，其中只有一个方法 update()，需要传入正在呱呱叫的对象 Observable。
     *然后需要一个具体观察者，也就是呱呱叫学家 Quackologist。
     *
     * （18）更新模拟器，准备开始观察。
     */
    public static void main(String[] args) {
        DuckSimulator duckSimulator = new DuckSimulator();
        AbstractDuckFactory duckFactory = new CountingDuckFactory();

        duckSimulator.simulate(duckFactory);
    }

}
