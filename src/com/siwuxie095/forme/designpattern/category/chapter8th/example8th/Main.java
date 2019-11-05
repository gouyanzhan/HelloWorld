package com.siwuxie095.forme.designpattern.category.chapter8th.example8th;

/**
 * @author Jiajing Li
 * @date 2019-11-05 18:05:56
 */
public class Main {

    /**
     * Java API 中的模板方法模式
     *
     * JFrame 是最基本的 Swing 容器，继承了一个 paint() 方法。
     * 默认状态下，paint() 是不做事情的，因为它是一个钩子。通过
     * 覆盖该方法，可以将自己的代码插入 JFrame 的算法中，显示出
     * 你想要的画面。
     */
    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame("Design Pattern");
    }

}
