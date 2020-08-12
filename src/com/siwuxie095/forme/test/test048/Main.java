package com.siwuxie095.forme.test.test048;

/**
 * @author Jiajing Li
 * @date 2020-08-12 16:27:55
 */
public class Main {

    /**
     * 说明的问题：
     * 1、ThreadLocal 变量的初始化是一种懒加载，只有在两种情况下才会真正执行。
     * （1）第一次没有 set 前的 get；
     * （2）remove 后，第一次没有 set 前的 get；
     */
    public static void main(String[] args) {
        ThreadLocal<String> foo = ThreadLocal.withInitial(() -> "111");
        System.out.println(foo.get());
        foo.set("222");
        System.out.println(foo.get());
        foo.remove();
        System.out.println(foo.get());

        System.out.println("---------------");
        ThreadLocal<String> fun = ThreadLocal.withInitial(() -> "333");
        fun.set("444");
        System.out.println(fun.get());
        fun.remove();
        System.out.println(fun.get());

        System.out.println("---------------");
        ThreadLocal<String> bar = new ThreadLocal<>();
        System.out.println(bar.get());
        bar.set("555");
        System.out.println(bar.get());
        bar.remove();
        System.out.println(bar.get());
    }

}
