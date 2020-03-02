package com.siwuxie095.forme.test.test019;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Jiajing Li
 * @date 2020-01-10 17:33:25
 */
public class Main {

    /**
     * 说明的问题：
     * 只是套了一层 Optional 而已，就被迷惑了，没有被接收的 Collectors.toList() 并不会影响到原来的 rawList。
     */
    public static void main(String[] args) {
        List<String> rawList = new ArrayList<>();
        rawList.add("A");
        rawList.add("B");
        rawList.add("C");
        rawList.add("D");
        System.out.println(rawList);
        Optional<List<String>> optional = Optional.of(rawList);
        optional.ifPresent(list -> list.stream().filter(val -> "A".equals(val)).collect(Collectors.toList()));
        System.out.println(rawList);
    }

}
