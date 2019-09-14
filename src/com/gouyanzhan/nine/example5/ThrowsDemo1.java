package com.gouyanzhan.nine.example5;

/**
 * @author Yanzhan Gou
 * @date 2019-08-07 14:30:27
 */
public class ThrowsDemo1 {
    static int amethod(int a,int b){
        if (b == 0){
            throw new ArithmeticException();
        }else{
            return a/b;
        }
    }
    public static void main(String[] args){
        System.out.println(amethod(15,5));
        System.out.println(amethod(15,0));
    }

}
