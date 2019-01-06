package com.gouyanzhan.shuzu;

public class Main2 {

    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        //int temp;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        swap(a , b);
        //temp = a;
        //a = b;
        //b = temp;

    }

    public static void swap(int a, int b){
        int temp;
        temp = a;
        a = b;
        b = temp;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}