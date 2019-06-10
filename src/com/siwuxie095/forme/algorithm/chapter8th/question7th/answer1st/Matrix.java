package com.siwuxie095.forme.algorithm.chapter8th.question7th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-05-27 16:48:21
 */
public class Matrix {

    public static boolean isContains(int[][] matrix, int K) {
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col > -1) {
            if (matrix[row][col] == K) {
                return true;
            } else if (matrix[row][col] > K) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }


}
