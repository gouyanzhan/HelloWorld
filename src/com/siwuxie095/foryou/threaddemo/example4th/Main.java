package com.siwuxie095.foryou.threaddemo.example4th;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiajing Li
 * @date 2019-12-28 15:53:55
 */
public class Main {

    /**
     * 以 匿名内部类 的形式体现的线程
     */
    public static void main(String[] args) {
        singleThreadExecute();
        //doubleThreadExecute();
        //multiThreadExecute();
    }

    /**
     * 通过匿名内部类的形式获取一个计数线程 Thread
     */
    private static Thread getCountThread() {
        return new Thread() {
            @Override
            public void run() {
                // 打印从 0～9 和从 0～99 的区别
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                }
            }
        };
    }

    /**
     * 通过匿名内部类的形式获得一个线程 Runnable
     */
    private static Runnable getCountRunnable() {
        return new Runnable() {
            @Override
            public void run() {
                // 打印从 0～9 和从 0～99 的区别
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                }
            }
        };
    }

    /**
     * 单个计数线程执行的情况
     */
    private static void singleThreadExecute() {
        Thread countThread = getCountThread();
        System.out.println("开始执行");
        countThread.start();
        System.out.println("结束执行");
    }

    /**
     * 两个计数线程执行的情况
     */
    private static void doubleThreadExecute() {
        Thread countThread1 = getCountThread();
        Thread countThread2 = getCountThread();
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
        List<Runnable> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Runnable countRunnable = getCountRunnable();
            list.add(countRunnable);
        }
        for (Runnable countRunnable : list) {
            new Thread(countRunnable).start();
        }
        System.out.println("结束执行");
    }



}
