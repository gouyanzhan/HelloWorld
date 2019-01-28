package com.gouyanzhan.shuzu;

public class ArrayCopy {
    public static void main(String[] args) {
        //创建两个数组
        int[] array1 = {1, 2, 3};
        int[] array2 = {4, 5, 6};
        System.out.println("两个数组的初值：");
        printArr(array1, "array1");
        System.out.println();
        printArr(array2, "array2");
        System.out.println();

        array1 = array2;
        //打印出两个数组的元素
        System.out.println("执行数组拷贝后两个数组的值：");
        printArr(array1, "array1");
        System.out.println();
        printArr(array2, "array2");
        System.out.println();

        System.out.println("改变array2[0]的值");
        array2[0] = 10;

        //打印出改变后的元素值
        System.out.println("array1[0] = " + array1[0]);
        System.out.println("array2[0] = " + array2[0]);


    }

    private static void printArr(int[] arr, String arrName) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组不能为空，且其中必须有元素");
            return;
        }
        if (arrName == null || arrName.length() == 0) {
            System.out.println("数组名称不能为空，且长度必须大于0");
            return;
        }
        for (int i = 0; i < arr.length; ++i) {
            System.out.println(arrName + "[" + i + "] = " + arr[i]);
        }
    }
}
