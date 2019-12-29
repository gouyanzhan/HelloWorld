package com.siwuxie095.foryou.threaddemo.example5th;

/**
 * 计数线程
 *
 * @author Jiajing Li
 * @date 2019-12-28 12:52:31
 */
class CountThread extends Thread {

    private String name;

    CountThread() {
    }

    CountThread(String name) {
        super(name);
        this.name = name;
    }

    /**
     * 声明线程的关键类 Thread，继承该类后，当前类即是一个线程。
     */
    @Override
    public void run() {
        // 打印从 0～9 和从 0～99 的区别
        for (int i = 0; i < 10; i++) {
            //try {
            //    Thread.sleep(3000);
            //} catch (InterruptedException e) {
            //    e.printStackTrace();
            //}
            System.out.println(name + " - " + i);
            //if (i == 3) {
            //    Thread.yield();
            //    System.out.println(name + " - 礼让");
            //}
        }
    }
}
