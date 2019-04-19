package com.siwuxie095.forme.test.test004;

import com.siwuxie095.forme.util.ArrayX;
import com.siwuxie095.forme.util.ListX;
import com.siwuxie095.forme.util.PrintX;
import com.siwuxie095.forme.util.StringX;
import org.junit.Test;

import java.util.List;

/**
 * @author Jiajing Li
 * @date 2019-01-18 10:30:43
 */
public class Main {

    /**
     * 说明的问题：
     *
     * 测试工具类
     */

    @Test
    public void testListX() {
        List<Integer> intList = ListX.newArrayList();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        PrintX.println(intList);
        PrintX.println(ListX.isEmpty(intList));
        PrintX.println(ListX.nonEmpty(intList));
        PrintX.printSplitLine();

        List<String> strList = ListX.newArrayList();
        strList.add("红");
        strList.add("黄");
        strList.add("蓝");
        PrintX.println(strList);
        PrintX.println(ListX.isEmpty(strList));
        PrintX.println(ListX.nonEmpty(strList));
        PrintX.printSplitLine();

        User user1 = new User();
        user1.setId(111);
        user1.setName("小红");
        User user2 = new User();
        user2.setId(222);
        user2.setName("小黄");
        User user3 = new User();
        user3.setId(333);
        user3.setName("小蓝");
        List<User> userList = ListX.newArrayList();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        PrintX.println(userList);
        PrintX.println(ListX.isEmpty(userList));
        PrintX.println(ListX.nonEmpty(userList));
    }

    @Test
    public void testArrayX() {
        int[] intArr = {1, 2};
        PrintX.println(ArrayX.isEmpty(intArr));
        Integer[] boxedIntArr = {1, 2};
        PrintX.println(ArrayX.isEmpty(boxedIntArr));
    }

    @Test
    public void testStringX() {
        String str1 = "1";
        String str2 = "2";
        String[] strArr1 = {"1", "1"};
        String[] strArr2 = {"1", null};
        PrintX.println(StringX.isEmpty(str1));
        PrintX.println(StringX.nonEmpty(str1));
        PrintX.printSplitLine();

        PrintX.println(StringX.isAllEmpty());
        PrintX.println(StringX.isAnyEmpty());
        PrintX.println(StringX.isNoneEmpty());
        PrintX.printSplitLine();

        PrintX.println(StringX.isAllEmpty(null));
        PrintX.println(StringX.isAnyEmpty(null));
        PrintX.println(StringX.isNoneEmpty(null));
        PrintX.printSplitLine();

        PrintX.println(StringX.isAllEmpty(null, null));
        PrintX.println(StringX.isAnyEmpty(null, null));
        PrintX.println(StringX.isNoneEmpty(null, null));
        PrintX.printSplitLine();

        PrintX.println(StringX.isAllEmpty(null, str1));
        PrintX.println(StringX.isAnyEmpty(null, str1));
        PrintX.println(StringX.isNoneEmpty(null, str1));
        PrintX.printSplitLine();

        PrintX.println(StringX.isAllEmpty(str1, str2));
        PrintX.println(StringX.isAnyEmpty(str1, str2));
        PrintX.println(StringX.isNoneEmpty(str1, str2));
        PrintX.printSplitLine();

        PrintX.println(StringX.isAllEmpty(strArr1));
        PrintX.println(StringX.isAnyEmpty(strArr1));
        PrintX.println(StringX.isNoneEmpty(strArr1));
        PrintX.printSplitLine();

        PrintX.println(StringX.isAllEmpty(strArr2));
        PrintX.println(StringX.isAnyEmpty(strArr2));
        PrintX.println(StringX.isNoneEmpty(strArr2));
        PrintX.printSplitLine();

        CharSequence cs1 = "123";
        CharSequence cs2 = "1234";
        PrintX.println(StringX.isBlank(cs1));
        //PrintX.println(StringX.equals(cs1, cs2));

        String str = " abc ";
        System.out.println(str.length());
        String trim = StringX.trim(str);
        PrintX.println(trim);
        System.out.println(trim.length());
    }

}
