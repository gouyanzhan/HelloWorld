package com.gouyanzhan.shuzu;

public class Main {
    public static void main(String[] args) {
        int[] intArray = {12, 11, 45, 6, 8, 43, 40, 57, 3, 20};
        //int keyValue;
        int minIndex;
        int temp;
        System.out.println("排序前的数组：");
        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + "   ");
        }
        System.out.println();
        for (int i = 0; i < intArray.length; i++) {
            minIndex = i;
            //keyValue = intArray[i];
            for (int j = i + 1; j < intArray.length; j++) {
                System.out.println("第" + (i + 1) + "次外层循环，第" + (j + 1) + "次内层循环：当前最小元素（位置：" + minIndex + "）：" + intArray[minIndex] + "，内层元素（位置：" + j + "）：" + intArray[j]);
                if (intArray[j] < intArray[minIndex]) {
                    minIndex = j;
                    //keyValue = intArray[j];
                }
            }
            System.out.println("第" + (i + 1) + "次外层循环，最小索引" + minIndex + "，对应的元素：" + intArray[minIndex]);
            temp = intArray[i];
            intArray[i] = intArray[minIndex];
            intArray[minIndex] = temp;
        }
        System.out.println("排序后的数组");
        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + "   ");
        }

    }
}
