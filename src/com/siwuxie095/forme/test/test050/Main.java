package com.siwuxie095.forme.test.test050;

import java.util.*;

/**
 * @author Jiajing Li
 * @date 2020-08-27 14:10:55
 */
public class Main {

    /**
     * 说明的问题：
     * 1、Map 中出现重复 key 时，将 key 进行 rename 并累加。
     */
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        String key = "key";
        String value = "value";
        for (int i = 1; i <= 15; i++) {
            add(map, key, value + i);
        }
        System.out.println(map);
    }


    private static void add(Map<String, String> map, String key, String value) {
        int index = 1;
        while (true) {
            boolean f = put(map, key + index++, String.valueOf(value));
            if (f) {
                break;
            }
        }
    }


    private static boolean put(Map<String, String> map, String key, String value) {
        String oldValue = map.get(key);
        if (Objects.isNull(oldValue)) {
            map.put(key, value);
            return true;
        } else if (!oldValue.equals(value)) {
            return false;
        } else {
            return true;
        }
    }
}
