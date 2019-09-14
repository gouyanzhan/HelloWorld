package com.gouyanzhan.ten.ThreadDemo7;

/**
 * @author Yanzhan Gou
 * @date 2019-08-21 18:22:30
 */
class WaitThreadStop extends Thread {
    //声明并实现WaitThreadStop无参数构造方法
    WaitThreadStop(){}
    WaitThreadStop(String szName){
        super(szName);
    }
    @Override
    public void run(){
        for (int count = 1,row = 1;row < 10;row++,count++){
            for (int i = 0;i < count;i++){
                System.out.println("*");
            }
            System.out.println();
        }
    }
}
