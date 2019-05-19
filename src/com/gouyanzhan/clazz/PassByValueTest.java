package com.gouyanzhan.clazz;

import org.junit.Test;

/**
 * @author Yanzhan Gou
 * @date 2019-03-02 22:43:57
 */
public class PassByValueTest {
    public static void main(String[] args){
        int a = 1;
        int b = 2;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("------------");
        swapVal(a,b);
        System.out.println("------------");
        System.out.println("a = " + a);
        System.out.println("b = " + b);

    }

    public static void swapVal(int a,int b){
        int c;
        c = a;
        a = b;
        b = c;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    @Test
    public void testSwapVal(){
        int[] arr = new int[]{1,2};
        swapVal(arr[0],arr[1]);
        System.out.println(arr[0]);
        System.out.println(arr[1]);
    }
}
