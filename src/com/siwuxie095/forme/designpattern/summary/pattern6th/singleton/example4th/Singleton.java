package com.siwuxie095.forme.designpattern.summary.pattern6th.singleton.example4th;

/**
 * 单例类
 *
 * @author Jiajing Li
 * @date 2019-10-22 17:48:28
 */
class Singleton {

    /**
     * 利用一个静态变量记录 Singleton 类的唯一实例
     *
     * volatile 防止指令重排，确保当 uniqueInstance 变量被初始化
     * 成 Singleton 实例时，多个线程正确地处理 uniqueInstance 变
     * 量。
     */
    private volatile static Singleton uniqueInstance;

    /**
     * 私有构造器：只有 Singleton 类内才可以调用构造器
     */
    private Singleton() {}

    /**
     * 实例化对象，并返回该实例
     */
    public static Singleton getInstance() {
        // 检查实例，如果不存在，就进入同步代码块。
        if (null == uniqueInstance) {
            // 注意：只有第一次会彻底执行这里的代码。
            synchronized (Singleton.class) {
                // 进入区块后，再检查一次。如果仍是空，才创建实例。
                if (null == uniqueInstance) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }


    // other useful methods ...

    public void doSomething() {
        System.out.println("do something ...");
    }

}
