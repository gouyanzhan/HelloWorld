package com.siwuxie095.forme.designpattern.category.chapter7th.example5th;

/**
 * @author Jiajing Li
 * @date 2019-11-04 19:51:54
 */
public class Main {

    /**
     * 再说外观模式
     *
     * 已经知道适配器模式是如何将一个类的接口转换成另一个符合客户期望的接口的。
     * 在 Java 中要做到这一点，必须将一个不兼容的对象包装起来，变成兼容的对象。
     *
     * 现在看一个改变接口的新模式，但是它改变接口的原因是为了简化接口。这个模式
     * 被称为 外观模式。之所以这么称呼，是因为它将一个或数个类的复杂的一切都隐
     * 藏在背后，只显露出一个干净美好的外观。
     *
     * 即
     * 装饰者模式：不改变接口，但加入责任。
     * 适配器模式：将一个接口转成另一个接口。
     * 外观模式：让接口更简单。
     *
     *
     * 在进入外观模式的细节之前，先看一个风行全美的热潮：建立自己的家庭影院。
     *
     * 通过一番研究比较，你组装了一套杀手级的系统，内含 DVD 播放器、投影仪、
     * 自动屏幕、环绕立体声，甚至还有爆米花机。
     *
     * 这些组件的组成有：
     * （1）CD 播放器 CdPlayer
     * （2）DVD 播放器 DvdPlayer
     * （3）Screen 屏幕
     * （4）Projector 投影仪
     * （5）TheaterLight 剧场灯光
     * （6）Amplifier 功放
     * （7）Tuner 调音器
     * （8）PopcornPopper 爆米花机
     *
     * 显然，有很多的类，很多的交互 ...
     *
     * 花了几个星期布线、挂上投影仪、连接所有的装置并进行微调。现在，你准备开始
     * 享受一部电影。但想看电影，必须先执行一些任务。
     * （1）打开爆米花机。
     * （2）开始爆米花。
     * （3）将剧场灯光调暗。
     * （4）放下屏幕。
     * （5）打开投影仪。
     * （6）将投影仪的输入切换到 DVD。
     * （7）将投影仪设置在宽屏模式。
     * （8）打开功放。
     * （9）将功放的输入设置为 DVD。
     * （10）将功放设置为环绕声。
     * （11）将功放音量调到中（5）。
     * （12）打开 DVD 播放器。
     * （13）开始播放 DVD。
     *
     * 一共涉及到 6 个类，还要打开许多的开关。还不止这样 ....
     *
     * 看完电影后，还要把一切都关掉，怎么办？难道要反向把这一切动作再进行一次？
     * 如果要听 CD，难道也会这么麻烦？
     * 如果你决定要升级你的系统，可能还必须重新学习一套稍微不同的操作流程。
     *
     * 怎么办？使用家庭影院竟然变得如此复杂！使用外观模式便可解决这团混乱，好让
     * 你能轻易地享受电影。
     */
    public static void main(String[] args) {
        /*
         * 用困难的方式观影
         */
        PopcornPopper popcornPopper = new PopcornPopper();
        TheaterLight theaterLight = new TheaterLight();
        Screen screen = new Screen();
        Projector projector = new Projector();
        Amplifier amplifier = new Amplifier();
        DvdPlayer dvdPlayer = new DvdPlayer();

        // 打开爆米花机
        popcornPopper.on();
        // 开始爆米花
        popcornPopper.pop();

        // 将剧场灯光调暗
        theaterLight.dim(10);

        // 放下屏幕
        screen.down();

        // 打开投影仪
        projector.on();
        // 将投影仪的输入切换到 DVD
        projector.setInput(dvdPlayer);
        // 将投影仪设置在宽屏模式
        projector.wideScreenMode();

        // 打开功放
        amplifier.on();
        // 将功放的输入设置为 DVD
        amplifier.setDvd(dvdPlayer);
        // 将功放设置为环绕声
        amplifier.setSurroundSound();
        // 将功放音量调到中（5）
        amplifier.setVolume(5);

        // 打开 DVD 播放器
        dvdPlayer.on();
        // 开始播放 DVD
        dvdPlayer.play();
    }

}
