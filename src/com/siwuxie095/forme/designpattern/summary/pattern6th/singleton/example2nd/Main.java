package com.siwuxie095.forme.designpattern.summary.pattern6th.singleton.example2nd;

/**
 * @author Jiajing Li
 * @date 2019-10-22 17:49:44
 */
public class Main {

    /**
     * 延迟实例化（懒汉模式）+ synchronized 同步方法
     *
     * 线程安全，但耗费资源
     */
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        singleton.doSomething();
    }

}
