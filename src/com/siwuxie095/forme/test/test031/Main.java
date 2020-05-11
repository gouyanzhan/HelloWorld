package com.siwuxie095.forme.test.test031;

import java.util.Optional;

/**
 * @author Jiajing Li
 * @date 2020-05-11 17:44:17
 */
public class Main {
    /**
     * 说明的问题：
     * 1、另一种 OptionalConsumer<T> 的用法；
     */
    public static void main(String[] args) {
        User user = new User(1, "Zhang San");
        Optional<User> optionalUser = Optional.of(user);
        OptionalConsumer.of(optionalUser)
                .ifPresent(x -> System.out.println("用户信息：" + x))
                .ifNotPresent(() -> System.out.println("不存在"));

        OptionalConsumer.of(Optional.empty())
                .ifPresent(x -> System.out.println("用户信息：" + x))
                .ifNotPresent(() -> System.out.println("不存在"));
    }

}
