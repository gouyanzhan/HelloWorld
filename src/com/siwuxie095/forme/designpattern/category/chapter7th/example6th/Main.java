package com.siwuxie095.forme.designpattern.category.chapter7th.example6th;

/**
 * @author Jiajing Li
 * @date 2019-11-04 19:51:54
 */
public class Main {

    /**
     * 使用外观模式解决混乱
     *
     * 通过实现一个提供更合理的接口的外观类，可以将一个复杂的子系统
     * 变得容易使用。如果你需要复杂子系统的强大威力，不用担心，还是
     * 可以使用原来的复杂接口的。但如果你需要的是一个方便使用的接口，
     * 那就使用外观。
     *
     * 现在是为家庭影院系统创建一个外观的时候了，于是创建一个了名为
     * HomeTheaterFacade 的新类，它对外暴露出几个简单的方法，例
     * 如：watchMovie()、endMovie()。
     *
     * 这个外观将家庭影院的诸多组件视为一个子系统，通过调用这个子系
     * 统，来实现 watchMovie() 方法。
     *
     * 现在，客户代码可以调用此家庭影院外观所提供的方法，而不必再调
     * 用这个子系统的方法。所以，想要看电影，只要调用一个方法就可以，
     * 即 watchMovie()，剧场灯光、DVD 播放器、投影仪、功放、屏幕、
     * 爆米花等，一口气全部搞定。
     * （PS：客户代码可以是遥控器代码）
     *
     * 外观只是提供你更直接的操作，并未将原来的子系统阻隔起来。如果
     * 你需要子系统类的更高层功能，还是可以使用原来的子系统。
     *
     * 疑问与解答
     *
     * 问：
     * 如果外观封装了子系统的类，那么需要低层功能的客户如何接触这些
     * 类？
     * 答：
     * 外观没有 "封装" 子系统的类，外观只是提供简化的接口。所以客户
     * 如果觉得有必要，依然可以直接使用子系统的类。这是外观模式一个
     * 很好的特征：提供简化的接口的同时，依然将系统完整的功能暴露出
     * 来，以供需要的人使用。
     *
     * 问：
     * 外观会新增功能吗，或者它只是将每一个请求转由子系统执行？
     * 答：
     * 外观可以附加 "聪明的" 功能，让使用子系统更方便。比方说，虽然
     * 家庭影院外观没有实现任何新行为，但是外观却足够聪明，知道爆米
     * 花机要先开启然后才能开始爆米花（同样，也要先开机才能放电影）。
     *
     * 问：
     * 每个子系统只能有一个外观吗？
     * 答：
     * 不，可以为一个子系统创建许多个外观。
     *
     * 问：
     * 除了能够提供一个比较简单的接口之外，外观模式还有其他的优点吗？
     * 答：
     * 外观模式也允许你将客户实现从任何子系统中解耦。比方说，你得到
     * 了大笔加薪，所以想要升级你的家庭影院，采用全新的和以前不一样
     * 接口的组件。如果当初你的客户代码是针对外观而不是针对子系统编
     * 写的，现在你就不需要改变客户代码，只需要修改外观代码（而且厂
     * 商有可能会提供新版的外观代码）。
     * 即 外观不只是简化了接口，也将客户从组件的子系统中解耦。
     *
     * 问：
     * 可不可以这么说，适配器模式和外观模式之间的差异在于：适配器包
     * 装一个类，而外观可以代表许多类？
     * 答：
     * 不对。注意，适配器模式将一个或多个类接口变成客户所期望的一个
     * 接口。虽然大多数教科书所采用的例子中适配器只适配一个类，但是
     * 你可以适配许多类来提供一个接口让客户编码。类似地，一个外观也
     * 可以只针对一个拥有复杂接口的类提供简化的接口。
     * 两种模式的差异，不在于它们 "包装" 了几个类，而是在于它们的意
     * 图。适配器模式的意图是，"改变" 接口符合客户的期望；而外观模式
     * 的意图是，提供子系统的一个简化接口。
     * 即 外观和适配可以包装许多类，但是外观的意图是简化接口，而适配
     * 器的意图是将接口转换成不同接口。
     */
    public static void main(String[] args) {
        /*
         * 用轻松的方式观影
         */
        Amplifier amplifier = new Amplifier();
        CdPlayer cdPlayer = new CdPlayer();
        DvdPlayer dvdPlayer = new DvdPlayer();
        PopcornPopper popcornPopper = new PopcornPopper();
        Projector projector = new Projector();
        Screen screen = new Screen();
        TheaterLight theaterLight = new TheaterLight();
        Tuner tuner = new Tuner();

        HomeTheaterFacade homeTheaterFacade =
                new HomeTheaterFacade(amplifier, cdPlayer, dvdPlayer,
                        popcornPopper, projector, screen,
                        theaterLight, tuner);

        homeTheaterFacade.watchMovie();
        System.out.println();
        homeTheaterFacade.endMovie();
    }

}
