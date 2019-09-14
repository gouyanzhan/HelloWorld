package com.gouyanzhan.ten;

/**
 * @author Yanzhan Gou
 * @date 2019-08-21 16:22:26
 */
class ThreadDemo4 implements Runnable{
    //重载run函数
    public void run(){
        for (int count = 1,row = 1;row < 10;row++,count++){
            for (int i = 0;i < count; i++){
                System.out.println("*");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        //创建，并初始化ThreadDemo4 对象 rb1
        Runnable rb1 = new ThreadDemo4();
        //创建，并初始化ThreadDemo4 对象 rb2
        Runnable rb2 = new ThreadDemo4();
        //创建，并初始化ThreadDemo4 对象 rb3
        Runnable rb3 = new ThreadDemo4();
        //创建线程对象td1
        Thread td1 = new Thread(rb1);
        //创建线程对象td2
        Thread td2 = new Thread(rb2);
        //创建线程对象td3
        Thread td3 = new Thread(rb3);
        //启动线程td1
        td1.start();
        //启动线程td2
        td2.start();
        //启动线程td3
        td3.start();
    }


}
