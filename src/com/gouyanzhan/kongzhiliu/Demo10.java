package com.gouyanzhan.kongzhiliu;

public class Demo10 {
    public static void main(String[] args) {
       useBreak();
    }

    public static void useBreak(){
        System.out.println("使用break的例子");
        for (int i = 0; i < 50; i++) {
            System.out.println("i=" + i);
            //当n等于10的时候，跳出循环语句
            if (i == 10) {
                break;
            }
        }
    }
}
