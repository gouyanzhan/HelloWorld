package com.siwuxie095.foryou.threaddemo.example3rd;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiajing Li
 * @date 2019-12-28 13:14:34
 */
public class Main {

    /**
     * 以 Runnable 的形式体现的线程
     */
    public static void main(String[] args) {
        singleThreadExecute();
        //doubleThreadExecute();
        //multiThreadExecute();
    }

    /**
     * 单个计数线程执行的情况
     */
    private static void singleThreadExecute() {
        CountRunnable countRunnable = new CountRunnable();
        System.out.println("开始执行");
        // 直接创建新的线程对象，将 countRunnable 放进去
        Thread thread = new Thread(countRunnable);
        thread.start();
        System.out.println("结束执行");
    }

    /**
     * 两个计数线程执行的情况
     */
    private static void doubleThreadExecute() {
        CountRunnable countRunnable1 = new CountRunnable();
        CountRunnable countRunnable2 = new CountRunnable();
        System.out.println("开始执行");
        // 以匿名对象方式创建线程，将 countRunnable1、countRunnable2 放进去
        new Thread(countRunnable1).start();
        new Thread(countRunnable2).start();
        System.out.println("结束执行");
    }

    /**
     * 多个计数线程执行的情况
     */
    private static void multiThreadExecute() {
        System.out.println("开始执行");
        List<CountRunnable> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            CountRunnable countRunnable = new CountRunnable();
            list.add(countRunnable);
        }
        for (CountRunnable countRunnable : list) {
            // 依然是匿名对象
            new Thread(countRunnable).start();
        }
        System.out.println("结束执行");
    }

}
