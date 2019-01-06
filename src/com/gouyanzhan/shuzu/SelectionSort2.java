package com.gouyanzhan.shuzu;

public class SelectionSort2 {

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
                if (intArray[j] < intArray[i]) {
                    minIndex = j;
                    System.out.println();
                    //keyValue = intArray[j];
                }
            }
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
