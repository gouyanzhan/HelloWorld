package com.siwuxie095.foryou.threaddemo.example7th;

/**
 * 生产者
 *
 * @author Jiajing Li
 * @date 2019-12-28 17:11:06
 */
class Producer extends Thread {

    private Queue queue;

    Producer(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                queue.put(i + 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
