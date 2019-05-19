package com.siwuxie095.forme.test.test006;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Jiajing Li
 * @date 2019-01-28 17:12:44
 */
public class Main {

    /**
     * 说明的问题：
     *
     * 测试 Stream 的 distinct。
     */

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 1, 1, 2, 3);
        System.out.println(intList);
        intList = intList.stream().distinct().collect(Collectors.toList());
        System.out.println(intList);

        System.out.println();

        List<String> strList = Arrays.asList("", "", "1", "1", "2", "3");
        System.out.println(strList);
        strList = strList.stream().distinct().collect(Collectors.toList());
        System.out.println(strList);
    }

}
