package com.siwuxie095.foryou.threaddemo.example2nd;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiajing Li
 * @date 2019-12-28 12:51:45
 */
public class Main {
    /**
     * 以 Thread 的形式体现的线程
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
        CountThread countThread = new CountThread();
        System.out.println("开始执行");
        countThread.start();
        System.out.println("结束执行");
    }

    /**
     * 两个计数线程执行的情况
     */
    private static void doubleThreadExecute() {
        CountThread countThread1 = new CountThread();
        CountThread countThread2 = new CountThread();
        System.out.println("开始执行");
        countThread1.start();
        countThread2.start();
        System.out.println("结束执行");
    }

    /**
     * 多个计数线程执行的情况
     */
    private static void multiThreadExecute() {
        System.out.println("开始执行");
        List<CountThread> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            CountThread countThread = new CountThread();
            list.add(countThread);
        }
        for (CountThread countThread : list) {
            countThread.start();
        }
        System.out.println("结束执行");
    }

}
