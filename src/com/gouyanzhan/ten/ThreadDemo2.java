package com.gouyanzhan.ten;

/**
 * @author Yanzhan Gou
 * @date 2019-08-15 16:41:12
 */
class ThreadDemo2 extends Thread{
    //声明无参数，空构造方法
    ThreadDemo2(){}
        //声明带有字符串参数的构造方法
        ThreadDemo2(String szName) {
            //调用父类的构造方法
            super(szName);
        }
        //重载run函数
    @Override
        public void run(){
            //循环计算输出的*数目
            for (int count = 1,row = 1;row <10;row++,count++){
                for (int i = 0;i < count;i++){
                    System.out.println("*");
                }
                System.out.println();
            }
            }
            public static void main(String[] args){
            ThreadDemo2 td1 = new ThreadDemo2();
            ThreadDemo2 td2 = new ThreadDemo2();
            ThreadDemo2 td3 = new ThreadDemo2();
            td1.start();
            td2.start();
            td3.start();
            }




}
