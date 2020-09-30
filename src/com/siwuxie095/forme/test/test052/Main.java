package com.siwuxie095.forme.test.test052;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Jiajing Li
 * @date 2020-09-30 14:37:59
 */
public class Main {

    /**
     * 说明的问题：
     * 1、Stream 中的对象始终不变。
     */
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        User user = new User();
        user.id = 1;
        user.name = "Jack";
        users.add(user);
        List<User> newUsers = users.stream().filter(x -> x.id == 1).collect(Collectors.toList());
        newUsers.get(0).name = "Mary";
        System.out.println(users);
        System.out.println(newUsers);
    }

}
