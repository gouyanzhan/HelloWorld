package com.siwuxie095.array;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {12, 11, 45, 6, 8, 43, 40, 57, 3, 20};
        System.out.println("排序前的数组：");
        printArr(arr);
        // 冒泡排序
        bubbleSort(arr);
        System.out.println("排序后的数组：");
        printArr(arr);
    }

    /**
     * 打印数组
     */
    private static void printArr(int[] arr) {
        // 打印
        for (int index = 0; index < arr.length; index++) {
            System.out.print(arr[index] + "   ");
        }
        // 换行
        System.out.println();
        System.out.println();
    }

    /**
     * 冒泡排序
     */
    private static void bubbleSort(int[] arr) {
        for (int outerIndex = 0; outerIndex < arr.length; outerIndex++) {
            for (int innerIndex = outerIndex; innerIndex < arr.length; innerIndex++) {
                System.out.println("outerIndex = " + outerIndex + "，innerIndex = " + innerIndex + "：当前外层循环元素 array[" + outerIndex + "] = " + arr[outerIndex] + "，当前内层循环元素 array[" + innerIndex + "] = " + arr[innerIndex]);
                boolean flag = false;
                if (arr[innerIndex] < arr[outerIndex]) {
                    flag = true;
                    swap(arr, innerIndex, outerIndex);
                }
                if (flag) {
                    System.out.println("发生了交换，此时 array[" + outerIndex + "] = " + arr[outerIndex] + "， array[" + innerIndex + "] = " + arr[innerIndex]);
                } else {
                    System.out.println("未发生交换，此时 array[" + outerIndex + "] = " + arr[outerIndex] + "， array[" + innerIndex + "] = " + arr[innerIndex]);
                }
                System.out.println();
            }

            System.out.println("已排序队列：" + getArrStr(arr, 0, outerIndex + 1));
            System.out.println("未排序队列：" + getArrStr(arr, outerIndex + 1, arr.length));
            System.out.println("--------------------  分割线 --------------------");
            System.out.println();
        }
    }

    /**
     * 交换两个位置的元素
     * @param arr 数组
     * @param index1 索引1（位置1）
     * @param index2 索引2（位置2）
     */
    private static void swap(int[] arr, int index1, int index2) {
        int temp;
        temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    private static String getArrStr(int[] arr, int from, int to) {
        String str = "";
        for (int index = from; index < to; index++) {
            str  = str + arr[index] + " ";
        }
        return str;
    }
}
