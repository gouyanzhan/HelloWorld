package com.siwuxie095.forme.test.test010;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Jiajing Li
 * @date 2019-04-03 14:42:47
 */
public class Main {

    /**
     * 说明的问题：
     *
     * 测试一个全是 null 的 List，mapToInt 后再 sum 的值是多少。
     */
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(null);
        list.add(null);
        list.add(null);
        list.add(null);
        System.out.println(list.stream().filter(x -> Objects.nonNull(x)).mapToInt( x -> x).sum());
        System.out.println(list.stream().collect(Collectors.toList()));
    }

}
