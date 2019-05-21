package com.gouyanzhan.assignment.assign001;

/**
 * @author Yanzhan Gou
 * @date 2019-05-20 15:47:06
 */
public class MyMath {
    int a;
    int b;
    int p;
    int m;
    int j;
    int r;
    public void plus(int a,int b){
        p = a + b;
        System.out.println("两数之和为：" + p);
    }
    public void minus(int a,int b){
        m = a - b;
        System.out.println("两数相减为：" + m);
    }
    public void multiply(int a,int b){
        j = a * b;
        System.out.println("两数之积为：" + j);
    }
    public void remove (int a,int b){
        if (b != 0 ){
            r= a / b;
            System.out.println("两数相除为：" + r);
        }else{
            System.out.println("除数不能为0");
        }
    }




}
