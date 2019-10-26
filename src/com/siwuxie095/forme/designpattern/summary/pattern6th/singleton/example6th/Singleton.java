package com.siwuxie095.forme.designpattern.summary.pattern6th.singleton.example6th;

/**
 * 单例类（单例枚举）
 *
 * @author Jiajing Li
 * @date 2019-10-22 18:11:19
 */
enum Singleton {

    /**
     * 唯一实例
     */
    UNIQUE_INSTANCE;

    /**
     * 可省略该方法，通过 Singleton.UNIQUE_INSTANCE
     * 进行操作。
     */
    public static Singleton getInstance() {
        return UNIQUE_INSTANCE;
    }

    // other useful methods ...

    public void doSomething() {
        System.out.println("do something ...");
    }


}
