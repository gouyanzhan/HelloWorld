package com.gouyanzhan.shuzu;
/**
 * 多维数组 Multiply Dimension Array
 */
public class MultiArray {

    public static void main(String[] args) {
        // 不规则的二维数组（静态初始化）
        int[][] multiArr1 = {{1}, {1, 2}, {1, 2, 4}};
        printMultiArr(multiArr1);
        System.out.println("------------ 分割线 ------------");
        // 规则的二维数组（动态初始化）
        int[][] multiArr2 = new int[9][9];
        // 赋值
        for (int i = 0; i < multiArr2.length; i++) {
            for (int j = 0; j < multiArr2[i].length; j++) {
                if (i >= j) {
                    multiArr2[i][j] = (i + 1) * (j + 1);
                }
            }
        }
        printMultiArr(multiArr2);
    }

    private static void printMultiArr(int[][] multiArr) {
        for (int i = 0; i < multiArr.length; i++) {
            for (int j = 0; j < multiArr[i].length; j++) {
                System.out.printf("%7s", multiArr[i][j]);
            }
            // 换行
            System.out.println();
        }
    }

}
