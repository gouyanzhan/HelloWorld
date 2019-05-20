package com.siwuxie095.forme.algorithm.chapter8th.question2nd.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-05-20 22:31:49
 */
public class Rotate {

    public static void rotate(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR < dR) {
            rotateEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    private static void rotateEdge(int[][] m, int tR, int tC, int dR, int dC) {
        // times 就是总的组数
        int times = dC - tC;
        int tmp = 0;
        // 一次循环就是一组占据调整
        for (int i = 0; i != times; i++) {
            tmp = m[tR][tC + i];
            m[tR][tC + i] = m[dR - i][tC];
            m[dR][dC - i] = m[tR + i][dC];
            m[tR + i][dC] = tmp;
        }
    }

}
