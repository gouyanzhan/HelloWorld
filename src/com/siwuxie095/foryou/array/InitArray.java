package com.siwuxie095.foryou.array;

/**
 * 数组初始化，两种方式
 *
 * 数组在声明时，必须先固定容量
 *
 * 数组下标也称索引、也称位置
 */
public class InitArray {

    public static void main(String[] args) {
        // 静态初始化，固定容量的同时赋值
        int[] arr1 = {1, 2, 3, 4, 5};
        System.out.println("arr1的长度（容量）：" + arr1.length);
        printArr(arr1);
        // todo
        // 动态初始化（有new关键字），先固定容量
        int[] arr2 = new int[5];
        System.out.println("arr2 的长度（容量）：" + arr2.length);
        printArr(arr2);
        // 再赋值
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i + 6;
        }
        printArr(arr2);
        // todo
    }

    /**
     * 打印数组
     *
     * val 是 value 的缩写，arr 是 array 的缩写
     */
    private static void printArr(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

}
