package com.siwuxie095.forme.test.test047;

/**
 * @author Jiajing Li
 * @date 2020-08-11 17:46:59
 */
public class ThreadLocalWrapper {

    public static ThreadLocal<String> str = ThreadLocal.withInitial(() -> "111");

}
