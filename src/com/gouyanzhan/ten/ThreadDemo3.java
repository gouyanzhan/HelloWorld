package com.gouyanzhan.ten;

/**
 * @author Yanzhan Gou
 * @date 2019-08-15 18:07:11
 */
 class ThreadDemo3 implements Runnable{
     //重载run函数
    @Override
    public void run(){
        //循环计算输出的*数目
        for (int count = 1,row =1;row <10;row++,count++){
            //循环输出指定的count数目的*
            for (int i = 0;i < count;i++){
                //输出*
                System.out.println("*");
            }
            //输出换行符
            System.out.println();
        }
    }
    public static void main(String[] args){
        //创建，并初始化ThreadDemo3对象rb
        Runnable rb = new ThreadDemo3();
        //通过Thread创建线程
        Thread td = new Thread(rb);
        //启动线程td
        td.start();
    }

}
