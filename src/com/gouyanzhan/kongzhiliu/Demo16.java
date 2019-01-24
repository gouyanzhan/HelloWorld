package com.gouyanzhan.kongzhiliu;

public class Demo16 {
    public static void main(String[] args) {
        printDemo16();
    }

    private static void printDemo16() {
        for (int i = 0; i < 10; i++) {
            if (i < 5) {
                System.out.println("第" + i + "次循环");
            } else if (i == 5) {
                System.out.println("第" + i + "次循环,直接返回");
                return;
                //下面的语句永远不会执行
            } else {
                System.out.println("第" + i + "次循环");
            }
        }
    }
}
