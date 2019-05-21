package com.siwuxie095.forme.algorithm.chapter8th.question3rd.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-05-21 22:41:47
 */
public class Print {

    public static void printMatrixZigZag(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = 0;
        int dC = 0;
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        boolean fromUp = false;
        while (tR != endR + 1) {
            printLevel(matrix, tR, tC, dR, dC, fromUp);
            tR = (tC == endC) ? tR + 1 : tR;
            tC = (tC == endC) ? tC : tC + 1;
            dC = (dR == endR) ? dC + 1 : dC;
            dR = (dR == endR) ? dR : dR + 1;
            fromUp = !fromUp;
        }
        System.out.println();
    }

    private static void printLevel(int[][] m, int tR, int tC, int dR, int dC, boolean f) {
        if (f) {
            while (tR != dR + 1) {
                System.out.print(m[tR++][tC--] + " ");
            }
        } else {
            while (dR != tR - 1) {
                System.out.print(m[dR--][dC++] + " ");
            }
        }
    }

}
