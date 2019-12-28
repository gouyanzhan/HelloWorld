package com.siwuxie095.foryou.threaddemo.example6th;

/**
 * @author Jiajing Li
 * @date 2019-12-28 16:45:38
 */
public class Main {

    /**
     * 线程同步
     *
     * 关键字 synchronized 同步锁，对临界资源（共享资源）进行保护
     *
     * 以抢票为例
     */
    public static void main(String[] args) {
        TicketRunnable ticketRunnable = new TicketRunnable();

        // 3 个线程代表三个售票窗口
        new Thread(ticketRunnable).start();
        new Thread(ticketRunnable).start();
        new Thread(ticketRunnable).start();
    }

}
