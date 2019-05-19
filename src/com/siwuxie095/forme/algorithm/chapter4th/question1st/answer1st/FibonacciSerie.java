package com.siwuxie095.forme.algorithm.chapter4th.question1st.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-03-31 18:09:53
 */
public class FibonacciSerie {


    //region 原问题

    /**
     * 时间复杂度为 O(2^N) 的方法
     */
    public static int fun1(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return fun1(n - 1) + fun1(n - 2);
    }

    /**
     * 时间复杂度为 O(N) 的方法
     */
    public static int fun2(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int res = 1;
        int pre = 1;
        int tmp = 0;
        for (int i = 3; i <= n; ++i) {
            tmp = res;
            res = res + pre;
            pre = tmp;
        }
        return res;
    }

    /**
     * 时间复杂度为 O(logN) 的方法
     */
    public static int fun3(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int[][] base = {{1, 1}, {1, 0}};
        int[][] res = matrixPower(base, n - 2);
        return res[0][0] + res[1][0];
    }

    //endregion


    //region 补充问题 1

    /**
     * 时间复杂度为 O(2^N) 的方法
     */
    public static int foo1(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return n;
        }
        return foo1(n - 1) + foo1(n - 2);
    }

    /**
     * 时间复杂度为 O(N) 的方法
     */
    public static int foo2(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return n;
        }
        int res = 2;
        int pre = 1;
        int tmp = 0;
        for (int i = 3; i <= n; ++i) {
            tmp = res;
            res = res + pre;
            pre = tmp;
        }
        return res;
    }

    /**
     * 时间复杂度为 O(logN) 的方法
     */
    public static int foo3(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return n;
        }
        int[][] base = {{1, 1}, {1, 0}};
        int[][] res = matrixPower(base, n - 2);
        return 2 * res[0][0] + res[1][0];
    }
    //endregion


    //region 补充问题 2

    /**
     * 时间复杂度为 O(2^N) 的方法
     */
    public static int bar1(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2 || n == 3) {
            return n;
        }
        return bar1(n - 1) + bar1(n - 3);
    }

    /**
     * 时间复杂度为 O(N) 的方法
     */
    public static int bar2(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2 || n == 3) {
            return n;
        }
        int res = 3;
        int pre = 2;
        int prepre = 1;
        int tmp1 = 0;
        int tmp2 = 0;
        for (int i = 4; i <= n; ++i) {
            tmp1 = res;
            tmp2 = pre;
            res = res + prepre;
            pre = tmp1;
            prepre = tmp2;
        }
        return res;
    }

    /**
     * 时间复杂度为 O(logN) 的方法
     */
    public static int bar3(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2 || n == 3) {
            return n;
        }
        int[][] base = {{1, 1, 0}, {0, 0, 1}, {1, 0, 0}};
        int[][] res = matrixPower(base, n - 3);
        return 3 * res[0][0] + 2 * res[1][0] + res[2][0];
    }
    //endregion


    private static int[][] matrixPower(int[][] m, int p) {
        int[][] res = new int[m.length][m[0].length];
        // 先把 res 设为单位矩阵，相当于整数中的 1
        for (int i = 0; i < res.length; ++i) {
            res[i][i] = 1;
        }
        int[][] tmp = m;
        for (; p != 0; p >>= 1) {
            if ((p & 1) != 0) {
                res = multiMatrix(res, tmp);
            }
            tmp = multiMatrix(tmp, tmp);
        }
        return res;
    }

    private static int[][] multiMatrix(int[][] m1, int[][] m2) {
        int[][] res = new int[m1.length][m2[0].length];
        for (int i = 0; i < m2[0].length; ++i) {
            for (int j = 0; j < m1.length; ++j) {
                for (int k = 0; k < m2.length; ++k) {
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return res;
    }

}
