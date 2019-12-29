package com.siwuxie095.foryou.threaddemo.example5th;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiajing Li
 * @date 2019-12-28 16:06:28
 */
public class Main {

    /**
     * 线程的生命周期
     *
     * 创建：准备好一个多线程的对象
     * 就绪：调用 start() 方法，等待 CPU 进行调度
     * 运行：执行 run() 方法
     * 阻塞：暂时停止执行，可能将资源交给其他线程使用
     * 终止：线程销毁，也称 死亡
     *
     *
     * 线程的常用方法（线程的生命周期通过其中某些方法进行控制）：
     * （1）取得线程名称：getName()
     * （2）取得当前线程对象：currentThread()
     * （3）判断线程是否启动：isAlive()
     * （4）线程的强行运行：join()   （强行加入，其他线程被阻塞）
     * （5）线程的休眠：sleep()      （阻塞，时间到了继续运行）
     * （6）线程的礼让：yield()      （只是建议）
     *
     *
     * 线程优先级，也只是建议
     */
    public static void main(String[] args) throws InterruptedException {
        Thread mainThread = Thread.currentThread();
        System.out.println(mainThread.getName());
        mainThread.setName("主线程");
        System.out.println(mainThread.getName());
        System.out.println("是否活着：" + mainThread.isAlive());
        System.out.println("-----   我是分隔线   -----");
        //singleThreadExecute();
        //doubleThreadExecute();
        multiThreadExecute();
    }

    /**
     * 单个计数线程执行的情况
     */
    private static void singleThreadExecute() throws InterruptedException {
        CountThread countThread = new CountThread("计数线程");
        System.out.println("开始执行：" + countThread.getName());
        countThread.start();
        countThread.join();
        System.out.println("结束执行：" + countThread.getName());
    }

    /**
     * 两个计数线程执行的情况
     */
    private static void doubleThreadExecute() throws InterruptedException {
        CountThread countThread1 = new CountThread("计数线程A");
        CountThread countThread2 = new CountThread("计数线程B");
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
        for (int i = 0; i < 3; i++) {
            CountThread countThread = new CountThread("计数线程 " + (i + 1));
            list.add(countThread);
        }
        list.get(0).setPriority(Thread.MIN_PRIORITY);
        list.get(1).setPriority(Thread.NORM_PRIORITY);
        list.get(2).setPriority(Thread.MAX_PRIORITY);
        for (CountThread countThread : list) {
            countThread.start();
        }
        System.out.println("结束执行");
    }

}
