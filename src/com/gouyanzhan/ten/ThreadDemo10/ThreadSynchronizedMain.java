package com.gouyanzhan.ten.ThreadDemo10;

/**
 * @author Yanzhan Gou
 * @date 2019-08-22 15:45:29
 */
public class ThreadSynchronizedMain {
    public static void main(String[] args){
        ShareData oShare = new ShareData();
        ThreadDemo th1 = new ThreadDemo("Thread1",oShare);
        ThreadDemo th2 = new ThreadDemo("Thread2",oShare);
        th1.start();
        th2.start();

    }

}
