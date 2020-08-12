package com.siwuxie095.forme.test.test046;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Jiajing Li
 * @date 2020-08-12 14:41:48
 */
public class Main {

    /**
     * 说明的问题：
     * 1、ThreadLocal 变量在线程池的情况下，需要及时清理，否则该线程被回收后，
     * TheadLocal 变量依然存在，下次再使用时，会导致数据错乱。
     */
    public static void main(String[] args) throws InterruptedException {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

        ExecutorService pool = new ThreadPoolExecutor(
                1,
                1,
                50000L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024),
                new ThreadFactory() {
                    private AtomicInteger number = new AtomicInteger(0);
                    @Override
                    public Thread newThread(Runnable runnable) {
                        return new Thread(runnable, "threadName" + "-" + number.getAndIncrement());
                    }
                },
                new ThreadPoolExecutor.AbortPolicy());



        pool.execute(()->{
            System.out.println(Thread.currentThread().getName());
            threadLocal.set(5);
            System.out.println(threadLocal.get());
        });


        Thread.sleep(3000);
        System.out.println("-------------------");


        pool.execute(()->{
            System.out.println(Thread.currentThread().getName());
            System.out.println(threadLocal.get());
            threadLocal.remove();
        });

        Thread.sleep(3000);
        System.out.println("-------------------");

        pool.execute(()->{
            System.out.println(Thread.currentThread().getName());
            System.out.println(threadLocal.get());
        });
    }

}
