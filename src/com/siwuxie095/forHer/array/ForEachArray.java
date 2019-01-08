package com.siwuxie095.forHer.array;

/**
 * for 与 for each
 */
public class ForEachArray {

    public static void main(String[] args) {
        forEachArr();
        System.out.println();
        forEachMultiArr();
    }

    private static void forEachArr() {
        /*
         * 一维数组
         */
        double[] arr = new double[10];
        // 赋值 for
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 3 + 1;
        }
        // 打印 for each
        for (double val : arr) {
            System.out.print(val + "  ");
        }
    }

    private static void forEachMultiArr() {
        /*
         * 二维数组
         */
        String[][] multiArr = new String[7][7];
        // 赋值 for
        for (int i = 0; i < multiArr.length; i++) {
            for (int j = 0; j < multiArr[i].length; j++) {
                multiArr[i][j] = i + "-" + j;
            }
        }
        // 打印 for each
        for (String[] arr : multiArr) {
            for (String val : arr) {
                System.out.printf("%7s", val);
            }
            System.out.println();
        }
    }

}
