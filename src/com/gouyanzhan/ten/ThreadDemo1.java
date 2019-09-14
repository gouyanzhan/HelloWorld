package com.gouyanzhan.ten;

/**
 * @author Yanzhan Gou
 * @date 2019-08-07 18:11:55
 */
class ThreadDemo1 extends Thread{
    //声明ThreadDemo1构造方法
    ThreadDemo1(){}
    //声明ThreadDemo1带参数的构造方法
    ThreadDemo1(String szName){
    //调用父类的构造方法
        super(szName);
    }
    //重载run函数
    @Override
    public void run(){
        //循环计算输出的*类目
        for (int count = 1,row = 1;row <10;row++, count++){
            //循环输出指定的count数目的*
            for (int i = 0;i < count;i++){
                //输出*
                System.out.print('*');
            }
            //输出换行符
            System.out.println();
        }
    }
    public static void main(String[] args){
        //创建，并初始化ThreadDemo1类型对象td
        ThreadDemo1 td = new ThreadDemo1();
        //调用start()方法执行一个新的线程
        td.start();
    }
}
