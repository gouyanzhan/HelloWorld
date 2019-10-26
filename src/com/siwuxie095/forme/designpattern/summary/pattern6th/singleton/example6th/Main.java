package com.siwuxie095.forme.designpattern.summary.pattern6th.singleton.example6th;

/**
 * @author Jiajing Li
 * @date 2019-10-22 17:49:44
 */
public class Main {

    /**
     * 枚举（枚举模式）
     *
     * 线程安全，且急切实例化
     */
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        singleton.doSomething();
    }

}
