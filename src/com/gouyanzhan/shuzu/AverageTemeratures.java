package com.gouyanzhan.shuzu;

import java.util.Scanner;

public class AverageTemeratures {
    public static void main(String[] args) {
        int count;
        double next,sum,average;
        sum =0;
        //创建一个scanner对象
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入七天的温度：");
        for (count=0;count<7;count++){
            //通过Scanner对象获得用户输入
            next = sc.nextDouble();
            sum += next;
        }
        System.out.println("请输入七天的温度：");
        for (count=0;count<7;count++){
            //通过Scanner对象获得用户输入
            next = sc.nextDouble();
            sum += next;
        }
        System.out.println(sum);
        average= sum/7;
        System.out.println("平均气温为："+average);

    }
}
