package com.gouyanzhan.shuzu;

import java.util.Scanner;

public class AverageTemperaturesDemo {
    public static void main(String[] args) {
        //声明用到的变量
        int count;
        double sum, average;
        sum = 0;
        double[] temperature = new double[7];
        //创建一个Scanner类的对象，用它来获得用户的输入
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入七天的温度：");
        for (count = 0; count < temperature.length; count++) {
            //读取用户输入
            temperature[count] = sc.nextDouble();
            sum += temperature[count];
        }
        average = sum / 7;
        System.out.println("平均气温为：" + average);
        //比较各天气温与平均气温
        for (count = 0; count < temperature.length; count++) {
            if (temperature[count] < average) {
                System.out.println("第" + (count + 1) + "天气温低于平均气温");
            } else if (temperature[count] > average) {
                System.out.println("第" + (count + 1) + "天气温高于平均气温");
            } else {
                System.out.println("第" + (count + 1) + "天气温等于平均气温");
            }
        }


    }
}
