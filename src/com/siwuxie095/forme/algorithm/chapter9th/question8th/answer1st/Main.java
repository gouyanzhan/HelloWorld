package com.siwuxie095.forme.algorithm.chapter9th.question8th.answer1st;

/**
 * 设计有 setAll 功能的哈希表
 *
 * 题目：
 * 哈希表常见的三个操作是 put、get 和 containsKey，而且这三个操作的时间复杂度为 O(1)。
 * 现在想加入一个 setAll 功能，就是把所有记录的 value 值都设成统一的值。请设计并实现这
 * 种有 setAll 功能的哈希表，并且 put、get containsKey 和 setAll 四个操作的时间复杂
 * 度都为 O(1)。
 *
 * 解答：
 * 加入一个时间戳结构，一切问题就变得非常简单了。具体步骤如下：
 * 1、把每个记录都加上一个时间，标记每条记录是何时建立的。
 * 2、设置一个 setAll 记录也加上一个时间，标记 setAll 记录建立的时间。
 * 3、查询记录时，如果某条记录的时间早于 setAll 记录的时间，说明 setAll 是最新数据，返
 * 回 setAll 记录的值。如果某条记录的时间晚于 setAll 记录的时间，说明记录的值是最新数据，
 * 返回该条记录的值。
 *
 * @author Jiajing Li
 * @date 2019-06-23 21:28:29
 */
public class Main {

    public static void main(String[] args) {
        MyHashMap<Integer, String> map = new MyHashMap<>();
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");

        System.out.println(map.containsKey(1));
        System.out.println(map.get(1));
        System.out.println();

        map.setAll("abc");
        System.out.println(map.get(1));
        System.out.println();

        map.put(1, "111");
        System.out.println(map.get(1));
        System.out.println(map.get(2));
    }

}
