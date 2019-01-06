package com.gouyanzhan.shuzu;

public class SelectionSort {
    public static void main(String[] args) {
        int[] intArray = {12, 11, 45, 6, 8, 43, 40, 57, 3, 20};
        int keyValue;
        int index;
        int temp;
        System.out.println("排序前的数组：");
        printArray(intArray);
        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + "   ");
        }
        System.out.println();
        for (int i = 0; i < intArray.length; i++) {
            index = i;
            keyValue = intArray[i];
            for (int j = i; j < intArray.length; j++) {
                if (intArray[j] < keyValue) {
                    index = j;
                    keyValue = intArray[j];
                }
            }
            temp = intArray[i];
            intArray[i] = intArray[index];
            intArray[index] = temp;
        }
        System.out.println("排序后的数组");
        printArray(intArray);
        //for (int i = 0; i < intArray.length; i++) {
        //    System.out.print(intArray[i] + "   ");
        //}

    }

    /**
     * 对传入进来的数组，循环打印数组的每一个元素
     *
     * @param intArray int型数组
     */
    public static void printArray(int[] intArray){
        for (int i = 0; i < intArray.length; i++){
            System.out.print(intArray[i] + "  ");
        }
    }
}

