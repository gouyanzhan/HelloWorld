package com.gouyanzhan.ten.ThreadDemo5;

/**
 * @author Yanzhan Gou
 * @date 2019-08-21 17:55:14
 */
class SubThread extends Thread{
    SubThread(){}
    //声明并实现subThread带参数的构造方法
    SubThread(String Name){
        super(Name);
        }
        //重载run函数
    @Override
        public void run(){
            System.out.println("SubThread 启动");
        }
    }
