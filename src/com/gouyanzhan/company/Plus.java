package com.gouyanzhan.company;

/**
 * @author Yanzhan Gou
 * @date 2019-01-10 23:28:23
 */
public class Plus {
    public static void main(String[] args){
    plus();
    }

    private static void plus(){
        int a = 5;
        System.out.println("a:"+a);
        System.out.println();
        int b = a++;
        System.out.println("b:"+b);
        System.out.println("a:"+a);
        System.out.println();
        int c = ++a;
        System.out.println("c:"+c);
        System.out.println("a:"+a);
    }

}
