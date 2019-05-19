package com.siwuxie095.forme.algorithm.chapter4th.question2nd.answer2nd;

/**
 * @author Jiajing Li
 * @date 2019-04-01 22:31:44
 */
public class Path {

    public static int minPathSum(int[][] m) {
        if (null == m || m.length == 0 || null == m[0] || m[0].length == 0) {
            return 0;
        }
        // 行数与列数中较大的那个为 more
        int more = Math.max(m.length, m[0].length);
        // 行数与列数中较小的那个为 less
        int less = Math.min(m.length, m[0].length);
        // 行数是不是大于等于列数
        boolean  rowMore = (more == m.length);
        // 辅助数组的长度仅为行数与列数中的较小值
        int[] arr = new int[less];
        arr[0] = m[0][0];
        for (int i = 1; i < less; ++i) {
            arr[i] = arr[i - 1] + (rowMore ? m[0][i] : m[i][0]);
        }
        for (int i = 1; i < more; ++i) {
            arr[0] = arr[0] + (rowMore ? m[i][0] : m[0][i]);
            for (int j = 1; j < less; ++j) {
                arr[j] = Math.min(arr[j - 1], arr[j]) + (rowMore ? m[i][j] : m[j][i]);
            }
        }
        return arr[less - 1];
    }

}
