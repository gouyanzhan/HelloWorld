package com.siwuxie095.forme.test.test049;

/**
 * @author Jiajing Li
 * @date 2020-08-14 14:39:46
 */
public class Main {

    /**
     * 说明的问题：
     * 1、ThreadLocal 变量对其中包含对象的修改是持久化的（具体见下方示例）。
     */
    public static void main(String[] args) {
        ThreadLocal<User> local = ThreadLocal.withInitial(User::new);
        System.out.println(local.get());
        local.get().name = "张三";
        System.out.println(local.get());
        local.remove();
        System.out.println(local.get());
        /*
         * new 一个 user 放到 ThreadLocal 中，ThreadLocal.set() 对 user 做了修改，
         * 然后调用 ThreadLocal.remove()，不影响之前对 user 做过的修改。
         */
        User user = new User();
        user.name = "123";
        local.set(user);
        System.out.println(local.get());
        local.get().name = "456";
        System.out.println(local.get());
        local.remove();
        System.out.println(local.get());
        System.out.println(user);
    }

}
