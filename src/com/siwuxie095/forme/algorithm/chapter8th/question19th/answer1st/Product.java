package com.siwuxie095.forme.algorithm.chapter8th.question19th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-06-09 21:16:41
 */
public class Product {

    public static double maxProduct(double[] arr) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        double max = arr[0];
        double min = arr[0];
        double res = arr[0];
        double maxEnd = 0;
        double minEnd = 0;
        for (int i = 1; i < arr.length; i++) {
            maxEnd = max * arr[i];
            minEnd = min * arr[i];
            max = Math.max(Math.max(maxEnd, minEnd), arr[i]);
            min = Math.min(Math.min(maxEnd, minEnd), arr[i]);
            res = Math.max(res, max);
        }
        return res;
    }

}
