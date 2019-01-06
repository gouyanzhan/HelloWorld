package com.gouyanzhan.exercise;

public class ZiZengJian {
    public static void main(String[]args){
        byte b1 = 5;  //定义一个byte类型的变量
        byte b2 =(byte)(b1 + 1);  //进行强制类型转换
        System.out.println("使用加运算符的结果是" + b2 );
        byte b3 = 5;  //定义一个byte类型的变量
        byte b4 = ++b3;  //进行自增运算，不需要强制转换
        System.out.println("使用自增运算符的结果是" + b4);
        int a= 5;  // 定义两个值相同的变量
        int b =5;
        int x =2 * ++a;
        int y =2 * b++;
        System.out.println("自增运算符前缀运算后 a="+a+"表达式x=" + x);
        System.out.println("自增运算符后缀运算后 b="+b+"表达式y=" + y);



    }
}
