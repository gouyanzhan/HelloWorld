package com.siwuxie095.forme.test.test004;

import com.siwuxie095.forme.util.MyArrayUtils;
import com.siwuxie095.forme.util.MyListUtils;
import com.siwuxie095.forme.util.MyPrintUtils;
import com.siwuxie095.forme.util.MyStringUtils;
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
        List<Integer> intList = MyListUtils.newArrayList();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        MyPrintUtils.println(intList);
        MyPrintUtils.println(MyListUtils.isEmpty(intList));
        MyPrintUtils.println(MyListUtils.nonEmpty(intList));
        MyPrintUtils.printSplitLine();

        List<String> strList = MyListUtils.newArrayList();
        strList.add("红");
        strList.add("黄");
        strList.add("蓝");
        MyPrintUtils.println(strList);
        MyPrintUtils.println(MyListUtils.isEmpty(strList));
        MyPrintUtils.println(MyListUtils.nonEmpty(strList));
        MyPrintUtils.printSplitLine();

        User user1 = new User();
        user1.setId(111);
        user1.setName("小红");
        User user2 = new User();
        user2.setId(222);
        user2.setName("小黄");
        User user3 = new User();
        user3.setId(333);
        user3.setName("小蓝");
        List<User> userList = MyListUtils.newArrayList();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        MyPrintUtils.println(userList);
        MyPrintUtils.println(MyListUtils.isEmpty(userList));
        MyPrintUtils.println(MyListUtils.nonEmpty(userList));
    }

    @Test
    public void testArrayX() {
        int[] intArr = {1, 2};
        MyPrintUtils.println(MyArrayUtils.isEmpty(intArr));
        Integer[] boxedIntArr = {1, 2};
        MyPrintUtils.println(MyArrayUtils.isEmpty(boxedIntArr));
    }

    @Test
    public void testStringX() {
        String str1 = "1";
        String str2 = "2";
        String[] strArr1 = {"1", "1"};
        String[] strArr2 = {"1", null};
        MyPrintUtils.println(MyStringUtils.isEmpty(str1));
        MyPrintUtils.println(MyStringUtils.nonEmpty(str1));
        MyPrintUtils.printSplitLine();

        MyPrintUtils.println(MyStringUtils.isAllEmpty());
        MyPrintUtils.println(MyStringUtils.isAnyEmpty());
        MyPrintUtils.println(MyStringUtils.isNoneEmpty());
        MyPrintUtils.printSplitLine();

        MyPrintUtils.println(MyStringUtils.isAllEmpty(null));
        MyPrintUtils.println(MyStringUtils.isAnyEmpty(null));
        MyPrintUtils.println(MyStringUtils.isNoneEmpty(null));
        MyPrintUtils.printSplitLine();

        MyPrintUtils.println(MyStringUtils.isAllEmpty(null, null));
        MyPrintUtils.println(MyStringUtils.isAnyEmpty(null, null));
        MyPrintUtils.println(MyStringUtils.isNoneEmpty(null, null));
        MyPrintUtils.printSplitLine();

        MyPrintUtils.println(MyStringUtils.isAllEmpty(null, str1));
        MyPrintUtils.println(MyStringUtils.isAnyEmpty(null, str1));
        MyPrintUtils.println(MyStringUtils.isNoneEmpty(null, str1));
        MyPrintUtils.printSplitLine();

        MyPrintUtils.println(MyStringUtils.isAllEmpty(str1, str2));
        MyPrintUtils.println(MyStringUtils.isAnyEmpty(str1, str2));
        MyPrintUtils.println(MyStringUtils.isNoneEmpty(str1, str2));
        MyPrintUtils.printSplitLine();

        MyPrintUtils.println(MyStringUtils.isAllEmpty(strArr1));
        MyPrintUtils.println(MyStringUtils.isAnyEmpty(strArr1));
        MyPrintUtils.println(MyStringUtils.isNoneEmpty(strArr1));
        MyPrintUtils.printSplitLine();

        MyPrintUtils.println(MyStringUtils.isAllEmpty(strArr2));
        MyPrintUtils.println(MyStringUtils.isAnyEmpty(strArr2));
        MyPrintUtils.println(MyStringUtils.isNoneEmpty(strArr2));
        MyPrintUtils.printSplitLine();

        CharSequence cs1 = "123";
        CharSequence cs2 = "1234";
        MyPrintUtils.println(MyStringUtils.isBlank(cs1));
        //MyPrintUtils.println(MyStringUtils.equals(cs1, cs2));

        String str = " abc ";
        System.out.println(str.length());
        String trim = MyStringUtils.trim(str);
        MyPrintUtils.println(trim);
        System.out.println(trim.length());
    }

}
