package com.gouyanzhan.kongzhiliu;

import org.junit.Test;

public class Demo4 {
    public static void main(String[] args) {
        //定义一个int型变量
        int n = 10;
        whileLoop(n);
    }

    private static void whileLoop(int n) {
        if (n <= 0){
            System.out.println("n要大于0");
            return;
        }
        //使用while循环，条件是n>0
        while (n > 0) {
            System.out.println("n=" + n);
            //把n的值减1
            n--;
        }
    }

    @Test
    public void testWhileLoop(){
        int n = 50;
        whileLoop(n);
        System.out.println();
        n = -1;
        whileLoop(n);
    }

}
