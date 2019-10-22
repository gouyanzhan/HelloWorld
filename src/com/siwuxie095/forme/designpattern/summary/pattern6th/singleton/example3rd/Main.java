package com.siwuxie095.forme.designpattern.summary.pattern6th.singleton.example3rd;

/**
 * @author Jiajing Li
 * @date 2019-10-22 17:49:44
 */
public class Main {

    /**
     * 急切实例化（饿汉模式）
     *
     * 线程安全，但容易产生垃圾，因为一开始就初始化
     */
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        singleton.doSomething();
    }

}
