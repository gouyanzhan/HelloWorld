package com.siwuxie095.forme.designpattern.category.chapter8th.example9th;

/**
 * @author Jiajing Li
 * @date 2019-11-05 18:10:00
 */
public class Main {

    /**
     * Java API 中的模板方法模式
     *
     * Applet 就是一个能够在网页上执行的小程序。而 Applet 提供
     * 了大量的钩子。
     * 比如：init()、start()、stop()、destroy()、paint()。
     *
     * 注：本例运行没有效果。
     *
     *
     * 策略模式和模板方法模式的异同：
     *
     * 策略模式是定义一个算法家族，并让这些算法家族可以互换。正因
     * 为每一个算法都被封装起来了，所以客户可以轻易的使用不同的算
     * 法。
     *
     * 模板方法模式则是要定义一个算法的大纲，而由子类定义其中某些
     * 步骤的内容。这么一来，我在算法中的个别步骤可以由不同的实现
     * 细节，但是算法的结构依然维持不变。
     *
     * 策略模式是通过对象组合的方式让客户可以选择算法实现。
     *
     * 模板方法模式是通过继承的方式进行算法的实现。
     */
    public static void main(String[] args) {
        MyApplet myApplet = new MyApplet();
        myApplet.init();
        myApplet.start();
        myApplet.stop();
        myApplet.destroy();
    }

}
