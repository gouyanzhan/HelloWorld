package com.siwuxie095.forme.test.test043;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author Jiajing Li
 * @date 2020-08-08 21:19:25
 */
public class Main {

    /**
     * 说明的问题：
     * 1、ThreadLocal 的用法
     */
    public static void main(String[] args) {
        ThreadLocal<String> local = new ThreadLocal<>();
        Random random = new Random();
        IntStream.range(0, 5).forEach(num -> {
            new Thread(() -> {
                local.set(num + " " + random.nextInt(100));
                System.out.println("序号和local值分别是 " + local.get());
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {}
            }).start();
        });
    }

}
