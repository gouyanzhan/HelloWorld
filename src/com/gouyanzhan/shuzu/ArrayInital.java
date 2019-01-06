package com.gouyanzhan.shuzu;

public class ArrayInital {
    public static void main(String[] args) {
        //创建一个int型数组
        int[] array1 = new int[5];
        //对数组元素赋值
        array1[0] = 1;
        array1[1] = 2;
        array1[2] = 3;
        array1[3] = 4;
        array1[4] = 5;
        //另一种数组创建的形式
        int[] array2 = {1, 2, 3, 4, 5};
        //打印出数组元素
        for (int i = 0; i < 5; i++) {
            System.out.println("array1 "+i+"=" + array1[i]);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("array2[i]=" + array2[i]);
        }

    }

}
