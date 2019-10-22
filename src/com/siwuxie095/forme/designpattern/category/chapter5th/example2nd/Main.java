package com.siwuxie095.forme.designpattern.category.chapter5th.example2nd;

/**
 * @author Jiajing Li
 * @date 2019-10-22 13:53:29
 */
public class Main {

    /**
     * 经典的单例模式实现
     *
     *
     * 单例模式可以让类在任何时刻都只有一个对象、一个唯一的独一无二的对象。
     *
     * 这样会不会有点浪费？
     *
     * 这不仅不会浪费，相反，"一个" 的威力很强大！比如，如果有一个注册表
     * 设置的对象，肯定不会希望这样的对象有多个拷贝，那会把设置搞的一团乱。
     * 而利用单例对象，则可以确保程序中使用的全局资源只有一份。
     *
     * 单例模式常常被用来管理共享的资源，例如：数据库连接或线程池。
     *
     * 单例模式确保自己独一无二的方式是：没有公开的构造器，它的构造器是私
     * 有的。外部要想获得实例，就必须 "请求" 得到一个实例，而不是自行实例
     * 化得到一个实例。类中有一个 getInstance() 方法，调用它即可。而这
     * 个实例可能是这次调用才被创建，也可能是以前早就被创建了。
     */
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        singleton.doSomething();
    }

}
