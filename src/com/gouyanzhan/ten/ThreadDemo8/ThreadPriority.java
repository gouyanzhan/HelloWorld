package com.gouyanzhan.ten.ThreadDemo8;

/**
 * @author Yanzhan Gou
 * @date 2019-08-22 10:16:12
 */
public class ThreadPriority {
    public static void main(String[] args){
        InheritThread itd = new InheritThread();
        Thread rtd = new Thread(new RunnableThread());
        itd.setPriority(5);
        rtd.setPriority(5);
        itd.start();
        rtd.start();
    }

}
