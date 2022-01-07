package com.siwuxie095.forme.test.test057;

import java.util.*;

/**
 * @author Jiajing Li
 * @date 2022-01-07 14:33:00
 */
public class Main {

    /**
     * 说明的问题：
     * 1、lambda 循环中使用 return 相当于普通循环中使用 continue。
     * 2、lambda 循环中不能使用类似普通循环的 break。
     *
     * 总结：lambda 循环中有 continue (即 return)，没有 break。
     */
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("a", null);
        map.put("b", 1);
        map.put("c", 2L);
        map.put("s", "s");
        System.out.println("map:");
        map.forEach((k, v) -> {
            System.out.println("-----");
            System.out.println("before: " + k + "=" + v);
            if (Objects.isNull(v)) {
                return;
            }
            System.out.println("after: " + k + "=" + v);
        });

        System.out.println("\n\nlist:");
        List<Object> list = new ArrayList<>();
        list.add(null);
        list.add(1);
        list.add(2L);
        list.add("s");
        list.forEach(x -> {
            System.out.println("-----");
            System.out.println("before: " + x);
            if (Objects.isNull(x)) {
                return;
            }
            System.out.println("after: " + x);
        });
    }

}
