package com.gouyanzhan.shuzu;

public class BubbleSort {
    public static void main(String[] args) {
        int [] intArray ={12,11,45,6,8,43,40,57,3,20};
        System.out.println("排序前的数组：");
            for(int i = 0;i < intArray.length;i++){
                System.out.print(intArray[i] + " ");
            }
            System.out.println();
            int temp;
            for(int i = 0;i < intArray.length;i++){
                for (int j = i;j < intArray.length;i++){
                    if(intArray[j] < intArray[j]){
                        temp = intArray[i];
                        intArray[i] = intArray[j];
                        intArray[j] = temp;
                    }
                }
            }
            System.out.println("排序后的数组：");
            for(int i = 0;i < intArray.length;i++){
                System.out.println(intArray[i]+"   ");
            }


    }
}
