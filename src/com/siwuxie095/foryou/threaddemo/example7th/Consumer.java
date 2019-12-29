package com.siwuxie095.foryou.threaddemo.example7th;

/**
 * 消费者
 *
 * @author Jiajing Li
 * @date 2019-12-28 17:11:39
 */
class Consumer extends Thread {

    private Queue queue;

    Consumer(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                queue.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
