package com.siwuxie095.forme.designpattern.category.chapter5th.example1st;

/**
 * 单例类（雏形）
 *
 * @author Jiajing Li
 * @date 2019-10-22 11:31:49
 */
class MyClass {

    /**
     * 将构造器声明为 private，那么外部将不能再创建
     * MyClass 的对象，只有 MyClass 内部才能调用该
     * 构造器。
     */
    private MyClass() {}

    /**
     * 利用静态方法来获取只有 MyClass 内部才能创建
     * 的 MyClass 对象。
     */
    public static MyClass getInstance() {
        return new MyClass();
    }

    public void doSomething() {
        System.out.println("do something ...");
    }

}
