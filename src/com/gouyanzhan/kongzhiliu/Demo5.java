package com.gouyanzhan.kongzhiliu;

public class Demo5 {
    public static void main(String[] args) {
        int n = 10;
        doWhileLoop(n);
    }

    /**
     * 使用do-while语句
     * @param n
     */
    private static void doWhileLoop(int n){
        do {
            System.out.println("n=" +n );
            n--;
        }
        while (n>0);
    }
}
