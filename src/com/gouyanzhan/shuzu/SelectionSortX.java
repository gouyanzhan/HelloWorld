package com.gouyanzhan.shuzu;


import org.junit.Test;

/**
 * 选择排序：主要是找到当前最小元素对应的索引（简称最小索引）
 *
 * 先看第一个位置的元素，依次向后比对，找到最小元素后，二者交换位置
 * 再看第二个位置的元素，依次向后比对，找到最小元素后，二者交换位置
 * ...
 */
public class SelectionSortX {

    public static void main(String[] args) {
        int[] arr = {12, 11, 45, 6, 8, 43, 40, 57, 3, 20};
        System.out.println("排序前的数组：");
        printArr(arr);
        // 选择排序
        selectionSort(arr);
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
     * 选择排序
     */
    private static void selectionSort(int[] arr) {
        // 最小元素对应的索引，简称最小索引
        int minIndex;
        for (int outerIndex = 0; outerIndex < arr.length; outerIndex++) {
            minIndex = outerIndex;
            for (int innerIndex = outerIndex; innerIndex < arr.length; innerIndex++) {
                if (arr[innerIndex] < arr[minIndex]) {
                    minIndex = innerIndex;
                }
                System.out.println("outerIndex = " + outerIndex + "，innerIndex = " + innerIndex + "：当前内层循环元素 arr[" + innerIndex + "] = " + arr[innerIndex] + "，当前最小元素 arr[" + minIndex + "] = " + arr[minIndex]);
            }
            System.out.println("第" + (outerIndex + 1) + "次外层循环结束，第 "+ (outerIndex + 1) +" 小元素是 arr[" + minIndex + "] = " + arr[minIndex]);
            System.out.println("交换外层循环元素 arr["+outerIndex+"] = "+ arr[outerIndex] + "，和当前最小元素 arr[" + minIndex + "] = " + arr[minIndex]);
            System.out.println("交换前：arr["+outerIndex+"] = "+ arr[outerIndex] + "，arr[" + minIndex + "] = " + arr[minIndex]);
            // 交换两个位置的元素
            swap(arr, outerIndex, minIndex);
            System.out.println("交换后：arr["+outerIndex+"] = "+ arr[outerIndex] + "，arr[" + minIndex + "] = " + arr[minIndex]);
            System.out.println("已排序队列：" + getArrStr(arr, 0, outerIndex + 1));
            System.out.println("未排序队列：" + getArrStr(arr, outerIndex + 1, arr.length));
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

    @Test
    public void testSwap(){
        int[] arr = new int[3];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        int a = 0;
        int b = 2;
        printArr(arr);
        swap(arr, a, b);
        printArr(arr);
    }

    @Test
    public void testGetArrStr(){
        int[] arr = new int[3];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        String str = getArrStr(arr,0, 3);
        System.out.println(str);

    }
}

