package com.siwuxie095.forme.test.test058;

/**
 * @author Jiajing Li
 * @date 2022-03-11 14:11:27
 */
public class Main {

    /**
     * 说明的问题：
     * 1、null 对象传入到方法中赋值，在方法内有效，在方法外无效，需要返回出去。
     */
    public static void main(String[] args) {
        User user = null;
        System.out.println(user);
        run(user);
        System.out.println(user);
        System.out.println("------------");
        System.out.println(user);
        user = supplier(user);
        System.out.println(user);
    }

    public static void run(User user) {
        User newUser = new User();
        newUser.name = "Jack";
        user = newUser;
        System.out.println(user);
    }

    public static User supplier(User user) {
        User newUser = new User();
        newUser.name = "Jack";
        user = newUser;
        System.out.println(user);
        return user;
    }

    static class User {

        public String name;

    }

}
