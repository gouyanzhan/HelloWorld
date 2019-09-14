package com.gouyanzhan.ten;

/**
 * @author Yanzhan Gou
 * @date 2019-08-07 18:04:50
 */
public class OnlyThread {
    public static void main(String[] args){
    //调用静态run()方法
        run();
    }
    //实现run()方法
    public static void run(){
        //循环计算输出的*数目
        for (int count = 1,row = 1;row < 10;row++,count++){
            //循环输出指定的count数目的*
            for (int i = 0;i < count;i++){
             //输出*号
                System.out.print('*');
            }
            //输出换行符
            System.out.println( );
        }
    }
}
