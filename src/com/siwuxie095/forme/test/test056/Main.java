package com.siwuxie095.forme.test.test056;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiajing Li
 * @date 2021-02-19 15:00:39
 */
public class Main {

    /**
     * 说明的问题：
     * 1、基本数据类型放入 Map<String, Object> 结构后会自动装箱成包装数据类型。
     * 2、类中的基本数据类型 JSON 序列化后，再反序列化成 Map<String, Object> 结构，也会自动装箱成包装数据类型。
     */
    public static void main(String[] args) {
        int a = 1;
        long b = 2L;
        Integer c = 3;
        Long d = 4L;
        String s = "s";
        Map<String, Object> map = new HashMap<>();
        map.put("a", a);
        map.put("b", b);
        map.put("c", c);
        map.put("d", d);
        map.put("s", s);
        map.forEach((x, y) -> {
            if (y instanceof Integer) {
                System.out.println("Integer: " + x + "=" + y);
            }
            if (y instanceof Long) {
                System.out.println("Long: " + x + "=" + y);
            }
            if (y instanceof String) {
                System.out.println("String: " + x + "=" + y);
            }
        });
    }

}
