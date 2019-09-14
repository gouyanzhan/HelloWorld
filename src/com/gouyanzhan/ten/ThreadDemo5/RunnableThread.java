package com.gouyanzhan.ten.ThreadDemo5;

/**
 * @author Yanzhan Gou
 * @date 2019-08-21 17:55:08
 */
class RunnableThread implements Runnable{
    //重载run函数
    @Override
    public void run(){
        System.out.println("RunnableThread 启动");
    }
}
