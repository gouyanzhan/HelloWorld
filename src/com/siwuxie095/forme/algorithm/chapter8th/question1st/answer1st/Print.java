package com.siwuxie095.forme.algorithm.chapter8th.question1st.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-05-19 20:30:10
 */
public class Print {

    public static void spiralOrderPrint(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR <= dR && tC <= dC) {
            printEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    private static void printEdge(int[][] m, int tR, int tC, int dR, int dC) {
            // 子矩阵只有一行时
        if (tR == dR) {
            for (int i = tC; i <= dC; i++) {
                System.out.print(m[tR][i] + " ");
            }
            // 子矩阵只有一列时
        } else if (tC == dC) {
            for (int i = tR; i <= dR; i++) {
                System.out.print(m[i][tC] + " ");
            }
            // 一般情况
        } else {
            int currC = tC;
            int currR = tR;
            while (currC != dC) {
                System.out.print(m[tR][currC] + " ");
                currC++;
            }
            while (currR != dR) {
                System.out.print(m[currR][dC] + " ");
                currR++;
            }
            while (currC != tC) {
                System.out.print(m[dR][currC] + " ");
                currC--;
            }
            while (currR != tR) {
                System.out.print(m[currR][tC] + " ");
                currR--;
            }
        }
    }

}
