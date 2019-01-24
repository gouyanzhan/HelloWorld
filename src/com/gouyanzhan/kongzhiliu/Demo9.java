package com.gouyanzhan.kongzhiliu;

public class Demo9 {
    public static void main(String[] args) {
        boolean b = true;
        System.out.println("循环 1");
        //循环条件一直为true
        for (int i = 0; b; i++) {
            //当i的值为5时
            if (i == 5) {
            //改变循环条件为false
                b = false;
            }
                System.out.println("i=" + i);
            }


        int i = 0;
        b = true;
        System.out.println("循环2");
        //没有起始条件
        for (; b; ) {
            System.out.println("i=" + i);
            if (i == 5) {
                b = false;
            }
            i++;
        }
        System.out.println("循环3");
        //没有任何条件的for循环
        for (; ; ) {

        }
    }
}
//该程序没有执行结束