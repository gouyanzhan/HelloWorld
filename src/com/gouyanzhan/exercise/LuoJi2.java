package com.gouyanzhan.exercise;

public class LuoJi2 {
    public static void main(String[]args){
        int a = 5;
        boolean b = (a<4)&&(a++<10);
        System.out.println("使用短路逻辑运算符的结果为" + b);
        System.out.println("a的结果为" +a );
    }
}
