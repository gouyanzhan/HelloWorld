package com.siwuxie095.forme.designpattern.category.chapter2nd.example4th;

/**
 * @author Jiajing Li
 * @date 2019-08-11 17:19:10
 */
public class Main {

    /**
     * 使用 Java 内置的观察者模式
     *
     * 在 java.util 包中包含了基本的 Observer 接口和 Observable 类，这和
     * 自定义的 Observer 接口和Subject 接口类似。甚至可以使用推（push）或拉
     * (pull)的方式传送数据。
     *
     * Observer 即观察者，Observable 即可观察者（被观察者、主题）
     *
     * 此时，如何把对象变成观察者？只需要实现 Observer 接口即可。然后调用任何
     * Observable 对象的 addObserver() 方法。不想再当观察者时，调用
     * deleteObserver() 方法即可。
     *
     * 此时，可观察者如何送出通知？首先需要扩展 Observable 类产生可观察类，然
     * 后，需要两个步骤：
     * 1、调用 setChanged() 方法，标记状态已经改变的事实；
     * （这个方法的好处在于：让你在更新观察者时，有更多的弹性，可以更适当的通知
     * 观察者）
     * 2、调用两种 notifyObservers() 方法中的一个：
     * （1）notifyObservers() 即 拉 pull（观察者拉）
     * （2）notifyObservers(Object arg) 即 推 push（可观察者推）
     * （对于推模式，可传送任何数据对象给每一个观察者）
     *
     * 此时，观察者如何接收通知？Observer 接口中有更新的方法，但是方法签名和
     * 之前不太一样：update(Observable observable, Object arg)。即 可观
     * 察者 observable 本身作为第一个变量，好让观察者知道是哪个可观察者通知它
     * 的。数据对象 arg 作为第二个变量，如果没有说明为空。
     *
     *
     * 值得注意的是，此时运行代码，相同的计算结果，文字的输出顺序却却不太一样。
     * 这是因为 Observable 实现了它的 notifyObservers() 方法，这导致了通
     * 知观察者的次序不同于先前的次序。谁也没有错，只是双方选择不同的方式实现
     * 罢了。
     * 但可以确定但是，如果代码依赖于这样的次序，就是错的。因为一旦观察者/可观
     * 察者的实现有所改变，通知次序就会改变，很可能就会产生错误的结果。这绝对不
     * 是我们所认为的松耦合。
     * 所以，不要依赖于观察者被通知的次序。
     *
     *
     * Observable 类的黑暗面
     * Observable 是一个 "类" 而不是一个 "接口"，更糟的是，它甚至没有实现一个
     * 接口。不幸的是，Observable 的实现有许多问题，限制了它的使用和复用。这并
     * 不是说它没有提供有用的功能，这里只是想提醒大家注意一些事实。
     *
     * Observable 是一个类
     * 从 OO 原则中可知，这不是一件好事，但是这到底会造成什么问题呢？
     * 首先，因为 Observable 是一个 "类"，所以必须设计一个类继承它。如果某类想
     * 同时具有 Observable 类和另一个超类的行为，就会陷入两难，毕竟 Java 不支
     * 持多继承。这限制了 Observable 的复用潜力。而增加复用潜力不正是使用模式最
     * 原始的动机吗？
     * 再者，因为没有 Observable 接口，所以无法建立自己的实现，和 Java 内置的
     * Observer 搭配使用，也无法将 java.util 实现换成另一套做法的实现。
     *
     * Observable 将关键的方法保护起来
     * 不难发现，例如 setChanged() 方法被保护起来了。那又怎么样呢？这意味着：除
     * 非你继承自 Observable，否则你无法创建 Observable 实例并组合到你自己的对
     * 象中来。这违反了 "多用组合，少用继承" 的设计原则。
     *
     * 应该怎么做？做什么呢？
     * 如果能够扩展 Observable，那么 Observable "可能" 可以符合你的需求。否则
     * 就需要自己实现一套观察者模式。
     */
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        System.out.println();
        weatherData.setMeasurements(82, 70, 29.2f);
        System.out.println();
        weatherData.setMeasurements(78, 90, 29.2f);
    }

}
