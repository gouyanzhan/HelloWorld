package com.siwuxie095.forme.test.test013;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Jiajing Li
 * @date 2019-07-02 14:33:30
 */
public class Main {

    /**
     * 说明的问题：
     * 1、从原 list 中 filter 出来的新 list，修改新 list，原 list 也会变化；
     */
    public static void main(String[] args) {
        List<User> allList = new ArrayList<>();
        User user1 = new User();
        user1.id = 1;
        user1.name = "111";
        User user2 = new User();
        user2.id = 2;
        user2.name = "222";
        User user3 = new User();
        user3.id = 3;
        user3.name = "333";

        allList.add(user1);
        allList.add(user2);
        allList.add(user3);
        System.out.println(allList);
        System.out.println();

        List<User> subList = allList.stream().filter(x -> x.name.equals("111")).collect(Collectors.toList());
        for (User user : subList) {
            user.name = "abc";
        }
        System.out.println(subList);
        System.out.println();

        System.out.println(allList);

    }

}
