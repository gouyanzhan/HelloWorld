package com.siwuxie095.test.test002;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiajing Li
 * @date 2019-01-08 09:59:39
 */
public class Main {

    public static void main(String[] args) {
        User user1 = new User();
        user1.setId(2);
        user1.setName("小红");
        User user2 = new User();
        user2.setId(1);
        user2.setName("小黄");
        User user3 = new User();
        user3.setId(3);
        user3.setName("小蓝");

        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        System.out.println("未排序时：");
        System.out.println(userList);
        System.out.println();

        System.out.println("按 id 从小到大排序：");
        userList.sort((a, b) -> new Integer(a.getId()).compareTo(b.getId()));
        System.out.println(userList);
        System.out.println();

        System.out.println("按 id 从大到小排序：");
        userList.sort((a, b) -> new Integer(b.getId()).compareTo(a.getId()));
        System.out.println(userList);
        System.out.println();
    }
}
