package com.siwuxie095.forme.test.test007;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Jiajing Li
 * @date 2019-02-22 15:24:33
 */
public class Main {

    /**
     * 说明的问题：
     *
     * 测试 Stream 的连续 filter。
     */
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        list = list.stream().filter(val -> val > 3).filter(val -> val < 8).collect(Collectors.toList());
        System.out.println(list);
    }

}
