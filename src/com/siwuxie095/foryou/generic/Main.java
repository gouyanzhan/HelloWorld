package com.siwuxie095.foryou.generic;

import java.util.*;

/**
 * @author Yanzhan Gou
 * @date 2019-11-09 14:43:34
 */
public class Main {

    public static void main(String[] args) {
        //Calculator calculator = new Calculator();
        //int a = 1;
        //int b = 1;
        //calculator.add(a, b);
        //
        //CalculatorX<Integer> s = new CalculatorX<>()；

        int[] arr = new int[10];
        String[] str = new String[6];

        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        if (list.contains(1)) {

        }

        list.remove(1);

        List<User> userList = new ArrayList<>();
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        userList.remove(0);
        userList.remove(user2);



        List<String> strList = new LinkedList<>();

        /**
         * List 元素可以重复
         *
         * ArrayList 里面是数组
         * LinkedList 里面是链表
         *
         *
         * Set 元素不能重复
         *
         *
         *
         */
        Set<String> strHashSet = new HashSet<>();



        Set<String> strTreeSet = new TreeSet<>();



        Map<Integer, String> map = new HashMap<>();
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");

        String str0 = map.get(1);
        System.out.println(str);


        Map<Integer, User> userMap = new HashMap<>();
        userMap.put(1, user1);
        userMap.put(2, user2);
        userMap.put(3, user3);

        User user = userMap.get(1);

        CalculatorX<Integer> calculatorX = new CalculatorX<>();
        calculatorX.a = 1;
        calculatorX.b = 1;

        CalculatorY<Integer, String> calculatorY = new CalculatorY<>();
        calculatorY.a = 1;
        calculatorY.b = 1;
        calculatorY.c = "c";

        Coordinate<Integer> coordinate1 = new Coordinate<>(1, 1);
        coordinate1.print();

        Coordinate<Float> coordinate2 = new Coordinate<>(2F, 2F);
        coordinate2.print();

        Coordinate<Double> coordinate3 = new Coordinate<>(3D, 3D);
        coordinate3.print();
    }

}
