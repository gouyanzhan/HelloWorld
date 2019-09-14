package com.gouyanzhan.ten.ThreadDemo8;

/**
 * @author Yanzhan Gou
 * @date 2019-08-22 10:13:05
 */
class RunnableThread implements Runnable {
    public void run(){
        System.out.println("Runnablethread is running...");
        for (int i = 0;i < 10;i++){
            System.out.println("RunnableThread: i=" + i);
            try {
                Thread.sleep((int)Math.random()*1000);
            }
            catch (InterruptedException e){

            }
        }
    }

}
