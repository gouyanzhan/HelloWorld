package com.siwuxie095.forme.test.test054;

import java.util.Optional;

/**
 * @author Jiajing Li
 * @date 2020-10-20 15:33:23
 */
public class Main {

    /**
     * 说明的问题：
     * 1、Optional 中 map 和 flatMap 的区别；
     */
    public static void main(String[] args) {
        Optional<String> s = Optional.of("input");
        System.out.println(s.map(Main::getOutput));
        System.out.println(s.flatMap(Main::getOutputOpt));
    }

    private static String getOutput(String input) {
        return input == null ? null : "output for " + input;
    }

    private static Optional<String> getOutputOpt(String input) {
        return input == null ? Optional.empty() : Optional.of("output for " + input);
    }

}
