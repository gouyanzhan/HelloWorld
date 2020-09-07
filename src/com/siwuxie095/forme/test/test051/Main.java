package com.siwuxie095.forme.test.test051;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Jiajing Li
 * @date 2020-09-07 14:29:05
 */
public class Main {

    /**
     * 说明的问题：
     * 1、List<T> 转 Map<K, Map<A, B>>。
     */
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        User user1 = new User("1", "A", "10");
        User user2 = new User("1", "B", "11");
        User user3 = new User("2", "C", "12");
        User user4 = new User("3", "C", "12");
        User user5 = new User("3", "C", "13");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);
        Map<String, Map<String, String>> mapMap = list.stream().collect(Collectors.groupingBy(User::getId, Collectors.toMap(User::getName, User::getAge, (v1, v2) -> v2)));
        System.out.println(mapMap);
    }

}
