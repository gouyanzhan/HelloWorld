package com.siwuxie095.foryou.threaddemo.example7th;

/**
 * @author Jiajing Li
 * @date 2019-12-28 16:46:15
 */
public class Main {

    /**
     * 线程通信
     *
     * 生产者-消费者
     */
    public static void main(String[] args) {
        Queue queue = new Queue();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        producer.start();
        consumer.start();
    }

}
