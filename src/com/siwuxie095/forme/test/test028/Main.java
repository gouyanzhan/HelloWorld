package com.siwuxie095.forme.test.test028;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Jiajing Li
 * @date 2020-03-26 16:57:27
 */
public class Main {

    /**
     * 说明的问题：
     * 1、通过map的方式，来获取对应class中某个字段的值（并不完善，有一定限制）。
     */
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        User user = new User();
        user.address = new Address();
        user.address.city = "Xiangyang";
        user.address.province = "Hubei";
        user.address.country = "China";
        Map<String, Object> map = getFieldValue(user);
        System.out.println(map.get("city"));
        System.out.println(map.get("province"));
        System.out.println(map.get("country"));
        System.out.println(map.get("address"));
    }

    private static Map<String, Object> getFieldValue(User user) throws IllegalAccessException {
        Deque<Field> deque = new LinkedList();
        Map<String, Object> map = new HashMap<>();
        getFieldValue(user, user.getClass().getDeclaredFields(), deque, map);
        return map;
    }

    private static boolean getFieldValue(Object object, Field[] fields, Deque<Field> deque, Map<String, Object> map) throws IllegalAccessException {
        for (Field field : fields) {
            if (Modifier.isFinal(field.getModifiers())) {
                return false;
            }
            if (Modifier.isPrivate(field.getModifiers())) {
                return false;
            }
            deque.addLast(field);
            map.putIfAbsent(field.getName(), field.get(object));
        }
        while (!deque.isEmpty()) {
            Field field = deque.pollFirst();
            getFieldValue(field.get(object), field.get(object).getClass().getDeclaredFields(), deque, map);
        }
        return true;
    }
}
