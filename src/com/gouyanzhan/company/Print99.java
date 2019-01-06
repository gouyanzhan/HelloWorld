package com.gouyanzhan.company;

public class Print99 {
    public static void main(String[] args) {
        System.out.print("                       九 九 乘 法 表 \n");
            for (int i = 1; i <= 9; i++) {
                for (int j = 1; j <= i; j++) {
                    // 打印结果
                    System.out.print(i + "*" + j + "=" + (i * j) + "\t");
                }
                // 换行
                System.out.print("\n");
            }
        }
    }

