package com.gouyanzhan.kongzhiliu;

public class Demo9 {
    public static void main(String[] args) {
        boolean b = true;
        System.out.println("循环 1");
        for (int i = 0; b; i++) {  //循环条件一直为true
            if (i == 5) { //当i的值为5时
                b = false;   //改变循环条件为false
            }
                System.out.println("i=" + i);
            }


        //int i = 0;
        //b = true;
        //System.out.println("循环2");
        //for (; b; ) {     //没有起始条件
        //    System.out.println("i=" + i);
        //    if (i == 5)
        //        b = false;
        //    i++;
        //}
        //System.out.println("循环3");
        //for (; ; ) {   //没有任何条件的for循环
        //}
    }
}
//该程序没有执行结束