package com.siwuxie095.forme.algorithm.chapter4th.question15th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-04-08 16:02:38
 */
public class Jump {

    public static int jump(int[] arr) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        int jump = 0;
        int curr = 0;
        int next = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (curr < i) {
                jump++;
                curr = next;
            }
            next = Math.max(next, i + arr[i]);
        }
        return jump;
    }

}
