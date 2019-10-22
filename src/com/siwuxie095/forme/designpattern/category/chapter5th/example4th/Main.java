package com.siwuxie095.forme.designpattern.category.chapter5th.example4th;

/**
 * @author Jiajing Li
 * @date 2019-10-22 14:39:54
 */
public class Main {

    /**
     * 改进 ChocolateBoiler 类，使之只有一个实例存在
     *
     *
     * 单例模式
     *
     * 确保一个类只有一个实例，并提供一个全局访问点。
     *
     *
     * 即：
     * （1）单例模式把某个类设计成自己管理的一个单独实例，同时也避免其他类再自行产生实例。
     * 要想取得单例对象，通过单例类是唯一的途径。
     * （2）单例模式提供对这个实例的全局访问点：当你需要实例时，向类查询，他会返回单个实
     * 例。（PS：延迟实例化的方式创建单例对象，这种做法对资源敏感的对象特别重要）
     *
     *
     * 改进后的代码，在单线程时确实可以只有一个实例存在，但是遇到多线程时却会遇到问题。
     * 比如：会发现 fill() 方法竟然允许在加热的过程中继续加入原料，这就会导致原料溢出。
     * （使用多线程是想对代码进行优化）
     *
     * 假设有两个线程执行如下代码：
     * ChocolateBoiler chocolateBoiler = ChocolateBoiler.getInstance();
     * chocolateBoiler.fill();
     * chocolateBoiler.boil();
     * chocolateBoiler.drain();
     *
     * 这两个线程可能会通过 ChocolateBoiler.getInstance() 获得两个不同的实例。
     */
    public static void main(String[] args) {
        ChocolateBoiler chocolateBoiler = ChocolateBoiler.getInstance();
        chocolateBoiler.fill();
        chocolateBoiler.boil();
        chocolateBoiler.drain();
    }

}
