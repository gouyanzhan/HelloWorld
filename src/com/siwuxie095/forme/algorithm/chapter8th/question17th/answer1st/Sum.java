package com.siwuxie095.forme.algorithm.chapter8th.question17th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-06-09 18:40:01
 */
public class Sum {

    public static int maxSum(int[][] m) {
        if (null == m || m.length == 0 || m[0].length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int cur = 0;
        // 累加数组
        int[] s = null;
        for (int i = 0; i != m.length; i++) {
            s = new int[m[0].length];
            for (int j = i; j != m.length; j++) {
                cur = 0;
                for (int k = 0; k != s.length; k++) {
                    s[k] += m[j][k];
                    cur += s[k];
                    max = Math.max(max, cur);
                    cur = cur < 0 ? 0 : cur;
                }
            }
        }
        return max;
    }

}
