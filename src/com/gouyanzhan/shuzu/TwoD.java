package com.gouyanzhan.shuzu;

public class TwoD {
    public static void main(String[] args) {
        //创建一个二维int型数组
        int[][] twoD1 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        //另一种创建方式
        int[][] twoD2 = new int[5][5];
        int k = 1;
        for (int i = 0; i < twoD2.length; i++) {
            for (int j = 0; j < twoD2[i].length; j++) {
                twoD2[i][j] = k++;
            }
        }
        System.out.println("输出数组twoD1：");
        //使用双重循环访问数组
        //for (int i = 0;i < twoD1.length;i++){
        //    for (int j = 0;j < twoD1[i].length;j++){
        //        System.out.print(twoD1[i][j]+"    ");
        //    }
        //    System.out.println();
        //}
        printTwoD(twoD1);
        System.out.println("输出数组 twoD2:");
        //for (int i = 0;i < twoD2.length;i++){
        //    for (int j = 0;j < twoD2[i].length;j++){
        //        System.out.print(twoD2[i][j]+"  ");
        //    }
        //    System.out.println();
        //}
        printTwoD(twoD2);
    }

    public static void printTwoD(int[][] twoD) {
        for (int i = 0; i < twoD.length; i++) {
            for (int j = 0; j < twoD[i].length; j++) {
                //System.out.print(twoD[i][j]+"  ");
                System.out.printf("%20s", twoD[i][j]);
            }
            System.out.println();
        }
    }
}
