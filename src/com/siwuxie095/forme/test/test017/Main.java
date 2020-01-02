package com.siwuxie095.forme.test.test017;

import java.sql.SQLOutput;
import java.util.Optional;

/**
 * @author Jiajing Li
 * @date 2020-01-02 15:07:04
 */
public class Main {

    /**
     * 说明的问题：
     * 1、Optional.empty() 时，isPresent() 方法和 ifPresent() 方法的表现。
     * 2、Optional 容器中的值为 null 和 non-null 时的表现。
     */
    public static void main(String[] args) {
        Optional<String> test = Optional.empty();
        System.out.println(test.isPresent());
        // Optional.empty() 时，下面这一行根本没有执行
        test.ifPresent(s -> System.out.println(s));

        test = Optional.of("123");
        test.ifPresent(s -> System.out.println(s));
    }

}
