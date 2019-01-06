package com.gouyanzhan.kongzhiliu;

public class Demo3 {
    public static void main(String[] args) {
        int n = 2;
        switch (n){
            //没有break语句的switch语句，注意它的执行结果
            case 0:
                System.out.println("case0执行");
            case 1:
                System.out.println("case1执行");
            case 2:
                System.out.println("case2执行");
            case 3:
                System.out.println("case3执行");
            case 4:
                System.out.println("case4执行");
            case 5:
                System.out.println("case5执行");
            case 6:
                System.out.println("case6执行");
                break;
            default:
                System.out.println("default执行");
        }

    }
}
