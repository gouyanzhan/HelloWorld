package com.siwuxie095.forme.test.test018;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Jiajing Li
 * @date 2020-01-03 10:03:12
 */
public class Main {

    /**
     * 说明的问题：
     * 1、当 rawList 为 Optional.empty() 时（也就是 null），从中获得的 finalList 并不会
     * 引用到 rawList 中的 List<String>。
     * 2、只有当 rawList 明确为 non-null 时，从中获得的 finalList 才能引用到 rawList 中的
     * List<String>。
     * 3、上面两点主要就是说明 Optional 容器中的值能不能被引用到，什么情况下能/不能被引用到。
     */
    public static void main(String[] args) {
        firstDemo();
        //secondDemo();
    }

    private static void firstDemo() {
        Optional<List<String>> rawList = Optional.empty();

        List<String> finalList = rawList.orElse(new ArrayList<>());

        finalList.add("a");
        finalList.add("b");
        finalList.add("c");

        /*
         * 注释与否的区别
         */
        rawList = Optional.of(finalList);

        rawList.ifPresent(System.out::println);
    }

    private static void secondDemo() {
        Optional<List<String>> rawList = Optional.of(new ArrayList<>());

        List<String> finalList = rawList.orElse(new ArrayList<>());

        finalList.add("a");
        finalList.add("b");
        finalList.add("c");

        rawList.ifPresent(System.out::println);
    }

}
