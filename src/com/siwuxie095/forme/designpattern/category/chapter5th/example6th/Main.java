package com.siwuxie095.forme.designpattern.category.chapter5th.example6th;

/**
 * @author Jiajing Li
 * @date 2019-10-22 15:17:14
 */
public class Main {

    /**
     * 急切实例化（eagerly instantiaze）
     *
     *
     * （2）使用 "急切" 创建实例，而不用延迟实例化的做法：
     * 这种做法依赖 JVM 在加载这个类时马上创建唯一的单例对象，JVM 保证在任何
     * 线程访问 uniqueInstance 静态变量之前，一定先创建此实例。
     * （PS："急切实例化" 即 饿汉模式，"延迟实例化" 即 懒汉模式）
     *
     * 对于修改巧克力锅炉代码所遇到的问题的适用性：
     * 因为一定会需要一个巧克力锅炉，所以静态地初始化实例并不是不可以。虽然对
     * 于采用标准模式的开发人员来说，此做法可能稍微陌生一点。但它还是可行的。
     */
    public static void main(String[] args) {
        ChocolateBoiler chocolateBoiler = ChocolateBoiler.getInstance();
        chocolateBoiler.fill();
        chocolateBoiler.boil();
        chocolateBoiler.drain();
    }

}
