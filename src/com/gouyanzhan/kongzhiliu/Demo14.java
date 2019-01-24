package com.gouyanzhan.kongzhiliu;

public class Demo14 {
    public static void main(String[] args) {
        printDemo14();
    }

    private static void printDemo14() {
        for (int i = 1; i < 51; i++) {
            System.out.print(i + " ");
            if (i % 5 == 0) {
                System.out.println("*****");
            }
        }
    }
}
