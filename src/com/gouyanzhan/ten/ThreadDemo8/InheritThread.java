package com.gouyanzhan.ten.ThreadDemo8;

/**
 * @author Yanzhan Gou
 * @date 2019-08-22 10:09:50
 */
class InheritThread extends Thread{
    @Override
    public void run(){
        System.out.println("InheritThread is running...");
        for (int i = 0;i < 10;i++){
            System.out.println("InheritThread: i="+i);
            try {
                Thread.sleep((int)Math.random()*1000);
            }
            catch (InterruptedException e)
            {}
        }
    }

}
