package com.siwuxie095.foryou.threaddemo.example6th;

/**
 * @author Jiajing Li
 * @date 2019-12-28 16:52:06
 */
class TicketRunnable implements Runnable {

    private int ticket = 5;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                //sellTicketWithNoSync();
                sellTicketWithSync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void sellTicketWithNoSync() throws InterruptedException {
        if (ticket > 0) {
            Thread.sleep(1000);
            System.out.println("余票：" + ticket--);
        }
    }

    /**
     * 如果没有同步，则就会出现卖到 0 和 -1
     *
     * 出现这种情况的原因就是资源无法共享。要解决类似的资源共享的问题就要用到同步
     *
     * 设置同步后执行速度明显变慢，但是实现了资源共享
     */
    private synchronized void sellTicketWithSync() throws InterruptedException {
        if (ticket > 0) {
            Thread.sleep(1000);
            System.out.println("余票：" + ticket--);
        }
    }

}
