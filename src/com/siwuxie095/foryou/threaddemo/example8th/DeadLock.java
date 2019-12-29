package com.siwuxie095.foryou.threaddemo.example8th;

/**
 * @author Jiajing Li
 * @date 2019-12-28 17:36:16
 */
public class DeadLock extends Thread {

    private static boolean flag = true;

    private static Object FIRST = new Object();

    private static Object SECOND = new Object();

    private String name;

    public DeadLock(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            if (flag) {
                    accessFirst();
            } else {
                accessSecond();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 访问第一个对象
     */
    private void accessFirst() throws InterruptedException {
        flag = false;
        synchronized (FIRST) {
            System.out.println(name + " - 获得了第一个对象的锁");
            Thread.sleep(1000);
            System.out.println(name + " - 还想获得第二个对象的锁");
            synchronized (SECOND) {
                System.out.println(name + " - 获得了第二个对象的锁");
            }
        }
    }

    /**
     * 访问第二个对象
     */
    private void accessSecond() throws InterruptedException {
        flag = true;
        synchronized (SECOND) {
            System.out.println(name + " - 获得了第二个对象的锁");
            Thread.sleep(1000);
            System.out.println(name + " - 还想获得第一个对象的锁");
            synchronized (FIRST) {
                System.out.println(name + " - 获得了第一个对象的锁");
            }
        }
    }
}
