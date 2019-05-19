package com.siwuxie095.forme.algorithm.chapter4th.question17th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-04-08 16:49:50
 */
public class Number {

    //region Description

    public static int num1(int n) {
        if (n < 1) {
            return 0;
        }
        int[] recordArr = new int[n];
        return process1(0, recordArr, n);
    }

    private static int process1(int i, int[] recordArr, int n) {
        if (i == n) {
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; ++j) {
            if (isValid(recordArr, i, j)) {
                recordArr[i] = j;
                res += process1(i + 1, recordArr, n);
            }
        }
        return res;
    }

    private static boolean isValid(int[] recordArr, int i, int j) {
        for (int k = 0; k < i; ++k) {
            if (j == recordArr[k] || Math.abs(recordArr[k] - j) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }
    //endregion

    //region Description

    public static int num2(int n) {
        /*
         * 因为本方法中位运算的载体是 int 型变量，所以该方法只能算 1～32 皇后问题。
         * 如果想计算更多的皇后问题，需使用包含更多位的变量。
         */
        if (n < 1 || n > 32) {
            return 0;
        }
        int upperLim = (n == 32) ? -1 : ((1 << n) - 1);
        return process2(upperLim, 0, 0, 0);
    }

    private static int process2(int upperLim, int colLim, int leftDiaLim, int rightDiaLim) {
        if (colLim == upperLim) {
            return 1;
        }
        int pos= 0;
        int mostRightOne = 0;
        pos = upperLim & (~(colLim | leftDiaLim | rightDiaLim));
        int res = 0;
        while (pos != 0) {
            mostRightOne = pos & (~pos + 1);
            pos = pos - mostRightOne;
            res += process2(upperLim, colLim | mostRightOne, (leftDiaLim | mostRightOne) << 1, (rightDiaLim | mostRightOne) >>> 1);
        }
        return res;
    }
    //endregion

}
