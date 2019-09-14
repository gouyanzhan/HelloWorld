package com.gouyanzhan.ten.ThreadDemo6;

/**
 * @author Yanzhan Gou
 * @date 2019-08-21 17:59:02
 */
class SubThread extends Thread{
    //声明实现SubThread无参数构造方法
    SubThread(){}
        //声明实现SubThread带字符串参数构造方法
        SubThread(String Name){
        //调用父类的构造方法
        super(Name);
        }
    //重载run函数
    @Override
    public void run(){
        //循环计算输出的*数目
      for (int count = 1,row = 1;row < 10;row ++,count++){
          //循环输出指定的count数目的*
          for (int i = 0;i < count;i ++){
              //输出*
              System.out.println("*");
          }
          //try-catch块，用于捕获异常
          try {
              //线程休眠1秒钟
              Thread.sleep(1000);
              System.out.println("\t wait......");
          }
          //捕获异常InterruptedException
          catch (InterruptedException e){
              //异常抛出信息
              e.printStackTrace();
          }
          //输出换行符
          System.out.println();
      }
    }

}
