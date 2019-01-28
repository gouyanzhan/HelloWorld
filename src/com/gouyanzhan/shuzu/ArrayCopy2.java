package com.gouyanzhan.shuzu;

public class ArrayCopy2 {
    public static void main(String[] args) {
        //创建两个数组
        int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] array2 = new int[20];

        initArr(array2);

        System.arraycopy(array1, 0, array2, 10, array1.length);

        printArr(array2);

    }

    private static void initArr(int[] arr) {
        boolean flag = checkArr(arr);
        if (flag) {
            return;
        }
        if (arr.length < 10) {
            System.out.println("数组长度必须大于等于10，否则将发生数组越界");
            return;
        }
        for (int i = 0; i < 10; i++) {
            arr[i] = 10 * i;
        }
    }

    private static boolean checkArr(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组不能为空，且其中必须有元素");
            return true;
        }
        return false;
    }

    private static void printArr(int[] arr) {
        boolean flag = checkArr(arr);
        if (flag) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
