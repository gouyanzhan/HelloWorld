package com.siwuxie095.foryou.threaddemo.example7th;


/**
 * 共享队列
 *
 * @author Jiajing Li
 * @date 2019-12-28 17:11:15
 */
class Queue {

    /**
     * 队列中资源总和
     */
    private int sum = 0;

    public synchronized void put(int val) throws InterruptedException {
        if (!empty()) {
            System.out.println("队列不为空，生产者等待");
            wait();
        }
        sum += val;
        System.out.println("生产者本次生产的资源数量：" + val);
        notify();
    }

    public synchronized int get() throws InterruptedException {
        if (empty()) {
            System.out.println("队列为空，消费者等待");
            System.out.println("-----------------");
            wait();
        }
        sum--;
        System.out.println("消费者消费一个，剩余资源数量：" + sum);
        notify();
        return sum;
    }

    private boolean empty() {
        return sum == 0;
    }

}
