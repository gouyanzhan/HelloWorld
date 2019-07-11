package com.gouyanzhan.assignment.assign002;

/**
 * @author Yanzhan Gou
 * @date 2019-06-10 20:49:11
 */
public class Number {
    private int n1;
    private int n2;
    int z;
    public Number(int n1,int n2){
        this.n1 = n1;
        this.n2 = n2;
    }
    public void addition(){
        z = n1 + n2;
        System.out.println(z);
    }
    public void subtration(){
        z = n1 - n2;
        System.out.println(z);
    }
    public void multiplication(){
        z = n1 * n2;
        System.out.println(z);
    }
    public void division(){
        z = n1 / n2;
        System.out.println(z);
    }

}

//9、编写Java程序模拟简单的计算器。 定义名为Number的类其中有两个整型数据成员n1和n2应声明为私有。编写构造方法赋予n1和n2初始值再为该类定
// 义加addition、减subtration、乘multiplication、除division等公有成员方法分别对两个成员变量执行加、减、乘、除的运算。 在main方法中创
// 建Number类的对象调用各个方法并显示计算结果。