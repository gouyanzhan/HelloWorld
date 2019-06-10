package com.siwuxie095.forme.algorithm.chapter8th.question11th.answer1st;

import java.util.HashMap;

/**
 * @author Jiajing Li
 * @date 2019-06-01 21:12:51
 */
public class Length {

    public static int maxLength(int[] arr, int k) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        // 重要
        map.put(0, -1);
        int len = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k)) {
                len = Math.max(i - map.get(sum - k), len);
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return len;
    }

}
