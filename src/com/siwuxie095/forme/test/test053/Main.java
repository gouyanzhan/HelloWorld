package com.siwuxie095.forme.test.test053;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

/**
 * @author Jiajing Li
 * @date 2020-10-09 11:13:07
 */
public class Main {

    /**
     * 说明的问题：
     * 1、Supplier 和 Callable 无法重载；
     *
     * 建议：避免使用函数式接口进行方法重载。
     */
    public static void main(String[] args) {
        //foo(() -> "1");
    }

    private static String foo(Supplier<String> supplier) {
        return supplier.get();
    }

    private static String foo(Callable<String> callable) throws Exception {
        return callable.call();
    }


}
