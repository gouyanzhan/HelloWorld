package com.gouyanzhan.ten.ThreadDemo5;

/**
 * @author Yanzhan Gou
 * @date 2019-08-21 16:46:13
 */
public class ThreadStart {
    public static void main(String[] args){
        //创建并初始化RunnableThread 对象
        Runnable r = new RunnableThread();
        //创建并初始化线程对象rt
        Thread rt = new Thread(r);
        //启动线程
        rt.start();
        //创建并初始化SubThread对象
        SubThread st = new SubThread("SubThread");
        //启动线程
        st.start();
    }
}

